package fr.dta.mediatic;

import java.text.ParseException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dta.mediatic.user.model.User;


public class Mediatic {

	public static void main(String[] args) throws ParseException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	}
	
	public void addRow() {
		//User user = new User("login")
	}

}