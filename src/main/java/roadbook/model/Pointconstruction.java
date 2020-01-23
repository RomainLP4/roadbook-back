package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pointconstruction {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private int ordre_etape;
	private float latitude;
	private float longitude;
	private boolean is_etape;
	private String type_etape;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "id_roadbook", referencedColumnName = "id")
	private Roadbook roadbook;
	
	public int getOrdre_etape() {
		return ordre_etape;
	}

	public void setOrdre_etape(int ordre_etape) {
		this.ordre_etape = ordre_etape;
	}

	public String getType_etape() {
		return type_etape;
	}

	public void setType_etape(String type_etape) {
		this.type_etape = type_etape;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdreEtape() {
		return ordre_etape;
	}

	public void setOrdreEtape(int ordreEtape) {
		this.ordre_etape = ordreEtape;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public boolean isIs_etape() {
		return is_etape;
	}

	public void setIs_etape(boolean is_etape) {
		this.is_etape = is_etape;
	}

	public Roadbook getRoadbook() {
		return roadbook;
	}

	public void setRoadbook(Roadbook id_roadbook) {
		this.roadbook = id_roadbook;
	}
	
	
}
