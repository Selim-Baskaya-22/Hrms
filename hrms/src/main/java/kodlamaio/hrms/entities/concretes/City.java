package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "citys")
public class City {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<JobAdvertisement> advertisements;

	public City(int id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}
	public City() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	};
	
	
	
}
