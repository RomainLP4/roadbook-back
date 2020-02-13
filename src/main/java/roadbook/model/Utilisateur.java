package roadbook.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id",scope = Utilisateur.class )
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
	private String image_url;
	
	//@JsonIgnore
	@OneToMany (mappedBy="proprietaire", orphanRemoval=true)
	private List<Moto> listeMotos;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utilisateur)) return false;
		Utilisateur that = (Utilisateur) o;
		return getId() == that.getId() &&
				Objects.equals(getPseudo(), that.getPseudo()) &&
				Objects.equals(getEmail(), that.getEmail()) &&
				Objects.equals(getPassword(), that.getPassword()) &&
				Objects.equals(getNom(), that.getNom()) &&
				Objects.equals(getPrenom(), that.getPrenom()) &&
				Objects.equals(getTelephone(), that.getTelephone()) &&
				Objects.equals(getNiveau(), that.getNiveau()) &&
				Objects.equals(getVille(), that.getVille()) &&
				Objects.equals(getRole(), that.getRole()) &&
				Objects.equals(getImage_url(), that.getImage_url()) &&
				Objects.equals(getListeMotos(), that.getListeMotos());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getPseudo(), getEmail(), getPassword(), getNom(), getPrenom(), getTelephone(), getNiveau(), getVille(), getRole(), getImage_url(), getListeMotos());
	}

	public Utilisateur(String pseudo, String email, String password, String nom, String prenom, String telephone,
					   String niveau, String ville, String role, String image_url, List<Moto> listeMotos) {
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
		this.image_url = image_url;
		this.listeMotos = listeMotos;
	}


	public Utilisateur() {
		super();
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
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
	
	public List<Moto> getListeMotos() {
		return listeMotos;
	}


	public void setListeMotos(List<Moto> listeMotos) {
		this.listeMotos = listeMotos;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", email=" + email + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", telephone=" + telephone + ", niveau=" + niveau + ", ville=" + ville
				+ ", role=" + role + "]";
	}
	


	
}
