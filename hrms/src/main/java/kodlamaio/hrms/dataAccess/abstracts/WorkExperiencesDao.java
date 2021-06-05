package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperiencesDao extends JpaRepository<WorkExperience, Integer>{

}
