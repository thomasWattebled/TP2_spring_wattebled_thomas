package com.example.demo.evenement;

import java.util.ArrayList;
import java.util.Date;

import com.example.demo.agenda.Agenda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Evenement {
	private String date;
	private String h_deb;
	private String h_fin;
	private String libelle;
	private Long agendaId;
	private Long id; 
	
	public Evenement() { }
	
	public Evenement(String date, String h_deb, String h_fin,String libelle, Long agendaId) {
		this.date = date;
		this.h_deb = h_deb ;
		this.h_fin = h_fin ;
		this.libelle= libelle ;
		this.setAgendaId(agendaId);
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long newId) { this.id= newId;}
	
	public String getDate() {	return date; }

	public void setDate(String date) { this.date = date; }

	public String getH_deb() { return h_deb; }

	public void setH_deb(String h_deb) { this.h_deb = h_deb; }

	public String getH_fin() { return h_fin; }

	public void setH_fin(String h_fin) { this.h_fin = h_fin; }

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public long getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(long agendaId) {
		this.agendaId = agendaId;
	} 

}
