package fr.dta.mediatic;

import java.util.Date;

import org.hibernate.mapping.Subclass;

import fr.dta.mediatic.adherent.dao.AdherentDAO;
import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.category.Category;
import fr.dta.mediatic.media.dao.MediaDAO;
import fr.dta.mediatic.media.model.Media;
import fr.dta.mediatic.subscription.dao.SubscriptionDAO;
import fr.dta.mediatic.subscription.model.Subscription;

public class Mediatic {

	public static void main(String[] args) {

//		MediaDAO mdao = MediaDAO.instance();
//		Media m = new Media("poney", "poney man", Category.Livre);
//		Adherent a = new Adherent("Pierre", "Burgain", new Date(), "1 rue tur", 34000, "Mpt", null, "p@p.fr");
//		mdao.persist(m);
//		AdherentDAO adao = AdherentDAO.instance();
//		adao.persist(a);
		SubscriptionDAO sdao = SubscriptionDAO.instance();
		Subscription sub = new Subscription(30.0f, new Date(), new Date());
		sdao.persist(sub);
//		System.out.println(adao.find(a.getId()));
		System.out.println(sdao.find(sub.getId()));
		System.out.println("tutu");
	}

}
