package com.pokeTest.model;

public class PokemonAbility {
	
    private boolean isHidden;
    private int slot;
    private NamedApiResource ability;
    
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public NamedApiResource getAbility() {
		return ability;
	}
	public void setAbility(NamedApiResource ability) {
		this.ability = ability;
	}
	
    

}
