package fr.dta.mediatic.media;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import fr.dta.mediatic.abstracts.AbstractModel;
import fr.dta.mediatic.category.Category;
import fr.dta.mediatic.loan.Loan;

@Entity
@Table (name = "Media")
public class Media extends AbstractModel{

	@Column
	@NotBlank
	private String title;
	
	@Column
	@NotBlank
	private String author;

	@Column
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "current_loan")
	@OneToOne 
	private Loan currentloan;

	
	public Media(){
	}
	
	public Media (String title, String author, Category categroy){
		this.title = title;
		this.author = author;
		this.category = categroy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
