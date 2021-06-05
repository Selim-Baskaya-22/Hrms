package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/language/")
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<Language> get(@RequestParam int id){
		return this.languageService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Language language){
		return this.languageService.add(language);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody Language language){
		return this.languageService.delete(language);
	}
}
