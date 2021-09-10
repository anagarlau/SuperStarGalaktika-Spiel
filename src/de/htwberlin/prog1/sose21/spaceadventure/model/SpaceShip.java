package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.UUID;
/**
 * Erstellt ein Raumschiff, SpaceShip, der Avatar des Spielers 
 * 
 * @author ana-maria garlau
 * 
 */

public class SpaceShip {
	private String id = UUID.randomUUID().toString();
	private String name = "";
	private String description ="";
	private int age;
	private int energy = 3;
	private int experience = 0;
	private boolean exists = true;
	private ArrayList <String> artefacts = new ArrayList <String>();
	
		/**
		 Konstruktor nimmt 
		 @param String name > name des Raumschiffes
		 @param String description > Beschreibung des Raumschiffes
		 @param int age > Alter des Raumschiffes
		 *
		 */
	
	
	public SpaceShip(String name, String description, int age) {
	
		this.name = name;
		this.description = description;
		this.age = age;
	}
	
	/** printArtefact
	 * druckt die vom Raumschiff bisher gewonnen artefacts
	 * 
	 * */
	
	public void printArtefacts(){
		
		if(this.artefacts.size() == 0){
			System.out.println("So weit hast du 0 artefacts gesammelt... \n An deiner Stelle wuerde ich mir mehr Muehe geben!");
		}else{
				System.out.println("Your artefacts so far: ");
			for(int i=0; i<this.artefacts.size(); i++){
			System.out.println("> " + this.artefacts.get(i));
		}
		}
		
	}
	
	/** printStatus
	 * druckt den aktuellen Zustand der Attribute energy int
	 * und exists boolean
	 * */
	
	public void printStatus(){
		System.out.println("Du hast " + this.energy + " energy points uebrig!");
		System.out.println("Dein Ship existiert noch t/f:" + this.exists);
	}
	
	/** addArtefact fuegt ein artefact Typ String in den ArrayList artefacts 
	 * des Raumschiffes hinzu
	 * @param artefact String
	 * 
	 * */
	
	public void addArtefact(String artefact){
		for(int i = 0; i<this.artefacts.size(); i++) {
			if(this.artefacts.get(i) == null){
//				this.artefacts.set(i, artefact);
			}
		}
		this.artefacts.add(artefact);
	}
	
	 
	
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getArtefacts() {
		return artefacts;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	
	
	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	public String getId() {
		return id;
	}
	
	/**
	 void Methode print
	 drueckt alle Attribute einer SpaceShip-Instanz
	 * */
	public void print() {
		System.out.println("Dieses Raumschiff heisst> " + "'" + this.name + "'"+ "\n Sein ID> " + this.id+
				"\n Beschreibung> " + this.description +
				"\n Alter> " + this.age + " Jahre alt" +
				". \n Zustand energy points> " + this.energy +
				"\n Erfahrung in points> " + this.experience + 
				"\n Existiert noch t/f?> " + this.exists);
	}
	
	/** decreaseEnergy dekrementiert das energy Attribut
	 * @param int nb > Dekrementierwert 
	 *  
	 * 
	 * */
	
	public void decreaseEnergy(int nb) {
		if(nb>= 0 ){
		this.energy -=nb;	
		}else{
			System.out.println("Schummeln ist keine feine Sache.");
		}
		
	}
	
	/** increaseEnergy inkrementiert das energy Attribut
	 * @param int nb > Inkrementierwert 
	 *  
	 * 
	 * */
	
	public void increaseExperience(int experience) {
		this.experience += experience;
	}
	
//	public static void main(String[] args) {
//		SpaceShip x = new SpaceShip("bla", "blabla", 13);
//		System.out.println(x.getId());
//		System.out.println(x.getName());
//		x.print();
//		x.decreaseEnergy(-2);
//		System.out.println(x.getEnergy());
//		x.addArtefact("CAT");
// 	System.out.println(x.getArtefacts().get(0));	
// 	}
}
