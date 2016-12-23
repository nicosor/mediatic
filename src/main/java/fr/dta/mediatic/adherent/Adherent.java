package fr.dta.mediatic.adherent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.dta.mediatic.abstracts.AbstractModel;
import fr.dta.mediatic.subscription.Subscription;

@Entity
public class Adherent extends AbstractModel
{
	private String lastname;
	private String firstname;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private String address;
	private int postalCode;
	private String city;
	@OneToOne
	private Subscription subscription;
	private String email;
	
	public Adherent(String lastname, String firstname, Date birthday, String address, int postalCode, String city,
			Subscription subscription, String email) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.subscription = subscription;
		this.email = email;
	}
	
	public Adherent(){
		
	}


	public String getAdresse() {
		return address;
	}

	public void setAdresse(String address) {
		this.address = address;
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
		return email;
	}

	public void setMail(String email) {
		this.email = email;
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
