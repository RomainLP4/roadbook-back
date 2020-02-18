package roadbook.model;

import java.util.Date;

import javax.persistence.*;

@Entity

public class Evenement {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	private String type; //enum
	@Column(length=1000)
	private String description;
	private String imageUrl;
	private String lieu;
	


	@ManyToOne
	@JoinColumn(name = "id_region", referencedColumnName = "id")
	private Region region;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id" )
	private Utilisateur utilisateur;
	
	@OneToOne
	@JoinColumn(name = "id_roadbook", referencedColumnName = "id")
	private Roadbook roadbook;

	public Evenement() {
	
	}

	public Evenement(String nom, String type, String description, Region region, Date date, Utilisateur utilisateur,
			Roadbook roadbook,String imageUrl, String lieu) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.region = region;
		this.date = date;
		this.utilisateur = utilisateur;
		this.roadbook = roadbook;
		this.imageUrl = imageUrl;
		this.lieu = lieu;
	}

	public void setImage_url(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImage_url() {
		return imageUrl;
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

	public Roadbook getRoadbook() {
		return roadbook;
	}

	public void setRoadbook(Roadbook roadbook) {
		this.roadbook = roadbook;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}





}
