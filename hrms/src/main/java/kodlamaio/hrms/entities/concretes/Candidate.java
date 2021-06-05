package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="candidates")
public class Candidate extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	
	//Mapped Join
	
	@OneToMany(mappedBy = "candidates")
	private List<School> schools;
	
	@OneToMany(mappedBy = "candidates")
	private List<WorkExperience> workExperiences;
	
	@OneToMany(mappedBy = "candidates")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "candidates")
	private List<Image> images;
	
	@OneToMany(mappedBy = "candidates")
	private List<Link> links;
	
	@OneToMany(mappedBy = "candidates")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "candidates")
	private List<CoverLetter> coverLetters;
	
	
	
	
	
	
	public Candidate() {}
	
	public Candidate(int id,String password,String email,String firsName, String lastName, String nationalityId, LocalDate dateOfBirth){
		super();
		super.setId(id);
		super.setEmail(email);
		super.setPassword(password);
		this.firstName = firsName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;

		}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firsName) {
		this.firstName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	
}

