package kodlama.hrms.business.concretes;

           

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobTitleService;
import kodlama.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}
	
	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}

	@Override
	public void add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);		
	}
	

}