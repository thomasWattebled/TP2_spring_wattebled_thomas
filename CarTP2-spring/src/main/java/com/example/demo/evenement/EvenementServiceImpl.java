package com.example.demo.evenement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.personne.Personne;

@Service
public class EvenementServiceImpl implements EvenementService{
	
	@Autowired
	private EvenementRepository repo ;
	
	@Override
	public void ajouterEvenement(String libelle, String date, String h_deb, String h_fin,Long agendaId) {
		repo.save(new Evenement(date,h_deb,h_fin,libelle,agendaId));
		
	}

	@Override
	public List<Evenement> getEvenementById(Long agendaID) {
		System.out.println(repo);
		return repo.findByAgendaId(agendaID); 
	}

	@Override
	public void deletEvenement(Evenement evenement) {
		repo.delete(evenement);
		
	}

	@Override
	public Evenement findEvenementByLibelle(String libelle) {
		return repo.findByLibelle(libelle).get(0);
	}


}
