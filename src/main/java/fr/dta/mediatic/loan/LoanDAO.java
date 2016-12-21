package fr.dta.mediatic.loan;

import java.util.List;

import fr.dta.mediatic.utils.dao.AbstractDao;

public class LoanDAO extends AbstractDao<Loan> {
	
	private static LoanDAO dao;
	
	private LoanDAO() {
		super();
	}
	
	public static LoanDAO instance() {
		if(dao == null)
			dao = new LoanDAO();
		
		return dao;
	}

	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
	
	private final String table ="Loan";
	
	public List<Loan> getAll() {
		return super.getAll(table);
	}
	
	public Loan getById(int id){
		return super.getById(id, table);
	}
	
}
