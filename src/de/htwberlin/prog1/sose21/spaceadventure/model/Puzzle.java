package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.Scanner;

/**
 * Erstellung von Puzzles - Superklasse fuer die indiv. Puzzles
 * 
 * @author ana-maria garlau
 * 
 */
public class Puzzle {
	private String name;
	private String description;
	private boolean puzzleSolved = false;
	private boolean didComputerWin = false;
	private String artefact;
	protected Scanner scanner = new Scanner(System.in);

	/**
	 * Konstruktor nimmt
	 * 
	 * @param name        String > name der Challenge
	 * @param description String > Beschreibung der Challenge
	 * @param artefact    String > Gegenstand den man durch die Loesung eines
	 *                    Puzzles gewinnen kann
	 */

	public Puzzle(String name, String description, String artefact) {

		this.name = name;
		this.description = description;
		this.artefact = artefact;
	}

	/**
	* resetPuzzleState setzt boolean Attribute puzzleSolved 
	*und didComputerWin zurueck
	*  
	*/
	public void resetPuzzleState() {
		this.puzzleSolved = false;
		this.didComputerWin = false;
	}

	/**
	*  attemptPuzzle zur Ausfuehrung eines Puzzles
	*wird in Subklassen ueberschrieben
	*  
	*/
	public void attemptPuzzle() {
		System.out.println("no puzzle here");
	}

	public boolean isDidComputerWin() {
		return didComputerWin;
	}

	public void setDidComputerWin(boolean didComputerWin) {
		this.didComputerWin = didComputerWin;
	}

	public String getArtefact() {
		return artefact;
	}

	public void setArtefact(String artefact) {
		this.artefact = artefact;
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

	public boolean isPuzzleSolved() {
		return puzzleSolved;
	}

	public void setPuzzleSolved(boolean puzzleSolved) {
		this.puzzleSolved = puzzleSolved;
	}

}
