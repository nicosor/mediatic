package fr.dta.mediatic.subscription;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import fr.dta.mediatic.abstracts.AbstractModel;

@Entity
@Table(name = "subscription")
public class Subscription extends AbstractModel {
	
	@Column
	@NotNull
	private Float price;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date subscriptionDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	public Subscription(float price, Date subscriptionDate, Date returnDate) {
		super();
		this.price = price;
		this.subscriptionDate = subscriptionDate;
		this.returnDate = returnDate;
	}
	
	public Subscription () {
		
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
}
