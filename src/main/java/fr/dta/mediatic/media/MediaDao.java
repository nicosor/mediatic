package fr.dta.mediatic.media;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.abstracts.AbstractDao;
import fr.dta.mediatic.loan.Loan;

@Repository
@Transactional
public class MediaDao extends AbstractDao<Media> {

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
;