package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import kodlamaio.hrms.business.abstracts.CandidateAuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


@RestController
@RequestMapping("api/candidateAuth/")
public class CandidatesAuthController {
	
	

		private CandidateAuthService authService;

		@Autowired
		public CandidatesAuthController(CandidateAuthService authService) {
			super();
			this.authService = authService;
		}
		
		@PostMapping("add")
		public Result add(@RequestBody Candidate candidate) {
			return authService.register(candidate);
		}
		@PostMapping("login")
		public Result login(@RequestBody Candidate candidate) {
			return authService.login(candidate);
		}
		
		
}
