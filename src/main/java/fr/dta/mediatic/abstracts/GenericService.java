package fr.dta.mediatic.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.dta.mediatic.utils.dao.AbstractDao;

public class GenericService<T extends AbstractDao> {
	
	@Autowired
	public T dao;
	
	public void update(T t){
		dao.update(t);
	}
	
	public void getById(Long id, String table){
		dao.getById(id, table);
	}
	
	public void delete(T t){
		dao.delete(t);
	}
	
	public List<T> getAll(String table){
		return dao.getAll(table);
	}
	
	public void add(T t){
		dao.add(t);
	}
}
