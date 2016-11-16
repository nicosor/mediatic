package fr.dta.mediatic.subscription.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginningDate == null) ? 0 : beginningDate.hashCode());
		result = prime * result + ((endingDate == null) ? 0 : endingDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		if (beginningDate == null) {
			if (other.beginningDate != null)
				return false;
		} else if (!beginningDate.equals(other.beginningDate))
			return false;
		if (endingDate == null) {
			if (other.endingDate != null)
				return false;
		} else if (!endingDate.equals(other.endingDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", price=" + price + ", beginningDate=" + beginningDate + ", endingDate="
				+ endingDate + "]";
	}
}
