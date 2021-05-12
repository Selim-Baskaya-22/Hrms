package kodlamaio.hrms.entities.concretes;

public class Employers extends User {

	private String companyName;
	private String website;

	public Employers() {}
	
	public Employers(int id,String password,String email,String companyName, String website) {
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
