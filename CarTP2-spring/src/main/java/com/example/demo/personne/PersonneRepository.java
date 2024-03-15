package com.example.demo.personne;

import org.springframework.data.repository.CrudRepository;

public interface PersonneRepository extends CrudRepository<Personne,Long>
	{

	Iterable<Personne> findByEmail(String email);
} 