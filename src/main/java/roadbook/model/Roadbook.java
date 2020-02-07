package roadbook.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roadbook {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	private String description;
	private int kilometrage;
	private String difficulte; //enum
	private int likes;
	private String image_url;
	

	
	@ManyToOne
	@JoinColumn(name = "id_region", referencedColumnName="id")
	private Region region;
	
	@ManyToOne 
	@JoinColumn(name = "id_utilisateur", referencedColumnName="id")
	private Utilisateur auteur;
	
	
	@OneToMany(mappedBy="roadbook",orphanRemoval = true)
	@JsonIgnore
	private List <Pointconstruction> ListPointConstruction;
	

	
	
	public List<Pointconstruction> getListPointConstruction() {
		return ListPointConstruction;
	}
	public void setListPointConstruction(List<Pointconstruction> listPointConstruction) {
		ListPointConstruction = listPointConstruction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}
	public String getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public Roadbook() {
	}
}
