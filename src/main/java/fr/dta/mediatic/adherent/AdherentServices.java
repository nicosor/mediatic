package fr.dta.mediatic.adherent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.dta.mediatic.abstracts.AbstractDao;
import fr.dta.mediatic.abstracts.AbstractService;

public class AdherentServices extends AbstractService<Adherent, AbstractDao<Adherent>>{
	
	@Autowired
	@Qualifier("adherentDao")
	@Override
	public void setDao(AbstractDao<Adherent> _dao) {
		this.dao = _dao;
	}
	
	public List<Adherent> getByPostalCode(int  code){
		return dao.findWhere(" postalcode = " + code);
	}
	
}
