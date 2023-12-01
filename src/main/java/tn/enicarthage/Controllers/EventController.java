package tn.enicarthage.Controllers;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Event;
import tn.enicarthage.Services.IEventService;

@RestController
public class EventController {
	
	
	@Autowired
	IEventService eventService;
	
	@GetMapping("/events")
	public List<Event> getAll(){
		/*Event ev=new Event("FormationCpp","Formation de C++","Non",new Date(),null,"description","All",24,null,"Annexe",null,null);
		Salle s= new Salle(1101,101,Locale.Annexe,"Salle Mac");
		ev.setSalle(s);
		eventService.addEvent(ev);*/
		
		return eventService.getAll();
	}
	
	@GetMapping("/events/{id}")
	public Event getEvent(@PathVariable("id") String id) {
		return eventService.getEventById(id);
	}
	
	@GetMapping("events/clubs/{idEv}")
	@ResponseBody
	public List<Club> getClubs(@PathVariable("idEv") String idEv){
		return eventService.getClubs(idEv);
	}
	
	
	@PostMapping("/events")
	@ResponseBody
	public Event save(@RequestBody Event event) {
		return eventService.addEvent(event);
	}
	
	@PutMapping("/events/{id}")
	@ResponseBody
	public Event update(@PathVariable("id") String id, @RequestBody Event event) {
		event.setId(id);
		return eventService.updateEvent(event);
	}
	
	@DeleteMapping("/events/{id}")
	public void delete(@PathVariable("id") String id) {
		eventService.deleteEventById(id);
	}
	
	@PostMapping("/events/salle/add/{idEv}/{idSalle}")
	@ResponseBody
	public Event setEventsalle(@PathVariable("idEv")String idEv, @PathVariable("idSalle") int idS) {
		return eventService.affecterSalleAEvent(idEv, idS);
	};
	
	@DeleteMapping("/events/salle/delete/{idEv}")
	@ResponseBody
	public void deleteEventsalle(@PathVariable("idEv")String idEv) {
		 eventService.deleteEventSalle(idEv);
	};
	
	@PostMapping("/events/material/add/{idEv}/{idMat}")
	@ResponseBody
	public Event addevEntMaterial(@PathVariable("idEv") String idEv ,@PathVariable("idMat") int idMat) {
		return eventService.addEventMateriel(idEv, idMat);
	}

	@DeleteMapping("/events/material/delete/{idEv}/{idMat}")
	@ResponseBody
	public void deleteEventMaterial(@PathVariable("idEv") String idEv ,@PathVariable("idMat") int idMat) {
		eventService.deleteEventMaterielById(idEv, idMat);
	}
	
	@PostMapping("/events/accepter/{idEv}")
	@ResponseBody
	public Event accepterEvent(@PathVariable("idEv") String id) {
		return eventService.accepterDemande(id);
	}
	
	

}
