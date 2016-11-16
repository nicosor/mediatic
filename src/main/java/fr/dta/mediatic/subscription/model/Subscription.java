package fr.dta.mediatic.subscription.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue
	private Long id;
	
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

	public Long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", price=" + price + ", subscriptionDate=" + subscriptionDate
				+ ", returnDate=" + returnDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((subscriptionDate == null) ? 0 : subscriptionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (subscriptionDate == null) {
			if (other.subscriptionDate != null)
				return false;
		} else if (!subscriptionDate.equals(other.subscriptionDate))
			return false;
		return true;
	}
}
