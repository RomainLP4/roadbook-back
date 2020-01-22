package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Service {
	public Service() {
		
	}
	public Service(String nom, String categorie, String description, Integer nbr_place, Integer note) {
		this.nom = nom;
		this.categorie = categorie;
		this.description = description;
		this.nbr_place = nbr_place;
		this.note = note;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String categorie;
	private String description;
	private Integer nbr_place;
	private Integer note;
//	@ManyToMany
//	@JoinColumn(name = "utilisateur", referencedColumnName="id")
//	private Utilisateur utilisateur;
//	@ManyToOne
//	@JoinColumn(name = "region", referencedColumnName = "id")
//	private Region region;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNbr_place() {
		return nbr_place;
	}
	public void setNbr_place(Integer nbr_place) {
		this.nbr_place = nbr_place;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
//	public Utilisateur getUtilisateur() {
//		return utilisateur;
//	}
//	public void setUtilisateur(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}
//	public Region getRegion() {
//		return region;
//	}
//	public void setRegion(Region region) {
//		this.region = region;
//	}
//	@Override
//	public String toString() {
//		return "Service [id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", description=" + description
//				+ ", nbr_place=" + nbr_place + ", note=" + note + ", utilisateur=" + utilisateur + ", region=" + region
//				+ ", getNom()=" + getNom() + ", getCategorie()=" + getCategorie() + ", getDescription()="
//				+ getDescription() + ", getNbr_place()=" + getNbr_place() + ", getNote()=" + getNote()
//				+ ", getUtilisateur()=" + getUtilisateur() + ", getRegion()=" + getRegion() + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
}
