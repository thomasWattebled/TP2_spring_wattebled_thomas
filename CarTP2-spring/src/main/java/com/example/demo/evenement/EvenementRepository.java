package com.example.demo.evenement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.agenda.Agenda;


public interface EvenementRepository extends CrudRepository<Evenement,Long> {
	//List<Agenda> findById(Long id);

	List<Evenement> findByAgendaId(Long agendaID);
	
	List<Evenement> findByLibelle(String lebelle);
}