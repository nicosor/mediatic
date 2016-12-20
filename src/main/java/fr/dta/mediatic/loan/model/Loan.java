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
import fr.dta.mediatic.utils.model.AbstractModel;

@Entity
public class Loan extends AbstractModel {

	
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
