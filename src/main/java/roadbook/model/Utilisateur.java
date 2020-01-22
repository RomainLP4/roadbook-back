package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", email=" + email + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", telephone=" + telephone + ", niveau=" + niveau + ", ville=" + ville
				+ ", role=" + role + "]";
	}
	


	
}