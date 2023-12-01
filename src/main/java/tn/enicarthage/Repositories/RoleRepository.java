package tn.enicarthage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer > {

}
