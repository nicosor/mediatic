package fr.dta.mediatic.abstracts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractDao<T extends AbstractModel> {
	
	@PersistenceContext
	EntityManager em;
	
	Class<T> entityClass;

	@PostConstruct 
	public void init()
	{
		entityClass = getEntityClass();
	}
	
	protected abstract Class<T> getEntityClass();
	
	public EntityManager getEntityManager() {
		return em;
	}

	protected Session getSession() {
		return em.unwrap(Session.class);
	}

	public void persist(Object entity) {
		em.persist(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
       return em.createQuery("select t from " + entityClass.getSimpleName() + " t ").getResultList();
	}
	
	public T getById(long id) {
		return em.find(entityClass, id);
	}
	
	public void delete(T t) {
		em.remove(getById(t.getId()));
	}
	
	public void truncate() {
		em.createQuery("delete from " + entityClass.getSimpleName() + " t ")
			.executeUpdate();
	}
	
	public void add(T t){
		persist(t);
	}
	
	public void merge(T t){
		em.merge(t);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findWhere(String where){
		  return em.createQuery("select t from " + entityClass.getSimpleName() + " t where " + where).getResultList();
	}
}
