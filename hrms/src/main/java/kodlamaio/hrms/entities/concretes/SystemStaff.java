package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.Table;




@Entity
@Table(name="system_staff")
public class SystemStaff extends User{
	
	@Column(name="first_name")
	private String firsName;
	
	@Column(name="last_name")
	private String lastName;


	public SystemStaff() {
	}
	public SystemStaff(String firsName, String lastName) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
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
