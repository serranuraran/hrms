package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.UsersService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Users;

@RestController
@RequestMapping("api/users")
public class UsersControllers {

	@Autowired
	private UsersService usersService;

	public UsersControllers(UsersService usersService) {
		this.usersService = usersService;
	}

	@GetMapping("/getall")
	public DataResult<List<Users>> getAll(){
		return this.usersService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Users users) {
		return this.usersService.Add(users);

	}

}