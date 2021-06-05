package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "schools")
@Entity
public class School {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name = "section_name")
	private String sectionName;
	
	@Column(name = "school_name")
	private String schooName;
	
	@Column(name = "start_year")
	private LocalDate startYear;
	
	@Column(name = "graduation_year")
	private LocalDate graduationYear;

	@Column(name = "created_date")
	private LocalDate createdDate;

	public School(int id, Candidate candidate, String sectionName, String schooName, LocalDate startYear,
			LocalDate graduationYear, LocalDate createdDate) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.sectionName = sectionName;
		this.schooName = schooName;
		this.startYear = startYear;
		this.graduationYear = graduationYear;
		this.createdDate = createdDate;
	}
	
	public School() {}

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

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSchooName() {
		return schooName;
	}

	public void setSchooName(String schooName) {
		this.schooName = schooName;
	}

	public LocalDate getStartYear() {
		return startYear;
	}

	public void setStartYear(LocalDate startYear) {
		this.startYear = startYear;
	}

	public LocalDate getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(LocalDate graduationYear) {
		this.graduationYear = graduationYear;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	

}
