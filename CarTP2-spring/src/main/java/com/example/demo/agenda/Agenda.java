package com.example.demo.agenda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agenda {
	private Long id;
	private String nom;
	private Long UserId;
	
public Agenda() {
		
	}

public Agenda(long UserId,String nom) {
	this.UserId= UserId;
	this.nom=nom;
}

@Id
@GeneratedValue
public Long getId() {
	return id;
}

public void setId(Long newId) {
	this.id= newId;
}

public String getNom() {
	return this.nom;
}

public void setNom(String nom) {
	this.nom=nom ;
}

public Long getUserId() {
	return this.UserId;
}

public void setUserId(Long UserId) {
	this.UserId =UserId;
}



}
