package tn.enicarthage.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

//@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PACKAGE)
@ToString

@Entity
@Table(name="Club")
public class Club implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CLUB_ID")
	String id;
	
	@Column(name = "CLUB_NAME")
	String name;
	
	@Column(name="CLUB_LOGO")
	String logo;
	
	@Column(name = "CLUB_DESCRIPTION")
	String description;
	
	@Column(name = "DATE_CREATION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	@Temporal(TemporalType.DATE)
	Date createdAt;
	
	@Column(name = "CLUB_DOMAINE")
	Domaine domaine;
	
	@OneToOne(cascade = CascadeType.DETACH)
	Member president;
		
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "clubs")
	Set<Event> events;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "club")
	Set<Role> roles;
	
	
	@Transient
	int NbMembers;


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Domaine getDomaine() {
		return domaine;
	}

	@JsonIgnore
	public Member getPresident() {
		return president;
	}


	@JsonIgnore
	public Set<Event> getEvents() {
		return events;
	}
	
	@JsonIgnore
	public Set<Role> getRoles() {
		return roles;
	}


	public int getNbMembers() {
		return NbMembers;
	}


	public String getLogo() {
		return logo;
	}
	
	
	
	
}
