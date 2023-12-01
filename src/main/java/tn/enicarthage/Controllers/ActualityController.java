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

import tn.enicarthage.Services.IActualityService;
import tn.enicarthage.Entities.Actuality;

@RestController
public class ActualityController {
	@Autowired
	IActualityService actualityService;
	
	@GetMapping("/actualities")
	@ResponseBody
	public List<Actuality> getAllActualities(){
		return actualityService.getAllActuality();
	}
	
	@GetMapping("/actualities/{id}")
	@ResponseBody
	public Actuality getActuality(@PathVariable("id") int id) {
		return actualityService.getActualityById(id);
	}
	
	@PostMapping("/actualities")
	@ResponseBody
	public Actuality saveActuality(@RequestBody Actuality actuality) {
		return actualityService.addActuality(actuality);
	}
	
	@PutMapping("/actualities/{id}")
	@ResponseBody
	public Actuality updateActuality(@PathVariable("id") int id, @RequestBody Actuality actuality) {
		actuality.setId(id);
		return actualityService.updateActuality(actuality);
	}
	
	@DeleteMapping("/actualities/{id}")
	@ResponseBody
	public void deleteActuality(@PathVariable("id") int id) {
		actualityService.deleteActualityById(id);
	}

}
