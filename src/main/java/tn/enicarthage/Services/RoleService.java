package tn.enicarthage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Role;
import tn.enicarthage.Repositories.RoleRepository;

@Service
public class RoleService implements IRoleService{
	@Autowired 
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
		
	}

	@Override
	public Role getRoleById(int Idnotif) {
		return roleRepository.findById(Idnotif).orElse(null);
	}

	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}

}
