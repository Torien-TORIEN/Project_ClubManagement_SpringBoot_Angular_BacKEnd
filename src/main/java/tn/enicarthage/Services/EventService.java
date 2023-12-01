package tn.enicarthage.Services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Event;
import tn.enicarthage.Entities.Material;
import tn.enicarthage.Entities.Salle;
import tn.enicarthage.Repositories.ClubRepository;
import tn.enicarthage.Repositories.EventRepository;
import tn.enicarthage.Repositories.MaterialRepository;
import tn.enicarthage.Repositories.SalleRepository;

@Service
public class EventService implements IEventService {
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	SalleRepository salleRepository;
	
	@Autowired
	MaterialRepository materialRepository;
	
	@Autowired
	ClubRepository clubRepository;
	
	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		return eventRepository.save(event);
	}

	@Override
	public Event updateEvent(Event event) {
		// TODO Auto-generated method stub
		return eventRepository.save(event);
	}
	
	@Override
	public void deleteEventById(String id){
		System.out.println("SUPPRESSION d'EVENEMENTS "+id);
		eventRepository.deleteClubEvent(id);
		eventRepository.deleteById(id);
	}

	@Override
	public Event getEventById(String event) {
		// TODO Auto-generated method stub
		return eventRepository.findById(event).orElse(null);
	}

	@Override
	public Event getEventByTitle(String title) {
		// TODO Auto-generated method stub
		return eventRepository.getEventByTitle(title);
	}

	@Override
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public Event affecterSalleAEvent(String idev,int salleId) {
		Event event=eventRepository.findById(idev).orElse(null);
		Salle s=salleRepository.findById(salleId).orElse(null);
		if(event!=null && s!=null) {
			event.setSalle(s);
			return eventRepository.save(event);
		}
		return null;
		
	}

	@Override
	public void deleteEventSalle(String Idev) {
		Event event=eventRepository.findById(Idev).orElse(null);
		if(event!=null) {
			event.setSalle(null);
			eventRepository.save(event);
		}
	}

	@Override
	public Event addEventMateriel(String idEv, int idMat) {
		Event event=eventRepository.findById(idEv).orElse(null);
		Material material=materialRepository.findById(idMat).orElse(null);
		if(event!=null && material!=null) {
			if(event.getMateriels().equals(null)) {
				event.initializeMaterial();
			}
			event.getMateriels().add(material);
			eventRepository.save(event);
			return event;
		}
		return null;
	}

	@Override
	public void deleteEventMaterielById(String idEv, int idMat) {
		Event event=eventRepository.findById(idEv).orElse(null);
		Material material=materialRepository.findById(idMat).orElse(null);
		if(event!=null && material!=null) {
			if(event.getMateriels().contains(material)) {
				event.getMateriels().remove(material);
				eventRepository.save(event);
				System.out.println("Material :"+idMat+" removed ");
			}
		}
	}

	@Override
	public List<Club> getClubs(String idEv) {
		List<String> idClubs = eventRepository.getClubIdByEventId(idEv);
		List<Club> clubs= new ArrayList<>();
		idClubs.stream().forEach(id->{
			Club club=clubRepository.findById(id).orElse(null);
			clubs.add(club);
		});
		Event ev=eventRepository.findById(idEv).orElse(null);
		return clubs;
	}

	@Override
	public Event accepterDemande(String idEv) {
		Event event = eventRepository.findById(idEv).orElse(null);
		if(event!=null) {
			event.setStatus("Oui");
			return eventRepository.save(event);
		}
		return null;
	}
		

}
