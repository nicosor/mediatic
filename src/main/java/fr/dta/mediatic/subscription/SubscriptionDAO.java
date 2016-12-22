package fr.dta.mediatic.subscription;

import java.util.List;

import fr.dta.mediatic.utils.dao.AbstractDao;

public class SubscriptionDAO extends AbstractDao<Subscription>{
	private static SubscriptionDAO dao;
	
	private SubscriptionDAO() {
		super();
	}

	public static SubscriptionDAO instance() {
		if(dao == null)
			dao = new SubscriptionDAO();
		return dao;
	}

	@Override
	protected Class<Subscription> getEntityClass() {
		return null;
	}
	
	private final String table = "Subscription";
	
	public List<Subscription> getAll(){
		return super.getAll(table);
	}
	
	public Subscription getById(int id){
		return super.getById(id, table);
	}
}
