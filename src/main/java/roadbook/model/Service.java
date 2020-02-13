package roadbook.model;

import java.io.Serializable;
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
public class Service implements Serializable {
	public Service() {
		//utilisateurs = new ArrayList<Utilisateur>();
	}
	public Service(String nom, String categorie, String description, Integer nbr_place, Integer note, String image_url, String region, Utilisateur utilisateurs) {
		this.nom = nom;
		this.categorie = categorie;
		this.description = description;
		this.nbr_place = nbr_place;
		this.note = note;
		this.image_url = image_url;
		this.region = region;
		this.utilisateurs = utilisateurs;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String categorie; //enum
	private String description;
	private int nbr_place;
	private int note;
	private String image_url;
	@OneToOne
	//@JoinColumn(name = "id_utilisateur", referencedColumnName="id")
	private Utilisateur utilisateurs;
//	@ManyToOne
//	@JoinColumn(name = "id_region", referencedColumnName = "id")
	private String region;

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



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
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
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
