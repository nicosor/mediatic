package fr.dta.mediatic.adherent.dao;

import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.utils.dao.GenericDAO;

public class AdherentDAO extends GenericDAO<Adherent> {

	private static AdherentDAO dao;
	
	private AdherentDAO() {
		super(Adherent.class);
	}
	
	public static AdherentDAO instance() {
		if(dao==null) {
			dao = new AdherentDAO();
		}
		return dao;
	}
}
