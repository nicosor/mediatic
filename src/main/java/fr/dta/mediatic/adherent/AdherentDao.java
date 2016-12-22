package fr.dta.mediatic.adherent;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.loan.Loan;
import fr.dta.mediatic.utils.dao.AbstractDao;

@Repository
@Transactional
public class AdherentDao extends AbstractDao<Adherent> {

	@Override
	protected Class<Adherent> getEntityClass() {
		return null;
	}
	
	public List<Loan> getLoanForThisAdh(Adherent adherent){
		TypedQuery<Loan> query = super.getEntityManager().createQuery("FROM loan WHERE adherent =:adherent", Loan.class);
		query.setParameter("adherent", adherent);
		return query.getResultList();
		
	}
}
