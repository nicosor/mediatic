package fr.dta.mediatic.abstracts;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
}
