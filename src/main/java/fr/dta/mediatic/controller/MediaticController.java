package fr.dta.mediatic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.mediatic.user.UserDao;
import fr.dta.mediatic.user.UserServices;

@RestController
public class MediaticController
{
	@Autowired private UserDao userDao;
	//@Autowired private MediaDao mediaDao;
	//@Autowired private AdherentDao adherentDao;
	@Autowired private UserServices userServices;
	
	public static final String CURRENT_USER = "CURRENT_USER";
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authentification(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request)
	{
		return userServices.checkUserCredential(login, password, userDao, request);	
	}
	@RequestMapping(value = "/mediaSearch", method = RequestMethod.POST)
	public String rechercheMedia(HttpServletRequest request)
	{
		return "redirect:MediaSearch/mediaSearch.html";

	}
	@RequestMapping(value = "/adherantSearch", method = RequestMethod.POST)
	public String rechercheAdherant(HttpServletRequest request)
	{
		return "redirect:AdherantSearch/adherantSearch.html";
	}
	@RequestMapping(value = "/media/{id}", method = RequestMethod.POST)
	public String ficheMedia(@PathVariable int id, HttpServletRequest request)
	{
		return "redirect:Media/media.html?id=" + id;
	}
	@RequestMapping(value = "/adherant/{id}", method = RequestMethod.POST)
	public String ficheAdherant(@PathVariable int id, HttpServletRequest request)
	{
		return "redirect:Adherant/adherant.html?id=" + id;
	}
}
