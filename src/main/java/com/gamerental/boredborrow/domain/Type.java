package com.gamerental.boredborrow.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //Relational database table
public class Type {
	@Id //unique id column
	@GeneratedValue(strategy = GenerationType.AUTO) //generates unique PK id
	private long typeid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type") //oneToMany relationship declaration
	private List<Game> games;
	
	public Type() {} //empty constructor
	
	//Constructor
	public Type(String name) { //constructor only for name, id + games auto constructed by annotations
		super();
		this.name = name;
	}
	
	//Getters and setters
	public long getTypeid() {
		return typeid;
	}

	public void setTypeid(long typeid) {
		this.typeid = typeid;
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
