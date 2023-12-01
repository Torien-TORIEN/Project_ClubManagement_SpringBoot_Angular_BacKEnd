package tn.enicarthage.Entities;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PROTECTED)

//Mapper par classe non abstraite
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Dtype" ,discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Utilisateur")

//@MappedSuperclass  //Ne pas céer la table pour les classes abstraites
@Entity
public abstract class User {
	@Id
	String CIN;
	
	@Column(nullable = false)
	String name;
	
	String firstname;
	
	@Column(nullable = false)
	String email;
	
	@Column(nullable = false)
	String password;
	
	@Column(name = "GENRE",nullable = false)
	Genre sexe;
	
	boolean isActif;
	
	@ManyToMany(cascade = CascadeType.ALL)
	Set<Notification> notifications;
	
	public void setCIN(String CIN) {
		this.CIN=CIN;
	}
	
	public void setSexe(Genre sex) {
		this.sexe=sex;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setIsActif(boolean actif) {
		this.isActif=actif;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setEmail(String email) {
		String regex="^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches())
			this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNotifications() {
		this.notifications=new HashSet<>();
	}

	public User(String CIN,String name, String firstname, String email, String password,Genre genre) {		super();
		this.CIN=CIN;
		this.name = name;
		this.firstname = firstname;
		this.setPassword(password);
		this.setEmail(email);
		this.isActif=false;
		this.sexe=genre;
	}
	
	
	
	
}
