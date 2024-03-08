package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agenda {
	private Long id;
	private String nom;
	private int UserId;
	
public Agenda() {
		
	}

public Agenda(String nom) {
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




}
