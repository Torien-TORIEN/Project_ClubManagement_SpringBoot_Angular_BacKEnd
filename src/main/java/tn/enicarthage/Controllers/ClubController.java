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
import tn.enicarthage.Entities.Member;
import tn.enicarthage.Services.IClubService;

@RestController
public class ClubController {
	
	@Autowired
	IClubService clubService;
	
	@GetMapping("/clubs")
	@ResponseBody
	public List<Club> getAllClubs(){
		return clubService.getAllClub();
	}
	
	@GetMapping("/clubs/{idClub}")
	public Club getClubById(@PathVariable("idClub") String id) {
		return clubService.getClubById(id);
	}
	
	@PostMapping("/clubs")
	@ResponseBody
	public Club ajouterClub(@RequestBody Club club) {
		return clubService.addClub(club);
	}
	
	@PutMapping("/clubs/{id}")
	@ResponseBody
	public Club updateClubById(@PathVariable("id") String  id,@RequestBody Club club) {
		club.setId(id);
		return clubService.updateClub(club);
	}
	
	@DeleteMapping("/clubs/{id}")
	public void removeClub(@PathVariable("id") String id) {
		clubService.deleteClubById(id);
	}
	
	@GetMapping("/clubs/members/{idClub}")
	@ResponseBody
	public List<Member> getMembersOfClub(@PathVariable("idClub") String idClub){
		return clubService.getAllMembersByIdClub(idClub);
	}
	
	@GetMapping("/clubs/events/{idClub}")
	@ResponseBody
	public Set<Event> getEventsByClubId(@PathVariable("idClub") String idClub){
		return clubService.getAllEventByClubId(idClub);
	}
	
	@GetMapping("/clubs/president/{idClub}")
	@ResponseBody
	public Member getPresident(@PathVariable("idClub") String id) {
		return clubService.getPresident(id);
	}
	
	@PostMapping("/clubs/president/add/{cin}/{idClub}")
	@ResponseBody
	public Member setPresident(@PathVariable("cin") String cin, @PathVariable("idClub") String idClub) {
		return clubService.setPresident(cin, idClub);
	}
	
	@DeleteMapping("/clubs/president/delete/{cin}/{idClub}")
	@ResponseBody
	public void deletePresident(@PathVariable("cin") String cin, @PathVariable("idClub") String idClub) {
		clubService.deletePresident(cin, idClub);
	}
	
	@PostMapping("/events/clubs/add/{idEv}/{idClub}")
	@ResponseBody
	public Event addEvent(@PathVariable("idEv") String idEv , @PathVariable("idClub") String idClub) {
		return clubService.addEvent(idEv, idClub);
	}
	
	@DeleteMapping("/clubs/events/delete/{idEv}/{idClub}")
	@ResponseBody
	public void deleteEvent(@PathVariable("idEv") String idEv , @PathVariable("idClub") String idClub) {
		clubService.deleteEvent(idEv, idClub);
	}

}
