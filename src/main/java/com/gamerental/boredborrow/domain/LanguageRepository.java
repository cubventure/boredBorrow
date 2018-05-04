package com.gamerental.boredborrow.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//enables CRUD (Create, Repeat, Update, Delete) functionality for the entity
public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	List<Language> findByName(String name);

}
