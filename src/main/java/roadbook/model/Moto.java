package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Moto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String categorie; //enum
	private String marque;
	private String modele;
	private String annee;
	private String image_url;
	
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn (name = "proprietaire", referencedColumnName = "id")
	private Utilisateur proprietaire;


	public String getImage_url() {return image_url;}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Utilisateur getUtilisateur() {
		return proprietaire;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.proprietaire = utilisateur;
	}

	public Moto() {
	}
}
