package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.UsersService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.core.utilities.validations.EmailVerificationService;
import kodlama.hrms.core.utilities.validations.MernisVerificationService;
import kodlama.hrms.dataAccess.abstracts.UsersDao;
import kodlama.hrms.entities.concretes.Users;

@Service
public class UsersManager implements UsersService{

	@Autowired
	public UsersDao usersDao;
	public EmailVerificationService<Users> emailVerificationService;
	public MernisVerificationService<Users> mernisVerificaionService;
	
	public UsersManager(UsersDao usersDao,EmailVerificationService<Users> emailVerificationService,
			MernisVerificationService<Users> mernisVerificaionService ) {
		super();
		this.usersDao = usersDao;
		this.emailVerificationService= emailVerificationService;
		this.mernisVerificaionService=mernisVerificaionService;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		
		return new SuccessDataResult<List<Users>>(this.usersDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result Add(Users users) {
		if(findAllByEmail(users.getEmail())) {
			if(emailVerificationService.CheckIfRealEmail(users)) {
				if(mernisVerificaionService.CheckIfRealPerson(users)) {
					this.usersDao.save(users);
				}
				else
					return new ErrorResult("Böyle Tc'ye ait kişi yok.");
			}
			else
				return new ErrorResult("Böyle bir email yok.");
		}
		else
			return new ErrorResult("Bu email üzerine zaten kayıt var.");
	
		return new SuccessResult();
	}
	
	public boolean findAllByEmail(String email){

		for (var iterable_element : this.getAll().getData()) {
			if(iterable_element.getEmail()==email)
				return false;
		}
		return true;
	}

}