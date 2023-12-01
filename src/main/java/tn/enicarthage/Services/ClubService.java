package tn.enicarthage.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Event;
import tn.enicarthage.Entities.Member;
import tn.enicarthage.Repositories.ClubRepository;
import tn.enicarthage.Repositories.EventRepository;
import tn.enicarthage.Repositories.MemberRepository;

@Service
public class ClubService implements IClubService{
	
	@Autowired
	ClubRepository clubRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	EventRepository eventRepository;
	

	@Override
	public Club addClub(Club c) {
		return clubRepository.save(c);
	}

	@Override
	public Club updateClub(Club c) {
		return clubRepository.save(c);
	}

	@Override
	public void deleteClub(Club c) {
		clubRepository.delete(c);
		
	}

	@Override
	public Club getClubById(String id) {
		return clubRepository.findById(id).orElse(null);
		 
	}

	@Override
	public List<Club> getAllClub() {
		return (List<Club>) clubRepository.findAll();
	}

	@Override
	public void deleteClubById(String id) {
		clubRepository.deleteById(id);
		
	}
	
	@Override
	public Member getPresident(String idClub) {
		Club club =clubRepository.findById(idClub).orElse(null);
		if(club!=null) {
			Member president=club.getPresident();
			System.out.println("President :"+president);
			return president;
		}
		return null;
	}
	

	@Override
	public List<Member> getAllMembersByIdClub(String IdClub) {
		return clubRepository.getMembersBYClubId(IdClub);
	}
	
	@Override
	public Set<Event> getAllEventByClubId(String clubId){
		Club club=clubRepository.findById(clubId).orElse(null);
		return club.getEvents();
	}
	

	@Override
	public Member setPresident(String cin, String idclub) {
		Member member=memberRepository.findById(cin).orElse(null);
		Club club=clubRepository.findById(idclub).orElse(null);
		System.out.println("Member :"+member);
		//System.out.println("Club :"+club);
		if(member!=null && club!=null) {
			club.setPresident(member);
			clubRepository.save(club);
			return member;
		}
		System.out.println("Non trouvé !");
		return null;
	}

	@Override
	public Event addEvent(String idEv, String idclub) {
		Event event=eventRepository.findById(idEv).orElse(null);
		Club club=clubRepository.findById(idclub).orElse(null);
		if(event!=null && club!=null) {
			if(!club.getEvents().contains(event))
				clubRepository.addEvent(idEv,idclub);
				return  event;
			
		}
		return null;
	}

	@Override
	public void deletePresident(String cin, String idclub) {
		Member member=memberRepository.findById(cin).orElse(null);
		Club club=clubRepository.findById(idclub).orElse(null);
		if(member!=null && club!=null && club.getPresident().equals(member)) {
			club.setPresident(null);
			clubRepository.save(club);
		}
		
	}

	@Override
	public void deleteEvent(String idEv, String idclub) {
		Event event=eventRepository.findById(idEv).orElse(null);
		Club club=clubRepository.findById(idclub).orElse(null);
		if(event!=null && club!=null) {
			//System.out.println(" Events :"+event.getClubs());
			if(club.getEvents().contains(event)) {
				clubRepository.deleteEvent(idEv,idclub);
				//club.getEvents().remove(event);
				//clubRepository.save(club);
				//eventRepository.save(event);
				System.out.println("Romoved");
			}
		}
		
	}
}
