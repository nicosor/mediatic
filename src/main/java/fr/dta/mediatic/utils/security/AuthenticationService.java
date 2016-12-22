package fr.dta.mediatic.utils.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import fr.dta.mediatic.user.User;
import fr.dta.mediatic.user.UserDao;

@Component
public class AuthenticationService implements UserDetailsService {

	@Autowired private UserDao dao;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		User usr = dao.findUserByLogin(username);
		List<GrantedAuthority> liste = getUserCredentials(usr);
		return new org.springframework.security.core.userdetails.User(usr.getLogin(), usr.getPassword(), liste );
		
		// recuperer votre user et retourner un org.springframework.security.core.userdetails.User
		
		// sinon si absent générer une UsernameNotFoundException

	}

	public List<GrantedAuthority> getUserCredentials(User user) {
		List<GrantedAuthority> liste = new ArrayList<>();
		liste.add(new SimpleGrantedAuthority("ROLE_CREATE_MEDIA"));
		liste.add(new SimpleGrantedAuthority("ROLE_CREATE_ADHERENT"));
		
		return liste;
		// completer les roles
	}

}
