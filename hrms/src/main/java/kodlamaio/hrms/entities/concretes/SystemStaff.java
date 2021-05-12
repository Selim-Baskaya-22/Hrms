package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="system_staff")
public class SystemStaff {
	
	@Id
	@GeneratedValue	
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="job_id")
	private int jobId;
	
	@Column(name="first_name")
	private String firsName;
	
	@Column(name="last_name")
	private String lastName;

	public SystemStaff() {
	}
	public SystemStaff(int userId ,int jobId, String firsName, String lastName) {
		super();
		this.userId=userId;
		this.jobId = jobId;
		this.firsName = firsName;
		this.lastName = lastName;
	}
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
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
	
}
