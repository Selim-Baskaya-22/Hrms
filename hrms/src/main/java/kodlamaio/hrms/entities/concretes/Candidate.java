package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

public class Candidate extends User{
	
	private String firsName;
	private String lastName;
	private int nationalityId;
	private LocalDate dateOfBirth;
	
	public Candidate() {}
	
	public Candidate(int id,String password,String email,String firsName, String lastName, int nationalityId, LocalDate dateOfBirth){
		super();
		super.setId(id);
		super.setEmail(email);
		super.setPassword(password);
		this.firsName = firsName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;

		}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	
}

