package tn.enicarthage.Services;


import java.util.List;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Member;
import tn.enicarthage.Entities.Role;

public interface IMemberService {
	
	public Member addMember(Member member);
	public Member updateMember(Member member);
	public void deleteMember(String cin);
	public Member getMemberByCin(String cin);
	public Member getMemberByNameAndFirstname(String name, String firsname);
	public Member getMemberByEmail(String email);
	
	//Liste des Membres
	public List<Member> getAllMember();
	public List<Member> getMemberByName(String name);
	public List<Member> getMemberByFirstname(String firstname);
	
	//Apropos des clubs
	public List<Club> getAllClubsByMemberCin(String cin);
	public void quitterClub(String cin,String clubId);
	public void affecterMembreAuClub(String cin, int role,String Club);
	
	
	
}
