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

@Table(name = "work_experiences")
@Entity
public class WorkExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name="job_place")
	private String jobPlace;
	
	@Column(name="position_name")
	private String positionName;
	
	@Column(name="start_year")
	private LocalDate dateOfStart;
	
	@Column(name="leaving_date")
	private LocalDate leavingDate;
	
	@Column(name="created_date")
	private LocalDate createdDate;

	public WorkExperience(int id, Candidate candidate, String jobPlace, String positionName, LocalDate dateOfStart,
			LocalDate leavingDate, LocalDate createdDate) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.jobPlace = jobPlace;
		this.positionName = positionName;
		this.dateOfStart = dateOfStart;
		this.leavingDate = leavingDate;
		this.createdDate = createdDate;
	}
	
	public WorkExperience() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getJobPlace() {
		return jobPlace;
	}

	public void setJobPlace(String jobPlace) {
		this.jobPlace = jobPlace;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public LocalDate getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(LocalDate startYear) {
		this.dateOfStart = startYear;
	}

	public LocalDate getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(LocalDate leavingDate) {
		this.leavingDate = leavingDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
}
