package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.EmployerService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	    @Autowired
		private final EmployerService employerService;

		public EmployersController(EmployerService employerService) {
			this.employerService = employerService;
		}

		@GetMapping("/getall")
		public DataResult<List<Employer>> getAll(){
			return this.employerService.getAll();
		}

		@PostMapping("/add")
	    public Result add(@RequestBody Employer employer){
	        
			return this.employerService.Add(employer);
		}
	}
