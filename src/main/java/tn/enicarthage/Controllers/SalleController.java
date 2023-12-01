package tn.enicarthage.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Entities.Locale;
import tn.enicarthage.Entities.Salle;
import tn.enicarthage.Services.ISalleService;

@RestController
public class SalleController {
	@Autowired
	ISalleService salleService;
	
	
	@GetMapping("/salles")
	@ResponseBody
	public List<Salle> getAll(){
		return salleService.getAllSalle();
	}
	
	@GetMapping("/salles/{id}")
	@ResponseBody
	public Salle getById(@PathVariable("id") int id) {
		return salleService.getSallelById(id);
	}
	
	@PostMapping("/salles")
	@ResponseBody
	public Salle saveSalle(@RequestBody Salle salle) {
		return salleService.addSalle(salle);
	}
	
	@PutMapping("/salles/{id}")
	@ResponseBody
	public Salle updateSalle(@PathVariable("id") int id,@RequestBody Salle salle) {
		salle.setId(id);
		return salleService.updateSalle(salle);	
	}
	
	@DeleteMapping("/salles/{id}")
	@ResponseBody
	public void deleteSalle(@PathVariable("id") int id) {
		 salleService.deleteSalleById(id);
	}

}
