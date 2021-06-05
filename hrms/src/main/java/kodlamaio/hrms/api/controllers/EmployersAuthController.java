package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerAuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("api/employerAuth/")
public class EmployersAuthController {
	
	private EmployerAuthService<Employer> employerAuthService;

	@Autowired
	public EmployersAuthController(EmployerAuthService<Employer> employerAuthService) {
		super();
		this.employerAuthService = employerAuthService;
	} 
	
	@PostMapping("register")
	public Result register(@RequestBody Employer employer) {
		return this.employerAuthService.register(employer);
	}
	@PostMapping("login")
	public Result login(@RequestBody Employer employer) {
		return this.employerAuthService.login(employer);
	}
}
