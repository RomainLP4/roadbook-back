package roadbook.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Service {
	public Service() {
		//utilisateurs = new ArrayList<Utilisateur>();
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
	private int id;
	private String nom;
	private String categorie;
	private String description;
	private int nbr_place;
	private int note;
	@OneToOne
	//@JoinColumn(name = "id_utilisateur", referencedColumnName="id")
	private Utilisateur utilisateurs;
	@ManyToOne
	@JoinColumn(name = "id_region", referencedColumnName = "id")
	private Region region;
	
	
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
	
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Utilisateur getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Utilisateur utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNbr_place(int nbr_place) {
		this.nbr_place = nbr_place;
	}
	public void setNote(int note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", description=" + description
				+ ", nbr_place=" + nbr_place + ", note=" + note + ", utilisateurs=" + utilisateurs + ", region="
				+ region + ", getNom()=" + getNom() + ", getCategorie()=" + getCategorie() + ", getDescription()="
				+ getDescription() + ", getNbr_place()=" + getNbr_place() + ", getNote()=" + getNote()
				+ ", getRegion()=" + getRegion() + ", getId()=" + getId() + ", getUtilisateurs()=" + getUtilisateurs()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


}
