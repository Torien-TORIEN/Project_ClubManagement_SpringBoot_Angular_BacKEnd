package tn.enicarthage.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.enicarthage.Entities.Salle;
import tn.enicarthage.Repositories.SalleRepository;

@Service
public class SalleService implements ISalleService {
	@Autowired
	SalleRepository salleRepository;

	@Override
	public Salle addSalle(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public Salle updateSalle(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public void deleteSalleById(int id) {
		salleRepository.deleteById(id);
	}

	@Override
	public Salle getSallelById(int id) {
		return salleRepository.findById(id).orElse(null);
	}

	@Override
	public List<Salle> getAllSalle() {
		return (List<Salle>) salleRepository.findAll();
	}

	@Override
	public int estOccuperPourUneDate(Salle salle, Date date) {
		return 0;
	}

}
