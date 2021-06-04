package kodlamaio.hrms.api.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;


// Burada jobsun sonuna '/' koydugumuz icin getall da herhangi bir sekilde slash koymamiza gerek kalmiyor
 	

@RestController
@RequestMapping("/api/jobs/")
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Job>> getAll(){
		return jobService.getAll();
	}
	@GetMapping("getAllByPage")
	public DataResult<List<Job>> getAll( int pageNo, int pageSize){
		return jobService.getAll(pageNo,pageSize);
	}
	@PostMapping("add")
	public Result add(@RequestBody Job job) {
		return jobService.add(job);
	}
}
