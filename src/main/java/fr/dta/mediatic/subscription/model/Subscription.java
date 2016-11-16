package fr.dta.mediatic.subscription.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Subscription {
	
	@Id
	@GeneratedValue
	private Long id;
	private float price;
	@Temporal(TemporalType.DATE)
	private Date beginningDate;
	@Temporal(TemporalType.DATE)
	private Date endingDate;
	
	public Subscription(float price, Date beginningDate, Date endingDate) {
		super();
		this.price = price;
		this.beginningDate = beginningDate;
		this.endingDate = endingDate;
	}
	
	public Subscription() {
		
	}

	public Long getId() {
		return id;
	}

	public float getPrice() {
		return price;
	}

	public Date getBeginningDate() {
		return beginningDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}


}
