package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Moto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String categorie;
	private String marque;
	private String modele;
	private String annee;
	
	@ManyToOne
	@JoinColumn (name = "id_proprietaire", referencedColumnName = "id")
	private Utilisateur id_proprietaire;

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

	public Utilisateur getId_proprietaire() {
		return id_proprietaire;
	}

	public void setId_proprietaire(Utilisateur id_proprietaire) {
		this.id_proprietaire = id_proprietaire;
	}
	
	
}
