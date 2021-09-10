package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.UUID;

/**
*  Klasse zur Erstellung eines Planeten
*  @author ana-maria garlau
*  
*/

public class Planet {
	private String id = UUID.randomUUID().toString();
	private String name;
	private String description;
	private Creature creature;
	private String artefact;
	private Puzzle puzzle;
 
	
	/**
	*  Konstruktor nimmt
	*@param String name > Name des Planeten
	*@param String description > Beschreibung des Planeten
	*@param creature von Typ Creature > Bevoelkerung des Planeten
	*@param artefact String> Preis fuer ein geloestes Puzzle
	*@param puzzle von Typ Puzzle >  die challenge, die von Spieler via spaceShip
	* bestanden werden muss 
	*/
	public Planet(String name, String description, Creature creature, String artefact, Puzzle puzzle) {
	
		this.name = name;
		this.description = description;
		this.creature = creature;
		this.artefact = artefact;
		this.puzzle = puzzle;
	 
	}

	/**
	*attemptPuzzle praesentiert die challenge  
	*Anweisungen werden durch die Kreatur gegeben
	*  
	*/
	 
	public void attemptPuzzle(){
		System.out.println("Welcome to Planet " + this.name + "!");
		System.out.println(this.description);
		System.out.println("Hello, Traveler!");
 		System.out.println(" I am " + this.creature.getName() + ". I am part of the " + this.creature.getTypeOfCreature() + "s."  
 		+ "\n On behalf of my people I bring you the following puzzle: " + this.puzzle.getName());
 		System.out.println("\n The game is played as follows: " + this.puzzle.getDescription());
 		System.out.println("\n Should you be successful, you will receive " + this.artefact + " as a reward");
 		System.out.println("\n On behalf of the " + this.creature.getTypeOfCreature()+"s, I wish you the best of luck! ");
 	}

	/**
	*  takeArtefact
	*setzt das artefact Attribut auf null (wenn es nicht bereits null ist)
	*  
	*/
 	public void takeArtefact(){
 		if(this.artefact==null){
 			System.out.println("Ooops! Ein anderer Traveller war flinker! Sorry! ");
 
 		}else{
 			System.out.println("Du hast 1 x  " + this.artefact );
 			this.artefact = null;
 			 		 
 		}
 	}
 	
 	/**
	*  printPlanet druckt alle Informationen eines Planeten aus
	*
	*  
	*/
 	
 	public void printPlanet(){
 		System.out.println("Dieser Planet heisst " + this.name + "./t Was die Buecher ueber ihn sagen: " + this.description );
 		System.out.println("Population: " + this.creature.getTypeOfCreature() + ". Its Ambassador and your host is: " + this.creature.getName());
 	}
	



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Creature getCreature() {
		return creature;
	}


	public void setCreature(Creature creature) {
		this.creature = creature;
	}


	public String getArtefact() {
		return artefact;
	}


	public void setArtefact(String artefact) {
		this.artefact = artefact;
	}


	public Puzzle getPuzzle() {
		return puzzle;
	}


	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
//	public static void main(String[] args) {
//		Creature x = new Creature("Flame", "Ork");
//		System.out.println(x.getName());
//		Puzzle m = new Puzzle("tictactoe", "moo");
//		System.out.println(m.getName());
//		Planet y = new Planet("Meow", "bla", x, "suppe",m);
//		System.out.println(y.getArtefact());
//		y.printPlanet();
//		y.attemptPuzzle();
//		y.takeArtefact();
//		
//	}

	
}
