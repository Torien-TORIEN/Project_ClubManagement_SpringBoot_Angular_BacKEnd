package tn.enicarthage.Services;

import java.util.List;

import tn.enicarthage.Entities.Actuality;

public interface IActualityService {
	
	public Actuality addActuality(Actuality actuality);
	public Actuality updateActuality(Actuality actuality);
	public void deleteActualityById( int ActId);
	public List<Actuality> getAllActuality();
	public Actuality getActualityById(int ActID);
	

}
