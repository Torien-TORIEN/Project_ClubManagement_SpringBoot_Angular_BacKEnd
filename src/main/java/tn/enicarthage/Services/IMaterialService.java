package tn.enicarthage.Services;

import java.util.Date;
import java.util.List;

import tn.enicarthage.Entities.Material;

public interface IMaterialService  {
	//CRUD Methodes
	
	public Material addMeterial(Material material);
	public Material updateMeterial(Material material);
	public void deleteMeterialById(int id);
	public Material getMeterialById(int id);
	
	public List<Material> getAllMaterial();
	
	public int QuantiteDisponiblePourUneDate(Material material, Date date);
	

}
