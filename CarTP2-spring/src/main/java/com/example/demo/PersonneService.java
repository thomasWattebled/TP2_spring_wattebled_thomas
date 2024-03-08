package com.example.demo;

import java.util.ArrayList;

public interface PersonneService {

	public Iterable<Personne> getAllPersonnes();

	public void init();

	public void ajouterPersonne(String email, String mdp,String nom, String prenom);

	public ArrayList<Personne> getByEmail(String email);
	
}
