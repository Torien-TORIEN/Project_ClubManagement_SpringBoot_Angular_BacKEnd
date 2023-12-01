package tn.enicarthage.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

//@Entity
@Table(name="Responsable_Club")
@DiscriminatorValue("Utilisateur")
public class RespClub extends User{
	@Embedded
	Classe classe;
	
	
	Date startedAt;

	
}
