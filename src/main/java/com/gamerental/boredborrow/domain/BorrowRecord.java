package com.gamerental.boredborrow.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //annotation to represent a relational database table
public class BorrowRecord {
	@Id //annotation for unique id table column
	@GeneratedValue(strategy = GenerationType.AUTO) //generates unique PK for every new object in BorrowList Entity
	private long recordid; //long: 8byte data type assists in keeping the id unique even in extensive entity types
	private Boolean reserved, borrowed;
	private String due;
	
	//Links to other entities
		@ManyToOne
		@JsonIgnore
		@JoinColumn (name = "gameid")
		private Game game;
		
		@ManyToOne
		@JsonIgnore
		@JoinColumn (name = "userid")
		private User user;
	
	public BorrowRecord() {} //empty constructor
	
	// Constructor
	public BorrowRecord(Game game, User user, Boolean reserved, Boolean borrowed, String due) {
		super();
		this.game = game;
		this.user = user;
		this.reserved = reserved;
		this.borrowed = borrowed;
		this.due = due;
	}

	//Getters and Setters
	public long getRecordid() {
		return recordid;
	}

	public void setRecordid(long recordid) {
		this.recordid = recordid;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public Boolean getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Boolean borrowed) {
		this.borrowed = borrowed;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
