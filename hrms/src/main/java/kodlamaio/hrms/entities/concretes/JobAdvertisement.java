package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "job_advertisements")
@Entity
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")  
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;	
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@Column(name = "min_salary")
	private float minSalary;
	
	@Column(name = "max_salary")
	private float maxSalary;
	
	@Column(name = "number_of_people")
	private int numberOfPeople;
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;

	public JobAdvertisement(int id, int jobId, int cityId, int employerId, float minSalary, float maxSalary,
			int numberOfPeople, LocalDate applicationDeadline, String description, boolean isActive, LocalDate releaseDate) {
		super();
		this.id = id;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.numberOfPeople = numberOfPeople;
		this.applicationDeadline = applicationDeadline;
		this.description = description;
		this.isActive = isActive;
		this.releaseDate=releaseDate;
	}
	public JobAdvertisement() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(float minSalary) {
		this.minSalary = minSalary;
	}
	public float getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(float maxSalary) {
		this.maxSalary = maxSalary;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public LocalDate getApplicationDeadline() {
		return applicationDeadline;
	}
	public void setApplicationDeadline(LocalDate applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	};

}
