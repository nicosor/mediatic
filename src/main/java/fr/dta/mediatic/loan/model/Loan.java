package fr.dta.mediatic.loan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.dta.mediatic.adherent.model.Adherent;
import fr.dta.mediatic.media.model.Media;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Media media;
	
	@ManyToOne
	private Adherent adherent;
	
	@Temporal(TemporalType.DATE)
	private Date loanDate;
	
	@Temporal(TemporalType.DATE)
	private Date backPlanedDate;
	
	private boolean isBack;
	
	public Loan() {
		
	}
	
	public Loan(Media media, Adherent adherent, Date loanDate, Date backDate, boolean isBack) {
		super();
		this.media = media;
		this.adherent = adherent;
		this.loanDate = loanDate;
		this.backPlanedDate = backDate;
		this.isBack = isBack;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adherent == null) ? 0 : adherent.hashCode());
		result = prime * result + ((backPlanedDate == null) ? 0 : backPlanedDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isBack ? 1231 : 1237);
		result = prime * result + ((loanDate == null) ? 0 : loanDate.hashCode());
		result = prime * result + ((media == null) ? 0 : media.hashCode());
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
		Loan other = (Loan) obj;
		if (adherent == null) {
			if (other.adherent != null)
				return false;
		} else if (!adherent.equals(other.adherent))
			return false;
		if (backPlanedDate == null) {
			if (other.backPlanedDate != null)
				return false;
		} else if (!backPlanedDate.equals(other.backPlanedDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isBack != other.isBack)
			return false;
		if (loanDate == null) {
			if (other.loanDate != null)
				return false;
		} else if (!loanDate.equals(other.loanDate))
			return false;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public void setBackPlanedDate(Date backPlanedDate) {
		this.backPlanedDate = backPlanedDate;
	}

	public long getId() {
		return id;
	}

	public Media getMedia() {
		return media;
	}

	public Adherent getAdherent() {
		return adherent;
	}


	public Date getLoanDate() {
		return loanDate;
	}


	public Date getBackPlanedDate() {
		return backPlanedDate;
	}


	public boolean isBack() {
		return isBack;
	}

	public void setBack(boolean isBack) {
		this.isBack = isBack;
	}
	

}
