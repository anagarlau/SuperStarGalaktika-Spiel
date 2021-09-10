package de.htwberlin.prog1.sose2021.spaceadventure.app;
import de.htwberlin.prog1.sose21.spaceadventure.model.*;
import java.util.ArrayList;

import de.htwberlin.prog1.sose21.spaceadventure.model.Creature;
import de.htwberlin.prog1.sose21.spaceadventure.model.Planet;
import de.htwberlin.prog1.sose21.spaceadventure.model.Puzzle;
import de.htwberlin.prog1.sose21.spaceadventure.model.SpaceShip;

public class SpaceAdventureGame {
	/**
	* erzeugt Game-Instanzen in dem das eigentliche Spiel aufgerufen wird
	*@author ana-maria garlau
	*  
	*/
	
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private SpaceShip spaceShip;
 
	/**
	*  Konstruktor
	*@param SpaceShip Objekt
	* Default Erzeugung dreier Planeten in Attribut ArrayList <Planet>  planets
	*/
	
	public SpaceAdventureGame(SpaceShip spaceShip) {
		
		this.planets.add(
				new Planet("Valerian", "Hier leben sanfte, vegetarische Orks, die in Harmonie mit der freundlichen Natur leben. ", new Creature("Martha", "Ork"), "Kohlrabi", new TicTacToe()));
		this.planets.add(
				new Planet("9910", "Dieser Planet ist eine Oase mitten in der Galaxy, wo alle Wesen Zahlen als Name tragen.", new Creature("01", "0"), "0101", new Reverse()));
		this.planets.add(
				new Planet("Mimosa", "Hier leben nur selbstgiessende Blumen", new Creature("Tulipa", "Tulpen"), "2Spargelstangen", new CountStrings()));
		this.spaceShip = spaceShip;
	}

	/**
	* runPlanet prozessiert die jeweiligen Puzzles eines gewaehlten Planeten 
	* Je nach Spiel Verlauf und Endergebnis werden die Attribute des Raumschiffs und des Puzzles gesettet
	*@param int nb setzt den Index des jeweiligen Planeten aus dem Attribut planets ArrayList
	*  
	*/
	public void runPlanet(int nb){
		
		 	String artefact =this.planets.get(nb).getArtefact();
			if(artefact == null){
				System.out.println("Du kannst gerne spielen, aber das Artefakt hast du bereits in der Tasche");
			}
			System.out.println("=======================================");
			System.out.println("Zunaechst hast du 5 Sek um die Aufgabe zu lesen");
			System.out.println("Warte bitte auf das Go-Signal, denn die Entwicklerin dieses Spiels\n kann nicht so gut mit Threads arbeiten.\n Somit zaehlt jede voreilige Eingabe als Antwort!!");
			System.out.println("=======================================");
			this.planets.get(nb).attemptPuzzle();
			try {
				
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				 
				e.printStackTrace();
			}
			System.out.println("=======================================");
			System.out.println("GOOOOOO!!!!!");
			System.out.println("=======================================");
			this.planets.get(nb).getPuzzle().attemptPuzzle();;
 			//System.out.println("hello from game " + this.planets.get(nb).getPuzzle().isPuzzleSolved());
			if(this.planets.get(nb).getPuzzle().isPuzzleSolved()){
				if(artefact !=null){
					System.out.println("Congrats! Du hast das folgende Artefakt >" + artefact + "< vom Planeten >" + this.planets.get(nb).getName() + "< gewonnen!");
					this.spaceShip.addArtefact(artefact);
					this.planets.get(nb).setArtefact(null);
					
				}else {
					System.out.println("Such dir ein Spiel aus wo du ein Artefakt noch holen kannst");
				}
		
				this.spaceShip.printStatus();
				this.spaceShip.printArtefacts();
			}else if(this.planets.get(nb).getPuzzle().getName().equals("TicTacToe") && !this.planets.get(nb).getPuzzle().isPuzzleSolved() && !this.planets.get(nb).getPuzzle().isDidComputerWin()){
				System.out.println("Das war unentschieden!");
				this.spaceShip.printStatus();
				this.spaceShip.printArtefacts();
			}else{
				if(artefact != null){
				
				 
				this.spaceShip.decreaseEnergy(1);
				if(this.spaceShip.getEnergy()==0){
					System.out.println("BOOM");
					this.spaceShip.setExists(false);
//					this.spaceShip = null;
				}else {
					System.out.println(" ====================");
					this.spaceShip.printStatus();
					this.spaceShip.printArtefacts();
				}
				}else{
					System.out.println("Du hast verloren aber du hast das Artefakt bereits so no harm done!");
				}
				this.planets.get(nb).getPuzzle().resetPuzzleState();
			
			} 
//			System.out.println(this.spaceShip.getArtefacts());
	}
	
	/**
	* isGameOver
	*@return true falls das spaceShip alle Artefakte geholt hat oder 0 energyPoints hat
	*  
	*/
	
	public boolean isGameOver(){
		if(this.spaceShip.getArtefacts().size() == 3){
			System.out.println("Du hast gewonnen! Yaaaaaay.... ");
			return true;
		}else if(this.spaceShip.getEnergy() == 0){
			System.out.println("Oops, dein Ship ist gerade explodiert und du hast verloren.");
			System.out.println("Dein Ship, "+ this.spaceShip.getName() + ", ist nun Schrott! RIP");
			this.spaceShip.setExists(false);
			
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public void setSpaceShip(SpaceShip spaceShip) {
		this.spaceShip = spaceShip;
	}

// 	public static void main(String[] args) {
// 
// 	SpaceAdventureGame x = new SpaceAdventureGame(new SpaceShip("bla",  "blabla", 2));
//  	x.runPlanet(2);
//  
// 	
// 
// }
	
	
}
