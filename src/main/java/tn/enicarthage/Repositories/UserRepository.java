package tn.enicarthage.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	//User findByEmailOrCIN(String login );
	@Query(value="Select u from User u where (u.CIN=?1 or u.email=?1)")
	User findByEmailOrCIN(String login);
}
