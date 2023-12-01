package tn.enicarthage.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Entities.Administrator;
import tn.enicarthage.Entities.Genre;
import tn.enicarthage.Services.IAdministratoService;

@RestController
public class AdministratorController {
	@Autowired
	IAdministratoService administratoService;
	
	@GetMapping("/users/administrators")
	@ResponseBody
	public List<Administrator> getAllAdministrator(){
		/*Administrator admin= new Administrator("12345678","ALI","Nadhim","ali@gmail.com","123",Genre.Masculin,"enseignant");
		administratoService.addAministrator(admin);*/
		return administratoService.getAllAdministrators();
	}
	
	@GetMapping("/users/administrators/{cin}")
	@ResponseBody
	public Administrator getAdminByCin(@PathVariable("cin") String cin) {
		return administratoService.getAdministratorByCin(cin);
	}
	
	@GetMapping("/users/administrators/e/{mail}")
	@ResponseBody
	public Administrator getAdminByEmail(@PathVariable("mail") String cin) {
		return administratoService.getAdministratorByEmail(cin);
	}
	
	@GetMapping("/users/administrators/n/{name}")
	@ResponseBody
	public List<Administrator> getAdminByName(@PathVariable("name") String cin) {
		return administratoService.getAdministratorByName(cin);
	}
	
	@GetMapping("/users/administrators/f/{fname}")
	@ResponseBody
	public List<Administrator> getAdminByFname(@PathVariable("fname") String cin) {
		return administratoService.getAdministratorByFirsname(cin);
	}
	
	@GetMapping("/users/administrators/{name}/{fname}")
	@ResponseBody
	public Administrator getAdminByCin(@PathVariable("name") String name,@PathVariable("fname")String fname) {
		return administratoService.getAdministratorByNameAndFirstname(name, fname);
	}
	
	@PostMapping("/users/administrators")
	@ResponseBody
	public Administrator save(@RequestBody Administrator administrator) {
		return administratoService.addAministrator(administrator);
	}



}
