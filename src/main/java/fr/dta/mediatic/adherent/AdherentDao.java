package fr.dta.mediatic.adherent;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.abstracts.AbstractDao;

@Repository
@Transactional
public class AdherentDao extends AbstractDao<Adherent> {

	@Override
	protected Class<Adherent> getEntityClass() {
		return null;
	}
}
