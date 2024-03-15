package com.example.demo.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaServiceImpl implements AgendaService{
	@Autowired
	private AgendaRepository agendaRepo;
	public void ajouterAgenda(Long userId, String name) {
		
		agendaRepo.save(new Agenda(userId,name));
	}
	
	public List<Agenda> getAgendaById(Long userId){
		return agendaRepo.findByUserId(userId); 
	}

	@Override
	public Agenda getAgendaByName(String nom, Long id) {
		return (Agenda) agendaRepo.findByNom(nom); 
		
	}
}
