package fr.dta.mediatic.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.dta.mediatic.utils.dao.AbstractDao;
import fr.dta.mediatic.utils.model.AbstractModel;

public class AbstractService<T extends AbstractModel, U extends AbstractDao<T>> {
	
	protected U dao;
	
	public U getDao() {
		return dao;
	}

	public void setDao(U dao) {
		this.dao = dao;
	}

	public void merge(T t){
		dao.merge(t);
	}
	
	public void getById(Long id){
		dao.getById(id);
	}
	
	public void delete(T t){
		dao.delete(t);
	}
	
	public List<T> getAll(){
		return dao.getAll();
	}
	
	public void add(T t){
		dao.add(t);
	}
}
