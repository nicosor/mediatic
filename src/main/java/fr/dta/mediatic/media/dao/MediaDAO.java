package fr.dta.mediatic.media.dao;

import fr.dta.mediatic.media.model.Media;
import fr.dta.mediatic.utils.dao.AbstractDao;

public class MediaDAO extends AbstractDao<Media> {

	private static MediaDAO dao;
	
	private MediaDAO() {
		super();
	}

	public static MediaDAO instance(){
		if (dao == null)
			dao = new MediaDAO();
		
		return dao;
	}

	@Override
	protected Class<Media> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
}
