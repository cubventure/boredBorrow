package com.gamerental.boredborrow.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //Relational database table
public class Language {
	
	@Id //unique id column
	@GeneratedValue(strategy = GenerationType.AUTO) //generates unique PK id
	private long languageid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "language") //oneToMany relationship declaration
	private List<Game> games;
	
	public Language() {} //empty constructor

	//Constructor
	public Language(String name) { //constructor only for name, id + games auto constructed by annotations
		super();
		this.name = name;
	}

	//Getters and setters
	public long getLanguageid() {
		return languageid;
	}

	public void setLanguageid(long languageid) {
		this.languageid = languageid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
}
