package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Roadbook {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	private String description;
	private int kilometre;
	private String difficulte;
	
	@ManyToOne
	@JoinColumn(name = "region", referencedColumnName="id")
	private Region region;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur", referencedColumnName="id")
	private Utilisateur auteur;
	
	
}
