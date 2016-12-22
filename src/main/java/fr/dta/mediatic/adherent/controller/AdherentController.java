package fr.dta.mediatic.adherent.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.mediatic.adherent.dao.AdherentDao;
import fr.dta.mediatic.adherent.model.Adherent;

@RestController
@RequestMapping("/ui/app/Adherent")
public class AdherentController {

	private static AdherentDao adherentDao = AdherentDao.instance();
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Adherent getById(@PathVariable Long id){
		return adherentDao.getById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void addAdherent(@RequestBody @Valid Adherent adherent, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getErrorCount());
			for(ObjectError obj : bindingResult.getAllErrors()){
				System.out.println(obj.getCodes()[0] + " " + obj.getDefaultMessage());
			} 
		} else {
				adherentDao.add(adherent);
		}
	}
}
