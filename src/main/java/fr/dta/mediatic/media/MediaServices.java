package fr.dta.mediatic.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.mediatic.abstracts.AbstractDao;
import fr.dta.mediatic.abstracts.AbstractService;
import fr.dta.mediatic.loan.Loan;

@Service
public class MediaServices extends AbstractService<Media, AbstractDao<Media>>{
	
	@Autowired MediaDao dao;

	public List<Media> getAll() {
		return dao.getAll();
	}
	
	public Media getById(long id) {
		return dao.getById(id);
	}
	
	public List<Loan> getMediaLoan(Media media) {
		return dao.getMediaLoan(media);
	}
	
	public void add(Media media) {
		dao.persist(media);
	}
	
	public void delete(Media media) {
		dao.delete(media);
	}
	
	public void update(Media media) {
		dao.merge(media);
	}
}
