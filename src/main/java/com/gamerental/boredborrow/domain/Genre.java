package com.gamerental.boredborrow.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //Relational database table
public class Genre {
	
	@Id //unique id column
	@GeneratedValue(strategy = GenerationType.AUTO) //generates unique PK id
	private long genreid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre") //oneToMany relationship declaration
	private List<Game> games;
	
	public Genre() {} //empty constructor
	
	//Constructor
	public Genre(String name) { //constructor only for name, id + games auto constructed by annotations
		super();
		this.name = name;
	}

	//Getters and setters
	public long getGenreid() {
		return genreid;
	}

	public void setGenreid(long genreid) {
		this.genreid = genreid;
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
