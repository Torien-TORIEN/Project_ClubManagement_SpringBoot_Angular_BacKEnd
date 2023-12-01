package tn.enicarthage.Services;

import java.util.List;

import tn.enicarthage.Entities.Administrator;

public interface IAdministratoService {
	
	public Administrator addAministrator(Administrator administrator);
	public Administrator updateAministrator(Administrator administrator);
	public void deleteAdministrator(Administrator administrator);
	public Administrator getAdministratorByCin(String cin);
	public Administrator getAdministratorByEmail(String email);
	public List<Administrator> getAdministratorByName(String name);
	public List<Administrator> getAdministratorByFirsname(String firsname);
	public Administrator getAdministratorByNameAndFirstname(String name,String firstname);
	public List<Administrator> getAllAdministrators();
	
	public void accepterEvent(String idEvent);
	public void refuserEvent(String idEvent);
	void deleteAdministratorByCin(String cin);
	
	
}
