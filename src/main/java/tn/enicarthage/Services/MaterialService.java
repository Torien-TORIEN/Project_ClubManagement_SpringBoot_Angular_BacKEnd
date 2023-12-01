package tn.enicarthage.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Material;
import tn.enicarthage.Repositories.MaterialRepository;

@Service
public class MaterialService implements IMaterialService {
	@Autowired
	MaterialRepository materialRepository;

	@Override
	public Material addMeterial(Material material) {
		return materialRepository.save(material);
	}

	@Override
	public Material updateMeterial(Material material) {
		return materialRepository.save(material);
	}

	@Override
	public void deleteMeterialById(int id) {
		System.out.println("Deleting Material ID :"+id);
		materialRepository.deleteById(id);
		
	}

	@Override
	public Material getMeterialById(int id) {
		return materialRepository.findById(id).orElse(null);
	}

	@Override
	public List<Material> getAllMaterial() {
		return (List<Material>)materialRepository.findAll();
	}

	@Override
	public int QuantiteDisponiblePourUneDate(Material material, Date date) {
		return 0;
	}

}
