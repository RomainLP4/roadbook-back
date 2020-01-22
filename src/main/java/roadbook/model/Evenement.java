package roadbook.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Evenement {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	private String type;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "region", referencedColumnName = "id")
	private Region region;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;
	
	@OneToOne
	@JoinColumn(name = "roadbook", referencedColumnName = "id")
	private RoadBook roadBook;

	public Evenement() {
	
	}

	public Evenement(String nom, String type, String description, Region region, Date date, Utilisateur utilisateur,
			RoadBook roadBook) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.region = region;
		this.date = date;
		this.utilisateur = utilisateur;
		this.roadBook = roadBook;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public RoadBook getRoadBook() {
		return roadBook;
	}

	public void setRoadBook(RoadBook roadBook) {
		this.roadBook = roadBook;
	}
	
	
	
	

}
