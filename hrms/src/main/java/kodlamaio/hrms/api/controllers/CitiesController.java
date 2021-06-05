package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;


@RestController
@RequestMapping("/api/city/")
public class CitiesController {
   
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<City> get(int id){
		return this.cityService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody City city){
		return this.cityService.add(city);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody City city) {
		return this.cityService.update(city);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody City city) {
		return this.cityService.delete(city);
	}
	
	
	
}
