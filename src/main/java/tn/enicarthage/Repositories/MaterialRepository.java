package tn.enicarthage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Material;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {

}
