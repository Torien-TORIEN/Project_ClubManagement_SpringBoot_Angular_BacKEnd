package tn.enicarthage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Salle;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Integer> {

}
