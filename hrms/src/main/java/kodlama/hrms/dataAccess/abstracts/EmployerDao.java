package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{


}
