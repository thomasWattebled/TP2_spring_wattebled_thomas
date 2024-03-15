package com.example.demo.agenda;

import java.util.List;

public interface AgendaService {
	public List<Agenda> getAgendaById(Long userId);
	
	public void ajouterAgenda(Long id, String name);
	
	public Agenda getAgendaByName(String nom, Long id);
}
