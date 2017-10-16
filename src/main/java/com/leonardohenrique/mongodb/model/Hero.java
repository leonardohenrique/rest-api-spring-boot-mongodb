package com.leonardohenrique.mongodb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.leonardohenrique.mongodb.annotation.CascadeSave;

@Document(collection = "heroes")
public class Hero {

	@Id
	private String id;

	private String name;

	private List<String> powers = new ArrayList<String>();

	@DBRef
	@CascadeSave
	private List<Villain> enemies = new ArrayList<Villain>();

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPowers() {
		return powers;
	}

	public void setPowers(List<String> powers) {
		this.powers = powers;
	}

	public List<Villain> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Villain> enemies) {
		this.enemies = enemies;
	}

}
