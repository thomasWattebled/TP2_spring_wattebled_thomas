package com.example.demo.evenement;


import java.util.List;


public interface EvenementService {
	
	public void ajouterEvenement(String libelle, String date, String h_deb, String h_fin,Long agendaId);

	public List<Evenement> getEvenementById(Long agendaID);
	

	
	public Evenement findEvenementByLibelle(String libelle);

	void deletEvenement(Evenement evenement);
}
