package fr.dta.mediatic;

import fr.dta.mediatic.media.dao.MediaDAO;
import fr.dta.mediatic.media.model.Media;

public class Mediatic {

	public static void main(String[] args) {

		MediaDAO mdao = MediaDAO.instance();
		Media m = new Media();
		mdao.persist(m);
		System.out.println("tutu");
	}

}
