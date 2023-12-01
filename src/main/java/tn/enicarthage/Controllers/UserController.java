package tn.enicarthage.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Entities.Genre;
import tn.enicarthage.Entities.Member;
import tn.enicarthage.Entities.User;
import tn.enicarthage.Services.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService userService;
	
	@GetMapping("/users/login/{login}/{pwd}")
	@ResponseBody
	public User login(@PathVariable("login") String login,@PathVariable("pwd") String pwd) {
		return userService.authenticate(login, pwd);
	}
	
	@PostMapping("/users/logout/{cin}")
	@ResponseBody
	public void logout(@PathVariable("cin") String cin) {
		userService.logOut(cin);
	}
	
	@PostMapping("/users/notifications/add/{cin}/{idnotif}")
	@ResponseBody
	public void addNotification(@PathVariable("cin") String cin,@PathVariable("idnotif") int idnotif) {
		userService.addNotification(cin, idnotif);
	}
	
	@DeleteMapping("/users/notifications/delete/{cin}/{idnotif}")
	@ResponseBody
	public void deleteNotification(@PathVariable("cin") String cin,@PathVariable("idnotif") int idnotif) {
		userService.deleteNotification(cin, idnotif);
	}
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getAllUsers() {
		/*User user =new Member();
		user.setEmail("toto@gmail.com");user.setName("Ali");user.setFirstname("Ahmed");
		user.setPassword("123");user.setCIN("12456378");user.setSexe(Genre.Masculin);
		userService.addUser(user);*/
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/member/{cin}")
	@ResponseBody
	public User getUserByCin(@PathVariable("cin") String cin) {
		return userService.getMemberById(cin);
	}
	
	@PostMapping("/users")
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/users/{cin}")
	@ResponseBody
	public void deleteUser(@PathVariable("cin") String cin) {
		userService.deleteUserByCin(cin);
	}

}
