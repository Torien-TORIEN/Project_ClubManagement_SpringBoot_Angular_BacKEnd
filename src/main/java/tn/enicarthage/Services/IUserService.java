package tn.enicarthage.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.User;

@Service
public interface IUserService  {
	public User authenticate(String login, String password);
	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUserByCin(String cin);
	public User getMemberById(String cin);
	List<User> getAllUsers();
	public void logOut(String cin);
	
	public void addNotification(String cin, int idNotif);
	
	public void deleteNotification(String cin, int idNotif);
	
	
}
