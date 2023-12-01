package tn.enicarthage.Services;

import java.util.List;
import java.util.Set;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Event;
import tn.enicarthage.Entities.Material;

public interface IEventService {
	//Methodes CRUD
	public Event addEvent(Event event);
	public Event updateEvent(Event event);
	public Event getEventById(String id);
	public void deleteEventById(String id);
	public Event getEventByTitle(String title);
	public List<Event> getAll();
	
	public Event affecterSalleAEvent(String event,int salleId);
	public void deleteEventSalle(String Idev);
	
	public Event addEventMateriel(String idEv,int idMat);
	public void deleteEventMaterielById(String idEv,int idMat );
	
	public List<Club> getClubs(String idEv); 
	
	public Event accepterDemande(String idEv);
	

}
