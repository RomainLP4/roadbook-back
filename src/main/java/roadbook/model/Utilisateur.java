package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private String pseudo;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String telephone;
	private String niveau;  // ENUM ?
	private String ville;
	private String role; // ENUM ?
	
	public Utilisateur(String pseudo, String email, String password, String nom, String prenom, String telephone,
			String niveau, String ville, String role) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.niveau = niveau;
		this.ville = ville;
		this.role = role;
	}


	public Utilisateur() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", email=" + email + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", telephone=" + telephone + ", niveau=" + niveau + ", ville=" + ville
				+ ", role=" + role + "]";
	}
	


	
}