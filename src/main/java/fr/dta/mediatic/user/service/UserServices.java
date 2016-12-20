package fr.dta.mediatic.user.service;


import javax.servlet.http.HttpServletRequest;

import fr.dta.mediatic.user.dao.UserDao;
import fr.dta.mediatic.user.model.User;

public class UserServices {

	public String checkUserCredential(String login, String password, UserDao userDao, HttpServletRequest request){
		User user = userDao.findUserByLogin(login);
		if (user != null && user.getPassword() == password)
		{
			request.getSession().setAttribute("CURRENT_USER", user);
			return "redirect:MediaSearch/mediaSearch.html";
		}
		return "redirect:Login/login.html";	
	}
}
