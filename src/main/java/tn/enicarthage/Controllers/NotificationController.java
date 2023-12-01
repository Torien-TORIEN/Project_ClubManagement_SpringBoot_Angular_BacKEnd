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

import tn.enicarthage.Entities.Notification;
import tn.enicarthage.Services.INotificationService;

@RestController
public class NotificationController {
	@Autowired
	INotificationService notificationService;
	
	@GetMapping("/notifications/user/{cin}")
	@ResponseBody
	public List<Notification> getAllNotificationByUser(@PathVariable("cin") String cin){
		return notificationService.getAllNotificationsByUser(cin);
	}
	@GetMapping("/notifications")
	@ResponseBody
	public List<Notification> getAllNotifications(){
		return notificationService.getAllNotifications();
	}

	
	@PostMapping("/notifications")
	@ResponseBody
	public Notification addNotification(@RequestBody Notification notification) {
		return notificationService.addNotification(notification);
	}
	
	@PutMapping("/notifications/{id}")
	@ResponseBody
	public Notification  updateNotification(@PathVariable("id") int id,@RequestBody Notification notification) {
		notification.setId(id);
		return notificationService.updateNotification(notification);
	}
	
	@DeleteMapping("/notifications/{id}")
	@ResponseBody
	public void deleteNotification(@PathVariable("id") int id) {
		notificationService.deleteNotification(id);
	}
	
}
