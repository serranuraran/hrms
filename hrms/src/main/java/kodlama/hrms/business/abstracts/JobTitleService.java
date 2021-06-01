package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	List<JobTitle> getAll();
	void add(JobTitle jobTitle);
}
