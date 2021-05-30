package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {

}
