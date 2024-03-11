package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda,Long> {
	List<Agenda> findByUserId(Long UserId);
}
