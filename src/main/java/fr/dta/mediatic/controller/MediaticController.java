package fr.dta.mediatic.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.mediatic.adherent.dao.AdherentDAO;
import fr.dta.mediatic.media.dao.MediaDao;

@RestController
public class MediaticController
{
	@Autowired private UserDao userDao;
	@Autowired private MediaDao mediaDao;
	@Autowired private AdherentDAO adherentDao;
	public static final String CURRENT_USER = "CURRENT_USER";
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authentification(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request)
	{
		User user = userDao.findUserByLogin(login);
		if (user == null)
		{
			return "redirect:Login/login.html";
		}
		request.getSession().setAttribute(CURRENT_USER, user);
		
		return "redirect:MediaSearch/mediaSearch.html";
	}
	@RequestMapping(value = "/mediaSearch", method = RequestMethod.POST)
	public String rechercheMedia(HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return "redirect:MediaSearch/mediaSearch.html";
	}
	@RequestMapping(value = "/adherantSearch", method = RequestMethod.POST)
	public String rechercheAdherant(HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return "redirect:AdherantSearch/adherantSearch.html";
	}
	@RequestMapping(value = "/media/{id}", method = RequestMethod.POST)
	public String ficheMedia(@PathVariable int id, HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return "redirect:Media/media.html";
	}
	@RequestMapping(value = "/adherant/{id}", method = RequestMethod.POST)
	public String ficheAdherant(@PathVariable int id, HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(CURRENT_USER);
		return "redirect:Adherant/adherant.html";
	}
}
