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
