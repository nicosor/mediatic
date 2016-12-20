package fr.dta.mediatic.adherent.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.dta.mediatic.subscription.model.Subscription;
import fr.dta.mediatic.utils.model.AbstractModel;

@Entity
public class Adherent extends AbstractModel{

	private String lastname;
	private String firstname;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private String adresse;
	private int postalCode;
	private String city;
	@OneToOne
	private Subscription subscription;
	private String mail;
	
	public Adherent(String lastname, String firstname, Date birthday, String adresse, int postalCode, String city,
			Subscription subscription, String mail) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.adresse = adresse;
		this.postalCode = postalCode;
		this.city = city;
		this.subscription = subscription;
		this.mail = mail;
	}
	
	public Adherent(){
		
	}


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public Date getBirthday() {
		return birthday;
	}

	

}
