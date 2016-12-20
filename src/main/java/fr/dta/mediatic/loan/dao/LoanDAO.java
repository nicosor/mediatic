package fr.dta.mediatic.loan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dta.mediatic.loan.model.Loan;
import fr.dta.mediatic.utils.dao.AbstractDao;
import fr.dta.mediatic.utils.dao.DatabaseHelper;

public class LoanDAO extends AbstractDao<Loan> {
	
	private static LoanDAO dao;
	
	private LoanDAO() {
		super(Loan.class);
	}
	
	public static LoanDAO instance() {
		if(dao == null)
			dao = new LoanDAO();
		
		return dao;
	}
	
	public List<Loan> borrowedBooks() {
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		String qlQuery = 
				"SELECT DISTINCT m " +
				"FROM Loan l " + 
				"LEFT JOIN FETCH l.media m";
		TypedQuery<Loan> query = entityManager.createQuery(qlQuery, Loan.class);
		return query.getResultList();
						
	}
	
}
