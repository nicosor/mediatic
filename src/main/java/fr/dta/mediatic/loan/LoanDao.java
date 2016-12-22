package fr.dta.mediatic.loan;

import fr.dta.mediatic.abstracts.AbstractDao;

public class LoanDao extends AbstractDao<Loan> {

	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
}
