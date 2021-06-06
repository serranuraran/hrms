package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Users;

public interface UsersService {
	DataResult<List<Users>> getAll();
	Result Add(Users users);
}
