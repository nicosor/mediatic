package fr.dta.mediatic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.dta.mediatic.adherent.dao.AdherentDAO;
import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.category.Category;
import fr.dta.mediatic.loan.dao.LoanDAO;
import fr.dta.mediatic.loan.model.Loan;
import fr.dta.mediatic.media.dao.MediaDAO;
import fr.dta.mediatic.media.model.Media;
import fr.dta.mediatic.utils.date.dateGenerator;

public class Mediatic {

	public static void main(String[] args) throws ParseException {

		MediaDAO mdao = MediaDAO.instance();
		Media m = new Media("tutu", "tot", Category.DVD);
		//mdao.persist(m);
		System.out.println(mdao.find(2L).getAuthor());
//		mdao.remove(4L);
		Media m1 = mdao.find(2L);
//		m1.setAuthor("toto");
//		mdao.merge(m1);
		
//		Adherent ad = new Adherent("Soriano", "Nicolas", new Date(22/10/1991), "19 rue des Hospices", 34000, "Montpellier", null, "nico.sor@free.fr");
		AdherentDAO adao = AdherentDAO.instance();
//		adao.persist(ad);
		
		Adherent a1 = adao.find(6L);
		
		Loan lo = new Loan(m1, a1, dateGenerator.getDate("16/11/2016"), dateGenerator.getDate("16/12/2016"), false);
		LoanDAO ldao = LoanDAO.instance();
		
		ldao.persist(lo);
	}

}