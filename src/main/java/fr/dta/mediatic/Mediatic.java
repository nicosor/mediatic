package fr.dta.mediatic;

import java.text.ParseException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

@ComponentScan
public class Mediatic {

	public static void main(String[] args) throws ParseException {

		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Mediatic.class);
		
		
	}
	
	public void addRow() {

	}

}