package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/link/")
public class LinksController {

	private LinkService linkService;

	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Link>> getAll(){
		return this.linkService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<Link> get(@RequestParam int id){
		return this.linkService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Link link){
		return this.linkService.add(link);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody Link link){
		return this.linkService.delete(link);
	}
}
