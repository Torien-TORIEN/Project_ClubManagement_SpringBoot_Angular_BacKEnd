package tn.enicarthage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Notification;
import tn.enicarthage.Entities.User;
import tn.enicarthage.Repositories.MemberRepository;
import tn.enicarthage.Repositories.NotificationRepository;
import tn.enicarthage.Repositories.UserRepository;

@Service 
public class UserService implements IUserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	NotificationRepository notificationRepository;

	@Override
	public User authenticate(String login, String password) {
	    User user = userRepository.findByEmailOrCIN(login);
	    if (user != null) {
	        if (user.getPassword().equals(password)) {
	            user.setIsActif(true);
	            userRepository.save(user);
	            return userRepository.findByEmailOrCIN(login);
	        } else {
	            System.out.println("MOT DE PASSE INCORRECT :");
	            return null;
	        }
	    } else {
	        System.out.println("Aucun Utilisateur trouvé");
	        return null;
	    }
	}


	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserByCin(String cin) {
		userRepository.deleteById(cin);
	}

	@Override
	public User getMemberById(String cin) {
		return memberRepository.findById(cin).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void logOut(String cin) {
		User user=userRepository.findById(cin).orElse(null);
		if(user!=null) {
			user.setIsActif(false);
			userRepository.save(user);
		}
		
	}

	@Override
	public void addNotification(String cin, int idNotif) {
		User user=userRepository.findByEmailOrCIN(cin);
		Notification notification=notificationRepository.findById(idNotif).orElse(null);
		if(user!=null && notification!=null) {
			if(user.getNotifications().equals(null)) {
				user.setNotifications();
			}
			user.getNotifications().add(notification);
			userRepository.save(user);	
		}	
	}


	@Override
	public void deleteNotification(String cin, int idNotif) {
		User user=userRepository.findByEmailOrCIN(cin);
		Notification notification=notificationRepository.findById(idNotif).orElse(null);
		if(user!=null && notification!=null) {
			if(user.getNotifications().remove(notification)) {
				userRepository.save(user);
			}
		}
	}

}
