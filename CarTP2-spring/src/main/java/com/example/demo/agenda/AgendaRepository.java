package com.example.demo.agenda;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda,Long> {
	List<Agenda> findByUserId(Long UserId);

	Object findByNom(String nom); 
}
