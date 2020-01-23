package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Roadbook {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	private String description;
	private int kilometrage;
	private String difficulte;
	
	@ManyToOne
	@JoinColumn(name = "id_region", referencedColumnName="id")
	private Region region;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur", referencedColumnName="id")
	private Utilisateur auteur;
	

	private int likes;
	
	
}
