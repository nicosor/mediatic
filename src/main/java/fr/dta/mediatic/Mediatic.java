package fr.dta.mediatic;

import java.text.ParseException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.mediatic.user.User;
import fr.dta.mediatic.user.UserDao;
import fr.dta.mediatic.utils.SpringConfiguration;

public class Mediatic {

	public static void main(String[] args) throws ParseException {
		/**AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");**/
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		UserDao usrDao = context.getBean(UserDao.class);
		usrDao.add(new User("tutu", "toto"));
		User usr = usrDao.findUserByLogin("tutu");
		usrDao.delete(usr);
		
		context.close();
	}
}