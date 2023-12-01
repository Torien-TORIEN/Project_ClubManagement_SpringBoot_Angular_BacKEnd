package tn.enicarthage.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Administrator;
@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, String>{
	Administrator findByEmail(String email);
	List<Administrator> getAdministratorByName(String name);
	List<Administrator> getAdministratorByFirstname(String firstname);
	Administrator getAdministratorByNameAndFirstname(String name, String firstname);
	
}
