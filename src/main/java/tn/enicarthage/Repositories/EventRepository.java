package tn.enicarthage.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
	Event getEventByTitle(String title);
	
	@Query(value="select ec.clubs_club_id from event_clubs ec where ec.events_event_id=?1",nativeQuery = true)
	List<String> getClubIdByEventId(String idEv);
	
	@Modifying
	@Transactional
	@Query(value="delete from event_clubs  where events_event_id =?1",nativeQuery = true)
	void deleteClubEvent(String idev);
}
