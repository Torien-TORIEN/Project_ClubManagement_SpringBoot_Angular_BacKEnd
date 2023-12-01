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

import tn.enicarthage.Entities.Material;
import tn.enicarthage.Services.IMaterialService;

@RestController
public class MaterialController {
	@Autowired
	IMaterialService materialService;
	
	
	@GetMapping("/materials")
	@ResponseBody
	public List<Material> getAll(){
		return materialService.getAllMaterial();
	}
	
	@GetMapping("/materials/{id}")
	@ResponseBody
	public Material getById(@PathVariable("id") int id) {
		return materialService.getMeterialById(id);
	}
	
	@PostMapping("/materials")
	@ResponseBody
	public Material save(@RequestBody Material material) {
		return materialService.addMeterial(material);
	}
	
	@PutMapping("/materials/{id}")
	@ResponseBody
	public Material update(@PathVariable("id") int id,@RequestBody Material material) {
		material.setId(id);
		return materialService.updateMeterial(material);	
	}
	
	@DeleteMapping("/materials/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") int id) {
		materialService.deleteMeterialById(id);
	}

}
