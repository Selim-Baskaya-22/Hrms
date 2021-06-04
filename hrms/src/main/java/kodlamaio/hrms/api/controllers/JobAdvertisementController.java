package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("api/jobAdvertisement/")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<JobAdvertisement> get(int id){
		return this.jobAdvertisementService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
	@GetMapping("getAllByPage")
	public DataResult<List<JobAdvertisement>> getAll(int pageNo,int pageSize){
		return this.jobAdvertisementService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("activeJobAdvertisement")
	public DataResult<List<JobAdvertisementDto>> activeJobAdvertisement(){
		return this.jobAdvertisementService.activeJobAdvertisement();
	}
	
	@GetMapping("passiveJobAdvertisement")
	public DataResult<List<JobAdvertisementDto>> passiveJobAdvertisement(){
		return this.jobAdvertisementService.passiveJobAdvertisement();
	}
	
	@GetMapping("activeJobAdvertisementOrderByReleaseDate")
	public DataResult<List<JobAdvertisementDto>> activeJobAdvertisementOrderByReleaseDate(){
		return this.jobAdvertisementService.activeJobAdvertisementOrderByReleaseDate();
	}
	
	@GetMapping("activeJobAdvertisementCompanyName")
	public DataResult<List<JobAdvertisementDto>> activeJobAdvertisementCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.activeJobAdvertisementCompanyName(companyName);
	}
}
