package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Users;

public interface UsersDao extends JpaRepository<Users, Integer>{

}
