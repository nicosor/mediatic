package fr.dta.mediatic.user.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.loan.model.Loan;
import fr.dta.mediatic.user.model.User;
import fr.dta.mediatic.utils.dao.AbstractDao;

@Repository
@Transactional
public class UserDao extends AbstractDao<User> {

	private static UserDao dao;
	
	public UserDao() {
		super();
	}

	public static UserDao instance(){
		if (dao == null)
			dao = new UserDao();
		
		return dao;
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
	
	public User getById(int id){
		return super.getById(id, "User");
	}

	public User findUserByLogin(String login) {
		TypedQuery<User> query = getEntityManager().createQuery("FROM User WHERE login =:login", User.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
}
