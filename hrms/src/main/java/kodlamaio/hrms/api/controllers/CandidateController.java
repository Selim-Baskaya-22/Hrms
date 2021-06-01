package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidate/")
public class CandidateController {

	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Candidate>> getAll(){
		return candidateService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Candidate candidate) {
		return candidateService.add(candidate);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody Candidate candidate) {
		return candidateService.update(candidate);	
	}
	
	@DeleteMapping("delete/{id}")
	public Result delete(@RequestBody Candidate candidate) {		
		return this.candidateService.delete(candidate);
	}
	
	@GetMapping("getId/{id}")
	public Result getById(int id) {
		return this.candidateService.get(id);
	}
	@GetMapping("getByEmail/{email}")
	public Result getByEmail(String email) {
		return this.candidateService.getByEmail(email);
	}
}
