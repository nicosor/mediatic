package fr.dta.mediatic.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import fr.dta.mediatic.abstracts.AbstractModel;

@Entity
@Table(name = "User_")
public class User extends AbstractModel{

	@Column
	@NotBlank
	private String login;

	@Column
	@NotBlank
	private String password;
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", login=" + login + ", password=" + password + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
