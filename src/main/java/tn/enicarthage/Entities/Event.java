package tn.enicarthage.Entities;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCreation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Event {
	@Id
	@Column(name="EVENT_ID")
	String id;
	
	String title;
	
	@Column(name="EVENT_Status")
	String status;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	@Column(name = "EVENT_DATE")
	Date date;
	
	/*@Column(name="EVENT_HOUR")
	LocalTime hour;*/
	
	@Column(name="EVENT_DESCRIPTION")
	String description;
	
	String destination;
	
	@Column(name = "Duration_H")
	int duration;
	
	@OneToOne
	Salle salle;
	
	String location;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "event_id")
	Set<Material> materiels;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.DETACH)
	Set<Club> clubs;
	
	
	public void initializeMaterial() {
		this.materiels=new HashSet<>();
	}
	
	

}
