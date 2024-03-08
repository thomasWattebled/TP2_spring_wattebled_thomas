package com.example.demo;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Personne {
	private String email;
	private String mdp;
	private String nom;
	private String prenom;
	private Long id;
	private ArrayList<Agenda> agendas;
	public Personne() {
		
	}
	
	public Personne(String email, String mdp,String nom, String prenom) {
		this.email = email;
		this.mdp =mdp;
		this.nom = nom;
		this.prenom=prenom;
		agendas = new ArrayList<Agenda>();
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long newId) {
		this.id= newId;
	}
	
	
	public String getNom() {return this.nom;}
	
	public String getPrenom() {	return this.prenom;}
	
	public String getEmail() { return this.email ;}
	
	public String getMdp() { return this.mdp ;}
	
	public ArrayList<Agenda> getAgenda()  { return this.agendas ;}
	
	public void setNom(String newnom) { this.nom=newnom; }
	
	public void setPrenom(String newPrenom) { this.nom=newPrenom; }
	
	public void setEmail(String newEmail) { this.email = newEmail ;}
	
	public void setMdp(String newMdp) { this.mdp=newMdp ;}

	public void setAgenda(ArrayList<Agenda> newAgendas) {this.agendas= newAgendas;} 



}





