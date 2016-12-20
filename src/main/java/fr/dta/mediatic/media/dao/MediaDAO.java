package fr.dta.mediatic.media.dao;

import fr.dta.mediatic.media.model.Media;
import fr.dta.mediatic.utils.dao.AbstractDao;

public class MediaDAO extends AbstractDao<Media> {

	private static MediaDAO dao;
	
	private MediaDAO() {
		super(Media.class);
	}

	public static MediaDAO instance(){
		if (dao == null)
			dao = new MediaDAO();
		
		return dao;
	}
}
