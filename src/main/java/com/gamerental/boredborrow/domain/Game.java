package com.gamerental.boredborrow.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //annotation to represent a relational database table
public class Game {
	@Id //annotation for unique id table column
	@GeneratedValue(strategy = GenerationType.AUTO) //generates unique PK for every new object in Game Entity
	private long gameid; //long: 8byte data type assists in keeping the id unique even in extensive entity types
	private String name, img;
	private int minPlayers, maxPlayers;
	
	
	
	//Links to other entities
		@ManyToOne
		@JsonIgnore //annotation to prevent endless rest loop of linked one-to-many entity relationship
		@JoinColumn(name = "typeid")
		private Type type;
		
		@ManyToOne
		@JsonIgnore //annotation to prevent endless rest loop of linked one-to-many entity relationship
		@JoinColumn(name = "genreid")
		private Genre genre;
		
		@ManyToOne
		@JsonIgnore //annotation to prevent endless rest loop of linked one-to-many entity relationship
		@JoinColumn(name = "languageid")
		private Language language;
		
		@ManyToOne
		@JsonIgnore //annotation to prevent endless rest loop of linked one-to-many entity relationship
		@JoinColumn(name = "reserveid")
		private User reservedBy;
		
		@ManyToOne
		@JsonIgnore //annotation to prevent endless rest loop of linked one-to-many entity relationship
		@JoinColumn(name = "borrowid")
		private User borrowedBy;
	
	public Game() {} //empty constructor
	
	//Constructor
	public Game(String name, String img, Genre genre, Language language, int minPlayers, int maxPlayers, Type type) {
		super();
		this.img = img;
		this.name = name;
		this.genre = genre;
		this.language = language;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.type = type;
	}
	
	
	
	public Game(long gameid, String name, String img, Genre genre, Language language, int minPlayers, int maxPlayers,
			Type type, User reservedBy, User borrowedBy) {
		super();
		this.gameid = gameid;
		this.name = name;
		this.img = img;
		this.genre = genre;
		this.language = language;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.type = type;
		this.reservedBy = reservedBy;
		this.borrowedBy = borrowedBy;
	}

//	public Game(String name, String img, Genre genre, Language language, int minPlayers, int maxPlayers, Type type, User reservedBy, User borrowedBy) {
//		super();
//		this.img = img;
//		this.name = name;
//		this.genre = genre;
//		this.language = language;
//		this.minPlayers = minPlayers;
//		this.maxPlayers = maxPlayers;
//		this.type = type;
//		this.reservedBy = reservedBy;
//		this.borrowedBy = borrowedBy;
//	}
	
	//Getters and Setters
	
//	public void setReservedBy(User reservedBy) {
//		this.reservedBy = reservedBy;
//	}
//
//	public User getBorrowedBy() {
//		return borrowedBy;
//	}
//
//	public void setBorrowedBy(User borrowedBy) {
//		this.borrowedBy = borrowedBy;
//	}	
//	
//	public User getReservedBy() {
//		return reservedBy;
//	}

	public User getReservedBy() {
		return reservedBy;
	}

	public void setReservedBy(User reservedBy) {
		this.reservedBy = reservedBy;
	}

	public User getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	
	
	public long getId() {
		return gameid;
	}

	public void setId(long id) {
		this.gameid = id;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}	

}
