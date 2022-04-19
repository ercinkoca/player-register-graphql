package com.producter.player.registration.model;

import java.io.Serializable;

import com.producter.player.registration.enums.Position;

public class PlayerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6456704035574778213L;
	
	private String name;
	private String surname;
	private Position position;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
}
