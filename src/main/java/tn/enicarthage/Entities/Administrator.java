package tn.enicarthage.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("Administrateur")
@Entity
public class Administrator extends User{
	String profession;
	
	@ManyToMany(cascade = CascadeType.ALL)
	Set<Actuality> actualities;
	
	public Administrator(String CIN,String name, String firstname, String email, String password,Genre genre,String profession) {	
		super(CIN,name,firstname,email,password,genre);
		this.profession=profession;
		this.actualities=new HashSet<>();
	}

	
	
}
