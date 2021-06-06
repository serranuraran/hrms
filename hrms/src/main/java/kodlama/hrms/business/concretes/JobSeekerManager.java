package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobSeekerService;
import kodlama.hrms.business.abstracts.UsersService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{


	public UsersService usersService;
	public JobSeekerDao jobSeekerDao;
	@Autowired
	public JobSeekerManager(UsersService usersService,JobSeekerDao jobSeekerDao) {
		super();
		this.usersService = usersService;
		this.jobSeekerDao=jobSeekerDao;
	}
	public JobSeekerManager() {}
	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Listelendi");
	}

	@Override
	public Result Add(JobSeeker jobSeeker) {
		if(this.checkIfİsThereUser(jobSeeker.getUserId()))
		{
			if(!this.CheckIfUserAlreadySeeker(jobSeeker.getUserId()))
			{
				this.jobSeekerDao.save(jobSeeker);							
				return new SuccessResult("İş arayanlara eklendi");
			}
			return new SuccessResult("Zaten bu kullanıcı iş arayanlardan");
		}
		else
			return new SuccessResult("Böyle bir kullanıcı yok.");

	}

	private boolean checkIfİsThereUser(int userId) 
	{
		return this.usersService.getAll().getData().stream()
				.filter(u -> u.getUserId() == userId)
				.findFirst().isPresent();
	}

	private boolean CheckIfUserAlreadySeeker(int userId){

		return this.getAll().getData().stream()
				.filter(u -> u.getUserId() == userId)
				.findFirst().isPresent();
	}

}