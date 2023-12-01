package tn.enicarthage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Entities.Notification;
import tn.enicarthage.Repositories.NotificationRepository;

@Service
public class NotificationService implements INotificationService{
	@Autowired
	NotificationRepository notificationRepository;

	@Override
	public Notification addNotification(Notification notification) {
		return notificationRepository.save(notification);
	}

	@Override
	public Notification updateNotification(Notification notification) {
		return notificationRepository.save(notification);
	}

	@Override
	public void deleteNotification(int id) {
		notificationRepository.deleteById(id);
	}

	@Override
	public Notification getNotificationById(int Idnotif){
		return notificationRepository.findById(Idnotif).orElse(null);
	}

	@Override
	public List<Notification> getAllNotificationsByUser(String cin) {
		return (List<Notification>) notificationRepository.findAll();
	}

	@Override
	public void sendNotificationToUser(Notification notification, String CIN) {
		
	}

	@Override
	public void sendNotificationToClubMembers(Notification notification, String Idclub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendNotificationToAllMembers(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notification> getAllNotifications() {
		return (List<Notification>) notificationRepository.findAll();
	}

}
