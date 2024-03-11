package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceImpl implements PersonneService{
	@Autowired
	
	private PersonneRepository repo;
	@Autowired
	private AgendaRepository agendaRepo;
	
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
	
	public void ajouterAgenda(Long userId, String name) {
		
		agendaRepo.save(new Agenda(userId,name));
	}
	
	public List<Agenda> getAgendaById(Long userId){
		return agendaRepo.findByUserId(userId);
	}
}
