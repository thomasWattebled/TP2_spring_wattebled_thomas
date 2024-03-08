package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceImpl implements PersonneService{
	@Autowired
	
	private PersonneRepository repo;
	
	@Override
	public void init() {
		repo.save(new Personne("a@yahoo.com","a" ,"Hugo", "Victor"));
	}

	@Override
	public Iterable<Personne> getAllPersonnes() {
		return repo.findAll();
	}
	
	public ArrayList<Personne> getByEmail(String email){
		return (ArrayList<Personne>) repo.findByEmail(email);
	}

	@Override
	public void ajouterPersonne(String email, String mdp, String nom, String prenom) {
		System.out.println("l'email est :"+email) ;
		repo.save(new Personne(email,mdp,nom,prenom));
		
	}
}
