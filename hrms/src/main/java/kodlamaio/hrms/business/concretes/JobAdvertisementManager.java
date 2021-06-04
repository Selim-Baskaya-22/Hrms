package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constants.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
 
@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), SuccessMessages.jobAdvertisementListed);
	}

	@Override
	public DataResult<JobAdvertisement> get(int id) {
		
		Optional<JobAdvertisement> jobAdvertisement= this.jobAdvertisementDao.findById(id);
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisement.get(), SuccessMessages.jobAdvertisementListed);
	}

	@Override
	public Result add(JobAdvertisement entity) {
		this.jobAdvertisementDao.save(entity);
		return new SuccessResult(SuccessMessages.jobAdvertisementAdded);
	}

	@Override
	public Result delete(JobAdvertisement entity) {
		this.jobAdvertisementDao.delete(entity);
		return new SuccessResult(SuccessMessages.jobAdvertisementDeleted);
	}

	@Override
	public Result update(JobAdvertisement entity) {
		
		Optional<JobAdvertisement> job=this.jobAdvertisementDao.findById(entity.getId());
		
		JobAdvertisement jobUpdated=job.get();
		jobUpdated.setJob(jobUpdated.getJob());
		jobUpdated.setCity(jobUpdated.getCity());
		jobUpdated.setEmployer(jobUpdated.getEmployer());
		jobUpdated.setMinSalary(jobUpdated.getMinSalary());
		jobUpdated.setMaxSalary(jobUpdated.getMaxSalary());
		jobUpdated.setNumberOfPeople(jobUpdated.getNumberOfPeople());
		jobUpdated.setApplicationDeadline(jobUpdated.getApplicationDeadline());
		jobUpdated.setDescription(jobUpdated.getDescription());
		jobUpdated.setIsActive(jobUpdated.getIsActive());
		
		this.jobAdvertisementDao.save(jobUpdated);
		
		
		return new SuccessResult(SuccessMessages.jobAdvertisementUpdated);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(),SuccessMessages.jobAdvertisementListed);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> activeJobAdvertisement() {

        return new SuccessDataResult<List<JobAdvertisementDto>>( this.jobAdvertisementDao.findByisActive(true),SuccessMessages.activeJobAdvertisementListed);
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> passiveJobAdvertisement() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByisActive(false),SuccessMessages.passiveJobAdvertisementListed);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> activeJobAdvertisementOrderByReleaseDate() {
		
		Sort sort= Sort.by(Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByisActive(true, sort));

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> activeJobAdvertisementCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByisActive(true, companyName),SuccessMessages.jobAdvertisementListed);
	}
	

																	


}
