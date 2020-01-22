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
public class Region {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String nom;
	
	@Override
	public String toString() {
		return "Region [id=" + id + ", nom=" + nom + "]";
	}
	
}
