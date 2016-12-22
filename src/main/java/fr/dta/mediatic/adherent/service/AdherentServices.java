package fr.dta.mediatic.adherent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.dta.mediatic.abstracts.AbstractService;
import fr.dta.mediatic.adherent.Adherent;
import fr.dta.mediatic.utils.dao.AbstractDao;

public class AdherentServices extends AbstractService<Adherent, AbstractDao<Adherent>>{
	
	@Autowired
	@Qualifier("adherentDao")
	@Override
	public void setDao(AbstractDao<Adherent> _dao) {
		this.dao = _dao;
	}
	
	public List<Adherent> getByPostalCode(int  code){
		return dao.findWhere(" postalcode = "+code);
	}
	
}
