package com.pokeTest.model;

import java.util.List;

public class EvolvesTo {
	
	private List<EvolvesTo> evolves_to;

	private Species species;

	public List<EvolvesTo> getEvolves_to() {
		return evolves_to;
	}

	public void setEvolves_to(List<EvolvesTo> evolves_to) {
		this.evolves_to = evolves_to;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	
}
