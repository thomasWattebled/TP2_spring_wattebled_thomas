package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PersonneRepository extends CrudRepository<Personne,Long>
	{

	Iterable<Personne> findByEmail(String email);
} 