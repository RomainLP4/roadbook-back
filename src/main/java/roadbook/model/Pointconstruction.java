package roadbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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

	@OneToOne
	@JoinColumn (name = "id_roadbook", referencedColumnName = "id")
	private Roadbook id_roadbook;

	
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

	public Roadbook getId_roadbook() {
		return id_roadbook;
	}

	public void setId_roadbook(Roadbook id_roadbook) {
		this.id_roadbook = id_roadbook;
	}
	
	
}
