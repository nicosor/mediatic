package fr.dta.mediatic.subscription.dao;

import fr.dta.mediatic.subscription.model.Subscription;
import fr.dta.mediatic.utils.dao.AbstractDao;

public class SubscriptionDAO extends AbstractDao<Subscription>{
	private static SubscriptionDAO dao;
	
	private SubscriptionDAO() {
		super(Subscription.class);
	}

	public static SubscriptionDAO instance() {
		if(dao == null)
			dao = new SubscriptionDAO();
		return dao;
	}
}
