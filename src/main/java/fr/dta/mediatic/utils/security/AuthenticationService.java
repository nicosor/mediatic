package fr.dta.mediatic.utils.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import fr.dta.mediatic.user.User;
import fr.dta.mediatic.user.UserDao;

@Component
public class AuthenticationService implements UserDetailsService {

	@Autowired private UserDao service;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		return null;
		
		// recuperer votre user et retourner un org.springframework.security.core.userdetails.User
		
		// sinon si absent générer une UsernameNotFoundException

	}

	public List<GrantedAuthority> getUserCredentials(User user) {
		return null;
		// completer les roles
	}

}
