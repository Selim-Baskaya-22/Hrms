package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface SystemStaffService {
	List<SystemStaff> getAll();
}
