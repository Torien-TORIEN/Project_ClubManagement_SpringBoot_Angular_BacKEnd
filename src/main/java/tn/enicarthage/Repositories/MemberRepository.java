package tn.enicarthage.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {
	Member getMemberByEmail(String email);
	
	@Query(value="select m from Member m where m.name=?1 and m.firstname=?2",nativeQuery = false)
	Member getMemberByNameAndFirtsName(String name, String fname);
	
	@Modifying
	@Query(value="delete from role r  where r.membre_cin=?1 and r.club_club_id=?2 ",nativeQuery = true)
	void deleteClubMemberByCin(String cin, String idclub);
	
	@Modifying
	@Query(value="update role r set r.membre_cin=?1, r.club_club_id=?3 where id=?2",nativeQuery = true)
	void affecterMemberAuClub(String cin, int role,String idClub);
	

	
	@Query(value="select c from Club c , Role r where r.club.id=c.id and r.membre.CIN=?1 ")
	List<Club> getClubsByMemberCin(String cin);
	
	@Query(value="select m from Member m where m.name=?1")
	List<Member> getAllMembersByName(String name);
	
	@Query(value="select m from Member m where m.firstname=?1")
	List<Member> getAllMembersByFistName(String fname);
}
