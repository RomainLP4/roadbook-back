package roadbook.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Article {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String titre;
	private String tag;
	private String description;
	@Column(length=1000)
	private String texte;
	private int nb_vue;
	private String date_publication;
	private String image_url;
	

	@OneToOne
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
	private Utilisateur auteur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getNb_vue() {
		return nb_vue;
	}

	public void setNb_vue(int nb_vue) {
		this.nb_vue = nb_vue;
	}

	public String getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(String date_publication) {
		this.date_publication = date_publication;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", tag=" + tag + ", description=" + description + ", texte="
				+ texte + ", nb_vue=" + nb_vue + ", date_publication=" + date_publication + ", auteur=" + auteur + "]";
	}

	public Article(String titre, String tag, String description, String texte, int nb_vue, String date_publication, String image_url,Utilisateur auteur) {
		super();
		this.titre = titre;
		this.tag = tag;
		this.description = description;
		this.texte = texte;
		this.nb_vue = nb_vue;
		this.date_publication = date_publication;
		this.image_url = image_url;
		this.auteur = auteur;
	}


	public Article() {
		super();
	}

}
