package fr.dta.mediatic.subscription;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.dta.mediatic.abstracts.AbstractDao;

public class SubscriptionDao extends AbstractDao<Subscription>{

	@Override
	protected Class<Subscription> getEntityClass() {
		return null;
	}
	
	public List<Subscription> getListSubscription(Long id){
		TypedQuery<Subscription> query = super.getEntityManager().createQuery("select subscription.id, price, subscription_date, return_date "
				+ "from subscription "
				+ "join adherent on subscription.id = subscription_id "
				+ "where adherent.id = adherent_id", Subscription.class);
		query.setParameter("adherent_id", id);
		return query.getResultList();
	}
	
	public Object getLastSubscription(Long id){
		TypedQuery<Subscription> query = super.getEntityManager().createQuery("select subscription.id, price, subscription_date, return_date "
				+ "from subscription "
				+ "join adherent on subscription.id = subscription_id "
				+ "where adherent.id = adherent_id"
				+ "order by return_date desc", Subscription.class);
		query.setParameter("adherent_id", id);
		return query.setMaxResults(1).getResultList();
	}
}
