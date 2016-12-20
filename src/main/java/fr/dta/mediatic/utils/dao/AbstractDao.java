package fr.dta.mediatic.utils.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

//import org.h2.engine.Session;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.utils.model.AbstractModel;

@Repository
@Transactional
public abstract class AbstractDao <T extends AbstractModel> {
	
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

	public List<T> getAll(String table) {
        TypedQuery<T> query = em.createQuery("FROM " + table, entityClass);
        return query.getResultList();
	}
	
	public T getById(long id, String table) {
		TypedQuery<T> query = em.createQuery("FROM " + table +" WHERE id =:id", entityClass);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public void delete(T b) {
		em.remove(em.find(b.getClass(), b.getId()));
	}
	
	public void add(T b){
		persist(b);
	}
	
	public void update(T b){
		em.merge(b);
	}
}
