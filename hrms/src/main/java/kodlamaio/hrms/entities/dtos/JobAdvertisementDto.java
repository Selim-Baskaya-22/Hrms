package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

public class JobAdvertisementDto {
	
	private int id;
	private String jobName;
	private String companyName;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
	
	public JobAdvertisementDto(int id, String companyName,String jobName, LocalDate releaseDate, LocalDate applicationDeadline) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.releaseDate = releaseDate;
		this.applicationDeadline = applicationDeadline;
		this.jobName=jobName;
	}
	
	public JobAdvertisementDto() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public LocalDate getApplicationDeadline() {
		return applicationDeadline;
	}
	public void setApplicationDeadline(LocalDate applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
	//Job name , CompanyName,Number of people,Yayın tarihi, applicatioın deadline.
	// tablolar : jobs,employer,jobadvirements
}
