package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(ja.id,e.companyName,j.name,ja.releaseDate,ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.job j Inner Join ja.employer e where ja.isActive=:active")
	List<JobAdvertisementDto> findByisActive(boolean active);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(ja.id,e.companyName,j.name,ja.releaseDate,ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.job j Inner Join ja.employer e where ja.isActive=:active ")
	List<JobAdvertisementDto> findByisActive(boolean active,Sort releaseDate);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(ja.id,e.companyName,j.name,ja.releaseDate,ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.job j Inner Join ja.employer e where ja.isActive=:active and e.companyName=:companyName")
	List<JobAdvertisementDto> findByisActive(boolean active,String companyName);

}
