package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverLetter/")
public class CoverLettersController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<CoverLetter> get(@RequestParam int id){
		return this.coverLetterService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CoverLetter coverLetter){
		return this.coverLetterService.add(coverLetter);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody CoverLetter coverLetter){
		return this.coverLetterService.delete(coverLetter);
	}
}
