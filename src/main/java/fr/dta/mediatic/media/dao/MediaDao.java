package fr.dta.mediatic.media.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.dta.mediatic.loan.model.Loan;
import fr.dta.mediatic.media.model.Media;
import fr.dta.mediatic.utils.dao.AbstractDao;

public class MediaDao extends AbstractDao<Media> {

	private static MediaDAO dao;

	private final String table = "Media";
	S
	
	public static MediaDAO instance(){
		if (dao == null)
			dao = new MediaDAO();
		return dao;
	}	
	
	public List<Media> getAll() {
        return super.getAll(table);
	}
	
	public Media getById(long id) {
		return super.getById(id, table);
	}
	
	public List<Loan> getMediaLoan(Media media){
        TypedQuery<Loan> query = super.getEntityManager().createQuery("FROM loan WHERE media =:media", Loan.class);
        query.setParameter("media", media);
        return query.getResultList();
	}
	
	@Override
	protected Class<Media> getEntityClass() {
		return Media.class;
	}
}
