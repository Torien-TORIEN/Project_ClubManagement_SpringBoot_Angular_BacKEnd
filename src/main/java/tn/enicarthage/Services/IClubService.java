package tn.enicarthage.Services;

import java.util.List;
import java.util.Set;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Event;
import tn.enicarthage.Entities.Member;

public interface IClubService {
	
	public Club addClub(Club c);
	public Club updateClub(Club c);
	public void deleteClub(Club c);
	public void deleteClubById(String id);
	public Club getClubById(String id );
	public List<Club> getAllClub();
	
	public Member getPresident(String idClub);
	public List<Member> getAllMembersByIdClub(String IdClub);
	public Set<Event> getAllEventByClubId(String clubId);
	
	public Member setPresident(String cin,String idclub);
	public Event addEvent(String idEv,String club);
	
	public void deletePresident(String cin,String idclub);
	public void deleteEvent(String idEv,String club);
	
	

}
