package com.pokeTest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
	
    private int id;
    private String name;
    private int height;
    private  boolean isDefault;
    private int weight;
    private List<PokemonAbility> abilities;
    private PokemonForm image;
    private List<PokemonType> types;
    private List<String> evolutions;
    private String description;
    private String message;
    
    
    
	public Pokemon(String message) {
		this.message = message;
	}
	
	public Pokemon() {
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getEvolutions() {
		return evolutions;
	}
	public void setEvolutions(List<String> evolutions) {
		this.evolutions = evolutions;
	}
	public PokemonForm getImage() {
		return image;
	}
	public void setImage(PokemonForm image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<PokemonAbility> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}
	public List<PokemonType> getTypes() {
		return types;
	}
	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}

    
    
    
}
