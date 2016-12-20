package fr.dta.mediatic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.mediatic.adherent.dao.AdherentDao;
import fr.dta.mediatic.media.dao.MediaDao;
import fr.dta.mediatic.user.dao.UserDao;
import fr.dta.mediatic.user.model.User;

@RestController
public class MediaticController
{
	@Autowired private UserDao userDao;
	@Autowired private MediaDao mediaDao;
	@Autowired private AdherentDao adherentDao;
	public static final String CURRENT_USER = "CURRENT_USER";
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authentification(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request)
	{
		User user = userDao.findUserByLogin(login);
		if (user == null)
		{
			return "redirect:Login/login";
		}
		request.getSession().setAttribute(CURRENT_USER, user);
		
		return "redirect:MediaSearch/mediaSearch";
	}
	@RequestMapping(value = "/mediaSearch", method = RequestMethod.POST)
	public String rechercheMedia(HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return null;
	}
	@RequestMapping(value = "/adherantSearch", method = RequestMethod.POST)
	public String rechercheAdherant(HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return null;
	}
	@RequestMapping(value = "/media", method = RequestMethod.POST)
	public String ficheMedia(HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return null;
	}
	@RequestMapping(value = "/adherant", method = RequestMethod.POST)
	public String ficheAdherant(HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return null;
	}
}
