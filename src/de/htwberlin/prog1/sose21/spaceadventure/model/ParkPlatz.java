package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkPlatz {
	/**
	 * Klasse speichert die von User erstellten Raumschiffe und bietet 2 default
	 * Raumschiffe an
	 * 
	 * @author ana-maria garlau
	 */
	private ArrayList<SpaceShip> spaceShipList;

	/**
	 * Konstruktor initialisiert ArrayList <SpaceShip> spaceShipList und fuegt 2
	 * default spaceShip-Objekte hinzu
	 * 
	 */

	public ParkPlatz() {

		this.spaceShipList = new ArrayList<SpaceShip>();
		this.spaceShipList
				.add(new SpaceShip("Fatty", "Alteingessene Maschine, hatte eine Nebenrolle in Star Wars", 30));
		this.spaceShipList.add(new SpaceShip("Miranda", "Junges, wuetiges SpaceShip fuer mutige Reisende ", 3));
	}

	/**
	 * printShips druckt die Daten aller verfuegbaren SpaceShip Objekte aus
	 *
	 */
	public void printShips() {
		if (this.spaceShipList.size() == 0) {
			System.out.println("Es stehen keine Raumschiffe zur Verfuegung");
		} else {
			for (SpaceShip y : this.spaceShipList) {
				if (y != null)
					y.print();
			}
		}

	}

	/**
	 * addSpaceShip speichert ein Raumschiff in Attribut spaceShipList
	 * 
	 * @param spaceShip Typ SpaceShip
	 * 
	 */

	public void addSpaceShip(SpaceShip spaceShip) {
		for (int i = 0; i < this.spaceShipList.size(); i++) {
			if (this.spaceShipList.get(i) == null) {
				this.spaceShipList.set(i, spaceShip);
			}

		}
		this.spaceShipList.add(spaceShip);
	}

	/**
	 * addSpaceShip loescht ein Raumschiff aus Attribut spaceShipList
	 * 
	 * @param spaceShip Typ SpaceShip
	 * 
	 */
	public void removeSpaceShip(SpaceShip spaceShip) {
		int index = this.spaceShipList.indexOf(spaceShip);
		if (index < this.spaceShipList.size() && index >= 0) {
			this.spaceShipList.remove(index);
		}

	}

	public ArrayList<SpaceShip> getSpaceShipList() {
		return spaceShipList;
	}

}
