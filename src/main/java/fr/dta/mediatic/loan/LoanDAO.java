package fr.dta.mediatic.loan;

import fr.dta.mediatic.utils.dao.AbstractDao;

public class LoanDAO extends AbstractDao<Loan> {

	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
}
