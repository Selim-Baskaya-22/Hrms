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

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skill/")
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<Skill> get(@RequestParam int id){
		return this.skillService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Skill skill){
		return this.skillService.add(skill);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody Skill skill){
		return this.skillService.delete(skill);
	}
}
