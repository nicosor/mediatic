package fr.dta.mediatic.adherent;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.abstracts.AbstractDao;
import fr.dta.mediatic.loan.Loan;
import fr.dta.mediatic.subscription.Subscription;

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
	
	public List<Subscription> getListSubscription(Adherent adherent){
		TypedQuery<Subscription> query = super.getEntityManager().createQuery("from subscription where adherent =:adherent", Subscription.class);
		query.setParameter("adherent", adherent);
		return query.getResultList();
	}
	
	public Object getLastSubscription(Adherent adherent){
		TypedQuery<Subscription> query = super.getEntityManager().createQuery("from subscription where adherent =:adherent order by date_de_fin limit 1", Subscription.class);
		query.setParameter("adherent", adherent);
		return query.getResultList();
	}
	
}
