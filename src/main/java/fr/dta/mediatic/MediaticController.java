package fr.dta.mediatic;

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
	
	//login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getAuthentification(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request)
	{
		System.out.println("tutu");
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postAuthentification(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request)
	{
		System.out.println("tutu");
		return userServices.checkUserCredential(login, password, userDao, request);
	}
	
	//mediaSearch
	@RequestMapping(value = "/mediaSearch", method = RequestMethod.GET)
	public String getRechercheMedia(HttpServletRequest request)
	{
		return "redirect:MediaSearch/mediaSearch.html";
	}
	
	@RequestMapping(value = "/mediaSearch", method = RequestMethod.POST)
	public String postRechercheMedia(HttpServletRequest request)
	{
		return "redirect:MediaSearch/mediaSearch.html";
	}
	
	//adherentSearch
	@RequestMapping(value = "/adherantSearch", method = RequestMethod.GET)
	public String getRechercheAdherant(HttpServletRequest request)
	{
		return "redirect:AdherantSearch/adherantSearch.html";
	}
	
	@RequestMapping(value = "/adherantSearch", method = RequestMethod.POST)
	public String postRechercheAdherant(HttpServletRequest request)
	{
		return "redirect:AdherantSearch/adherantSearch.html";
	}
	
	//media
	@RequestMapping(value = "/media/{id}", method = RequestMethod.GET)
	public String getFicheMedia(@PathVariable int id, HttpServletRequest request)
	{
		return "redirect:Media/media.html?id=" + id;
	}
	
	@RequestMapping(value = "/media/{id}", method = RequestMethod.POST)
	public String postFicheMedia(@PathVariable int id, HttpServletRequest request)
	{
		return "redirect:Media/media.html?id=" + id;
	}
	
	//adherent
	@RequestMapping(value = "/adherant/{id}", method = RequestMethod.GET)
	public String getFicheAdherant(@PathVariable int id, HttpServletRequest request)
	{
		return "redirect:Adherant/adherant.html?id=" + id;
	}
	
	@RequestMapping(value = "/adherant/{id}", method = RequestMethod.POST)
	public String postFicheAdherant(@PathVariable int id, HttpServletRequest request)
	{
		return "redirect:Adherant/adherant.html?id=" + id;
	}
}
