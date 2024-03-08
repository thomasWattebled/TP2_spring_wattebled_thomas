package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agenda {
	private Long id;
	
public Agenda() {
		
	}


@Id
@GeneratedValue
public Long getId() {
	return id;
}

public void setId(Long newId) {
	this.id= newId;
}
}
