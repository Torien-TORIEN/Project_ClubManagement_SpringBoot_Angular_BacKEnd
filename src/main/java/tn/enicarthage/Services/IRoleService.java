package tn.enicarthage.Services;

import java.util.List;

import tn.enicarthage.Entities.Role;

public interface IRoleService {
	//CRUD Methodes 
	public Role addRole(Role role);
	public Role updateRole(Role role);
	public void deleteRole(int id);
	public Role getRoleById(int Id);
	
	public List<Role> getAllRoles();

}
