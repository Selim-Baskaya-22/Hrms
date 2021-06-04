package kodlamaio.hrms.business.abstracts;

import java.util.List; 

import kodlamaio.hrms.core.business.BusinessCrudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService extends BusinessCrudService<JobAdvertisement> {
	DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);

	DataResult<List<JobAdvertisementDto>> activeJobAdvertisement();

	DataResult<List<JobAdvertisementDto>> passiveJobAdvertisement();
	
	DataResult<List<JobAdvertisementDto>> activeJobAdvertisementOrderByReleaseDate();
	
	DataResult<List<JobAdvertisementDto>> activeJobAdvertisementCompanyName(String companyName);
}
