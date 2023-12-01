package tn.enicarthage.Services;

import java.util.List;

import tn.enicarthage.Entities.Notification;

public interface INotificationService {
	
	//CRUD Methodes 
	public Notification addNotification(Notification notification);
	public Notification updateNotification(Notification notification);
	public void deleteNotification(int id);
	public Notification getNotificationById(int Idnotif);
	
	public List<Notification> getAllNotificationsByUser(String cin);
	public List<Notification> getAllNotifications();
	
	//Autres
	public void sendNotificationToUser(Notification notification, String CIN);
	public void sendNotificationToClubMembers(Notification notification, String Idclub);
	public void sendNotificationToAllMembers(Notification notification);
	
}
