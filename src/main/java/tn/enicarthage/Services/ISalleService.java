package tn.enicarthage.Services;

import java.util.Date;
import java.util.List;

import tn.enicarthage.Entities.Salle;

public interface ISalleService {
	//CRUD Methodes
	public Salle addSalle(Salle salle);
	public Salle updateSalle(Salle salle);
	public void deleteSalleById(int id);
	public Salle getSallelById(int id);
	
	public List<Salle> getAllSalle();
	
	public int estOccuperPourUneDate(Salle salle,Date date);
	
}
