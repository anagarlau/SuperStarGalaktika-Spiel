package de.htwberlin.prog1.sose21.spaceadventure.model;

/**
*  Klasse zur Erstellung einer Kreatur (Teil der Klasse Planet)
*@author ana-maria garlau
*  
*/

public class Creature {
	
	private String name;
	private String typeOfCreature;
 
	
	/**
	*  Konstruktor nimmt 
	*@param String name: Name der Kreatur
	*@param String typeOfCreature: Kreaturentyp, zB "Orks"
	*/
		
	
	public Creature(String name, String typeOfCreature) {
		 
		this.name = name;
		this.typeOfCreature = typeOfCreature;
		 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfCreature() {
		return typeOfCreature;
	}
	public void setTypeOfCreature(String typeOfCreature) {
		this.typeOfCreature = typeOfCreature;
	}



	
	
}
