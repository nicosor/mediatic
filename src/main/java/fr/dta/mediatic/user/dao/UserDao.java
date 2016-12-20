package fr.dta.mediatic.user.dao;

import org.springframework.stereotype.Repository;

import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.user.model.User;
import fr.dta.mediatic.utils.dao.AbstractDao;

@Repository
public class UserDao extends AbstractDao<User> {

	private static UserDao dao;
	
	private UserDao() {
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
}
