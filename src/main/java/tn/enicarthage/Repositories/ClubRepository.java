package tn.enicarthage.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Club;
import tn.enicarthage.Entities.Member;
@Repository
public interface ClubRepository extends CrudRepository<Club, String> {
	@Query(value="select m from club-roles cr , user-roles mr,user m  where cr.club_club_id=:ClubId and cr.roles_id=mr.roles_id and mr.member_cin=m.cin",nativeQuery = true)
	List<Member>getMembersBYClubId(@Param("ClubId")String idClub);
	
	
	@Modifying
	@Transactional
	@Query(value="insert into event_clubs  values(?1,?2)",nativeQuery = true)
	void addEvent(String idEv,String idclub);
	
	@Modifying
	@Transactional
	@Query(value="delete from event_clubs where events_event_id=?1 and clubs_club_id=?2",nativeQuery=true)
	void deleteEvent(String idEv,String idClub);
}
