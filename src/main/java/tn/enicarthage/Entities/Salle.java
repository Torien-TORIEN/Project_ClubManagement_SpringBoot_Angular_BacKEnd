package tn.enicarthage.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString

//@DiscriminatorValue("Salle")

@Entity
@Table(name = "Salle")
public class Salle implements Serializable {
	
	
	
	@Id
	@Column(name = "ID")
	int id;
	
	@Column(name = "NUM")
	int number;
	
	@Column(name = "LOCATION")
	Locale location;
	
	
	@Column(name = "DESCRIPTION")
	String description;
}
