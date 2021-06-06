package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	 DataResult<List<JobSeeker>> getAll();
	 Result Add(JobSeeker jobSeeker);
}