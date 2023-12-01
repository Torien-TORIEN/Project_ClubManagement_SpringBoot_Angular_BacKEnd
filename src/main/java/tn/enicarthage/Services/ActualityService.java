package tn.enicarthage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Actuality;
import tn.enicarthage.Repositories.ActualityRepository;

@Service
public class ActualityService implements IActualityService {
	@Autowired
	ActualityRepository actualityRepository;

	@Override
	public Actuality addActuality(Actuality actuality) {
		return actualityRepository.save(actuality);
	}

	@Override
	public Actuality updateActuality(Actuality actuality) {
		return actualityRepository.save(actuality);
	}

	@Override
	public void deleteActualityById(int ActId) {
		actualityRepository.deleteById(ActId);
	}

	@Override
	public List<Actuality> getAllActuality() {
		return (List<Actuality>)actualityRepository.findAll();
	}

	@Override
	public Actuality getActualityById(int ActID) {
		return actualityRepository.findById(ActID).orElse(null) ;
	}

}
