package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employers")
public class Employer extends User {

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> advertisements;
	public Employer() {}
	
	public Employer(int id,String password,String email,String companyName, String website) {
		super();
		super.setId(id);
		super.setEmail(email);
		super.setPassword(password);
		this.companyName = companyName;
		this.website = website;
		}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}


}
