package fr.dta.mediatic.adherent.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.loan.model.Loan;
import fr.dta.mediatic.utils.dao.AbstractDao;

public class AdherentDao extends AbstractDao<Adherent> {

	private static AdherentDao dao;
	
	private AdherentDao() {
		super();
	}
	
	public static AdherentDao instance() {
		if(dao==null) {
			dao = new AdherentDao();
		}
		return dao;
	}

	@Override
	protected Class<Adherent> getEntityClass() {
		return null;
	}
	
	private final String table = "Adherent";
	
	public List<Adherent> getAll(){
		return super.getAll(table);
	}
	
	public Adherent getById(int id){
		return super.getById(id, table);
	}
	
	public List<Loan> getLoanForThisAdh(Adherent adherent){
		TypedQuery<Loan> query = super.getEntityManager().createQuery("FROM loan WHERE adherent =:adherent", Loan.class);
		query.setParameter("adherent", adherent);
		return query.getResultList();
		
	}
}
