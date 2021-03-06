package metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity //pour specifeier ejb entite sasns cette annot c simplement un java bean
@Table(name="COMPTE")
public class Compte implements Serializable {
	
	//auto  c framework  le jpa mappping objet rel qui va choissir la config par defaut s non on vautiliser 
	//IDENTITY //on specifie au niveau de lBD a chaque x on va incrementer la valeur 	du code
	
	public Compte(double solde, Date dateCreation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="CODE")
	private Long code;
	@Column(name="SOLDE")
	private double solde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
public Compte(double solde, Date dateCreation, Boolean active) {
	super();
	this.solde = solde;
	this.dateCreation = dateCreation;
	this.active = active;
}
public Compte() {
	super();
}
private Boolean active;
public Long getCode() {
	return code;
}
public void setCode(Long code) {
	this.code = code;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public Boolean getActive() {
	return active;
}
public void setActive(Boolean active) {
	this.active = active;
}

}
