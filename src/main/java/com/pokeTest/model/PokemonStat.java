package com.pokeTest.model;

public class PokemonStat {
	
    private NamedApiResource stat;
    private int effort;
    private int baseStat;
    
	public NamedApiResource getStat() {
		return stat;
	}
	public void setStat(NamedApiResource stat) {
		this.stat = stat;
	}
	public int getEffort() {
		return effort;
	}
	public void setEffort(int effort) {
		this.effort = effort;
	}
	public int getBaseStat() {
		return baseStat;
	}
	public void setBaseStat(int baseStat) {
		this.baseStat = baseStat;
	}
    
    

}
