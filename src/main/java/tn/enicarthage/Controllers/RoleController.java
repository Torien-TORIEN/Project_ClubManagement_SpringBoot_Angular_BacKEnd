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

import tn.enicarthage.Entities.Role;
import tn.enicarthage.Services.IRoleService;



@RestController
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	
	@GetMapping("/roles")
	@ResponseBody
	public List<Role> getAll(){
		return roleService.getAllRoles();
	}
	
	@GetMapping("/roles/{id}")
	@ResponseBody
	public Role getById(@PathVariable("id") int id) {
		return roleService.getRoleById(id);
	}
	
	@PostMapping("/roles")
	@ResponseBody
	public Role save(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	
	@PutMapping("/roles/{id}")
	@ResponseBody
	public Role update(@PathVariable("id") int id,@RequestBody Role role) {
		role.setId(id);
		return roleService.updateRole(role);	
	}
	
	@DeleteMapping("/roles/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") int id) {
		roleService.deleteRole(id);
	}

}
