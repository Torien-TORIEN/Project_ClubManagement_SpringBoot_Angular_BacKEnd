package tn.enicarthage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Administrator;
import tn.enicarthage.Entities.Event;
import tn.enicarthage.Repositories.AdministratorRepository;
import tn.enicarthage.Repositories.EventRepository;

@Service
public class AdministratorService implements IAdministratoService {
	
	@Autowired
	AdministratorRepository administratorRepository;
	
	@Autowired
	EventRepository eventRepository;


	@Override
	public Administrator addAministrator(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	@Override
	public Administrator updateAministrator(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	@Override
	public void deleteAdministrator(Administrator administrator) {
		administratorRepository.delete(administrator);
	}
	
	@Override
	public void deleteAdministratorByCin(String cin) {
		administratorRepository.deleteById(cin);
	}

	@Override
	public Administrator getAdministratorByCin(String cin) {
		return administratorRepository.findById(cin).orElse(null);
	}

	@Override
	public Administrator getAdministratorByEmail(String email) {
		return administratorRepository.findByEmail(email);
	}

	@Override
	public List<Administrator> getAdministratorByName(String name) {
		return administratorRepository.getAdministratorByName(name);
	}

	@Override
	public List<Administrator> getAdministratorByFirsname(String firsname) {
		return administratorRepository.getAdministratorByFirstname(firsname) ;
	}

	@Override
	public Administrator getAdministratorByNameAndFirstname(String name, String firstname) {
		return administratorRepository.getAdministratorByNameAndFirstname(name,firstname);
	}

	@Override
	public List<Administrator> getAllAdministrators() {
		return (List<Administrator>) administratorRepository.findAll();
	}

	@Override
	public void accepterEvent(String idEvent) {
		Event event=eventRepository.findById(idEvent).orElse(null);
		if(event!=null) {
			event.setStatus("OUI");
		}
	}

	@Override
	public void refuserEvent(String idEvent) {
		eventRepository.deleteById(idEvent);
	}

}
