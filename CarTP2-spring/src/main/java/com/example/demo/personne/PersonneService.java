package com.example.demo.personne;

import java.util.ArrayList;
import java.util.List;

public interface PersonneService {

	public Iterable<Personne> getAllPersonnes();

	public void init();

	public void ajouterPersonne(String email, String mdp,String nom, String prenom);
	
	//public void ajouterAgenda(Long id, String name);

	public ArrayList<Personne> getByEmail(String email);
	
}
