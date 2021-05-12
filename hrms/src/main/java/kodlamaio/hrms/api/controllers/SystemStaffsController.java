package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.entities.concretes.SystemStaff;

@RestController
@RequestMapping("/api/systemStaff")
public class SystemStaffsController {
	
	private SystemStaffService systemStaffService;
	
	@Autowired
	public SystemStaffsController(SystemStaffService systemStaffService) {
		super();
		this.systemStaffService = systemStaffService;
	}
	
	@GetMapping("/getall")
	public List<SystemStaff> getAll(){
		return systemStaffService.getAll();
	}
	
	
}
