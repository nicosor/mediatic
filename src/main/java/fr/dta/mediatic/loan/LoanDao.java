package fr.dta.mediatic.loan;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.dta.mediatic.abstracts.AbstractDao;

public class LoanDao extends AbstractDao<Loan> {

	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
	
	public List<Loan> getLoanForThisAdh(Long id){
		TypedQuery<Loan> query = super.getEntityManager().createQuery("select loan.id, media_id, adherent_id, loan_date, back_planed_date, is_back "
				+ "from media "
				+ "join loan on media.id = media_id "
				+ "where adherent_id =:adherent_id", Loan.class);
		query.setParameter("adherent_id", id);
		return query.getResultList();		
	}
}
