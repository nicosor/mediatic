package fr.dta.mediatic.user;


import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.utils.dao.AbstractDao;


@Repository
@Transactional
public class UserDao extends AbstractDao<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	public User findUserByLogin(String login) {
		TypedQuery<User> query = getEntityManager().createQuery("FROM User WHERE login =:login", User.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
}
