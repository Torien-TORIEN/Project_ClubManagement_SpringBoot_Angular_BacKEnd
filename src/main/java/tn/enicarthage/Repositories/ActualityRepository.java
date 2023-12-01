package tn.enicarthage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Actuality;

@Repository
public interface  ActualityRepository extends CrudRepository<Actuality, Integer> {

}
