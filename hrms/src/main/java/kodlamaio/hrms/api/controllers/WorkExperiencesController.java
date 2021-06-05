package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workExperience/")
public class WorkExperiencesController {

	private WorkExperienceService experienceService;

	public WorkExperiencesController(WorkExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<WorkExperience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<WorkExperience> get(@RequestParam int id){
		return this.experienceService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody WorkExperience workExperience){
		return this.experienceService.add(workExperience);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody WorkExperience workExperience){
		return this.experienceService.delete(workExperience);
	}
}
