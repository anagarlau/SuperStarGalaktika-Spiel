package de.htwberlin.prog1.sose2021.spaceadventure.app;

import de.htwberlin.prog1.sose21.spaceadventure.model.Planet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import de.htwberlin.prog1.sose21.spaceadventure.model.ParkPlatz;
import de.htwberlin.prog1.sose21.spaceadventure.model.SpaceShip;

public class SpaceAdventureApp {
	/**
	 * SuperStarGalaktika 4997 Spiel: ein Text-Adventure Game in Java
	 * 
	 * @author ana-maria garlau
	 * @version 1.0
	 */

	private static SpaceAdventureGame spaceAdventureGame;
	private static Scanner scanner = new Scanner(System.in);
	private static ParkPlatz parkPlatz = new ParkPlatz();
	private static SpaceShip spaceShip;

	/**
	 * Hauptprogramm.
	 * 
	 * @param args Kommandozeilenparameter
	 *
	 */
	public static void main(String[] args) {

		while (true) {
			//
			showMenu();
			String choice = readUserInput().toUpperCase();

			handle(choice);
			System.out.println("====================");
		}

	}

	/**
	 * Nimmt Input von User an
	 * 
	 * @return String choiceInternal: der Input von User
	 */

	private static String readUserInput() {
		System.out.print("\nWas willst Du tun? Wähle einen Buchstaben:\t");
		String choiceInternal = scanner.nextLine();
		return choiceInternal;
	}

	/**
	 * Je nach User Input werden hier verschiedene Methoden aufgerufen
	 * 
	 * @param String choice: User-Input
	 * 
	 */
	private static void handle(String choice) {
		switch (choice) {
		case "R":
			createSpaceShip();
			break;
		case "W":
			if (SpaceAdventureApp.getSpaceShip() == null) {
				System.out.println(
						"Ohne Raumschiff koennen Sie nicht fliegen. Bitte waehlen Sie ein Schiff oder erstellen Sie ihr eigenes!");
			} else {
				SpaceAdventureApp.setSpaceAdventureGame(new SpaceAdventureGame(SpaceAdventureApp.getSpaceShip()));
				System.out.println(SpaceAdventureApp.getSpaceAdventureGame().getSpaceShip().getName());

//				showAdventureMenu();
				runAdventureMenu();

			}

			break;
		case "B":
			System.out.println("Hoffentlich hattest du Spaß! Buh Bye!✌");
			System.exit(0);
			break;
		case "A":
			SpaceAdventureApp.getParkPlatz().printShips();
			break;
		case "S":
			// System.out.println("Dein Schiff ist OK");
			addShip(SpaceAdventureApp.getSpaceShip());
//			SpaceAdventureApp.getParkPlatz().printShips();
			break;
		case "L":
			removeShip();
//			SpaceAdventureApp.getParkPlatz().printShips();
//			System.out.println(SpaceAdventureApp.getSpaceShip().getName());

			break;
		case "C":
			chooseShip();
			break;
		default: {
			System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
			// showMenu();

		}
			break;

		}
	}

	/**
	 * chooseShip Bietet die Moeglichkeit ein Shiff auszuwaehlen der ShipArray aus
	 * Klasse Parkplatz wird durchsucht User gibt den Namen des Shiffs aus der Liste
	 * an Bei korrektem Input: Das statische Attribut spaceShip wird gesetzt Die
	 * UserEingabe wird wiederholt bis ein Schiff gewaehlt wird
	 */

	private static void chooseShip() {

		int arraySize = SpaceAdventureApp.getParkPlatz().getSpaceShipList().size();
		if (arraySize == 0) {
			System.out.println("Es gibt keine Schiffe mehr! Bastele dein eigenes!");

		}
		if (arraySize > 0) {
			System.out.println("Folgende Ships stehen dir zur Verfuegung");
			for (int i = 0; i < SpaceAdventureApp.getParkPlatz().getSpaceShipList().size(); i++) {
				SpaceShip ship = SpaceAdventureApp.getParkPlatz().getSpaceShipList().get(i);
				ship.print();
			}

			System.out.println("Moechtest du mit der Auswahl fortfahren?  ");
			System.out.println("Gib 'y' ein, um zu bestaetigen oder eine beliebige Taste um abzubrechen");
			String bestaetigung = scanner.nextLine();
			if (bestaetigung.equalsIgnoreCase("y")) {
				System.out.println("Supi! Dann gib einen Namen ein!");
				SpaceShip spaceShip = null;
				String shipName = " ";
				while (spaceShip == null) {
					shipName = scanner.nextLine();

					for (SpaceShip x : SpaceAdventureApp.getParkPlatz().getSpaceShipList()) {
						if (x.getName().equalsIgnoreCase(shipName)) {
							spaceShip = x;
							break;
						}

					}
					if (spaceShip == null) {
						System.out.println("Du hast dich vertippt. Probiere es nochmal");
					} else {
						SpaceAdventureApp.setSpaceShip(spaceShip);
						System.out.println("Das Ship " + spaceShip.getName() + " ist startbereit!");
					}
				}

				// System.out.println(shipName);
			} else {
				System.out.println("Ok... Dann halt doch nicht...");
			}

		}

	}

	/**
	 * removeShip nachdem der User ein Shiff ausgewaehlt hat kann er es loeschen das
	 * Ship wird im statischen Attribut spaceShip auf null gesetzt falls vorhanden
	 * und vom Spieler bestaetigt, Shiff auch aus dem spaceShipArray in Parkplatz
	 * geloescht
	 */

	private static void removeShip() {

		if (SpaceAdventureApp.getSpaceShip() != null) {

			System.out.println("Dein Ship wurde geloescht!");

			System.out.println("Moechtest du es auch aus der Garage entfernen?  ");
			System.out.println("Gib 'y' ein, um zu bestaetigen oder eine beliebige Taste um abzubrechen");
			String bestaetigung = scanner.nextLine();
			if (bestaetigung.equals("y")) {
				boolean istDa = false;
				for (int i = 0; i < SpaceAdventureApp.getParkPlatz().getSpaceShipList().size(); i++) {
					if (SpaceAdventureApp.getParkPlatz().getSpaceShipList().get(i)
							.equals(SpaceAdventureApp.getSpaceShip())) {
						SpaceAdventureApp.getParkPlatz().removeSpaceShip(spaceShip);
						istDa = true;
						System.out.println("Dein Schiff wurde aus der Garage entfernt!");
					}

				}
				if (!istDa) {
					System.out.println("Dein Ship war eigentlich gar nicht da.");
				}

				SpaceAdventureApp.setSpaceShip(null);
			} else {
				System.out.println("Ok... Dann doch nicht");
				SpaceAdventureApp.setSpaceShip(null);
			}

		} else {
			System.out.println("Du hast kein SpaceShip ausgewaehlt");

		}

	}

	/**
	 * addShip fuegt ein Raumschiff in den ArrayList von Spaceships in parkPlatz
	 * 
	 * @param spaceShip
	 * 
	 */

	private static void addShip(SpaceShip spaceShip) {
		if (SpaceAdventureApp.getSpaceShip() != null) {
			boolean istDa = false;
			for (int i = 0; i < SpaceAdventureApp.getParkPlatz().getSpaceShipList().size(); i++) {
				if (SpaceAdventureApp.getParkPlatz().getSpaceShipList().get(i).equals(spaceShip)) {
					System.out.println("Dieses Ship ist bereits in der Garage");
					istDa = true;
					break;
				}

			}
			if (!istDa) {
				SpaceAdventureApp.getParkPlatz().addSpaceShip(spaceShip);
				System.out.println("Dein SpaceShip steht nun in der Garage!");
			}
		} else {
			System.out.println("Du hast kein Ship ausgewaehlt");
		}

	}

	/**
	 * showMenu zeigt alle Aktivitaeten die im Hauptmenue des Spiels moeglich sind
	 *
	 * 
	 */

	private static void showMenu() {

		String menuItems[] = { "", "R\t <R>aumschiff erstellen", "C\t Raums<c>hiff auswählen",
				"A\t Daten aller Raumschiffe <a>usgeben", "S\t Raumschiff in der Garage <s>peichern, um damit wiederspielen zu koennen",
				"L\t Raumschiff <l>öschen", "W\t <W>eltraumabenteuer beginnen", "B\t <B>eenden" };

		System.out.println("\n----------- Space Adventure 1.0 -----------\n");
		System.out.println("\nWillkommen zum SuperStarGalaktika 4997 Spiel ...\n");
		for (int i = 1; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}

	}

	/**
	 * createSpaceShip erzeugt ein Objekt Typ SpaceShip mit Input von User
	 * 
	 * 
	 */

	private static void createSpaceShip() {
		System.out.println("\nHi! Du moechtest dein eigenes Schip herstellen.");
		System.out.println("Dieses Ship wird fuer dein Game automatisch gespeichert.");
		System.out.println(
				"Falls du doch ein premade Ship haben willst, kannst du das von dir\n erstellte Ship vor dem Spiel noch ersetzen.");
		System.out.println("Moechtest du fortfahren?  ");
		System.out.println("Gib 'y' ein, um zu bestaetigen oder eine beliebige Taste um abzubrechen");
		String bestaetigung = scanner.nextLine().toLowerCase();
		if (bestaetigung.equals("y")) {
			System.out.println("\nGib deinem Ship einen Namen!");
			String name = scanner.next();
			name += scanner.nextLine();
			System.out.println(name);

			boolean istKorrekt = false;
			int age = -1;
			while (!istKorrekt) {
				System.out.println("\nWie alt ist dein Schiff");
				try {
					age = scanner.nextInt();
					//System.out.println(age);
					if (age < 0) {
						System.out.println(age + " jahre alt? Ich bitte dich...");
					} else {
						istKorrekt = true;
						System.out.println("\t Alter deines Ships: " + age);
					}
				} catch (InputMismatchException e) {
					System.out.println("\tDas ist kein gueltiges Alter");
					scanner.nextLine();
				}

			}

			System.out.println("\nWie tickt dein Schiff? Erzaehl mal!");
			String description = scanner.next();
			description += scanner.nextLine();
			if (age >= 0 || name == null || description == null) {
				SpaceShip yourSpaceShip = new SpaceShip(name, description, age);
				yourSpaceShip.print();
				System.out.println("PERFEKTO! Nun kannst du ein Spiel starten!");
				SpaceAdventureApp.setSpaceShip(yourSpaceShip);

			} else {
				System.out.println("Something went wrong");

			}
		} else {
			System.out.println("Ok...Dann doch nicht...");
		}

	}

	/**
	 * runAdventureMenu steuert die Gameloop fuer die Instanz der Klasse
	 * SpaceAdventureGame durch Userinput anhand von boolean Variablen wird hier die
	 * Sieg-und-Niederlage Logik umgesetzt
	 * 
	 */

	public static void runAdventureMenu() {
		String choice = "";
		System.out.println(
				"\nDein Raumschiff ist abgehoben. Du schaust auf Deine Karte und findest die folgenden Planeten:\n");
		boolean isGameOver = spaceAdventureGame.isGameOver();
		do {
			showAdventureMenu();
			choice = readUserInput().toUpperCase();
			handleAdventureChoice(choice);
			isGameOver = spaceAdventureGame.isGameOver();
			if (isGameOver) {
				System.out.println("Das Spiel ist hiermit beendet!");
//				System.out.println(spaceShip.getArtefacts());
				break;
			}
		} while (!choice.equals("X") && !isGameOver);
		if (spaceShip.getArtefacts().size() == 3) {
			System.out.println("Wow, du hast gewonnen. ");
			System.out.println("Falls du dein Ship am Anfang gespeichert hast, kannst du es wiederverwenden");
			spaceShip.increaseExperience(1);
			spaceShip.printStatus();
			SpaceAdventureApp.setSpaceShip(null);
			SpaceAdventureApp.setSpaceAdventureGame(null);

		} else if (spaceShip.getEnergy() == 0) {
			SpaceAdventureApp.getParkPlatz().removeSpaceShip(spaceShip);
			SpaceAdventureApp.setSpaceShip(null);
			SpaceAdventureApp.setSpaceAdventureGame(null);
		} else {
			SpaceAdventureApp.setSpaceShip(null);
			SpaceAdventureApp.setSpaceAdventureGame(null);
		}

	}

	/**
	 * showAdventureMenu zeigt folgende Optionen: 1. Besuch der 3 Planeten mit den 3
	 * Puzzles 2. Weiterschweben 3. aus dem Game auszusteigen
	 * 
	 */

	private static void showAdventureMenu() {

		String menuItems[] = { "P", "Q", "R" };

// 		System.out.println("\nDein Raumschiff ist abgehoben. Du schaust auf Deine Karte und findest die folgenden Planeten auf Deiner Karte:\n");
		System.out.println("Druecke die entsprechende Taste: ");
		ArrayList<Planet> planetList = spaceAdventureGame.getPlanets();
		for (int i = 0; i < planetList.size(); i++) {
			System.out.println(menuItems[i] + " > um" + " auf " + planetList.get(i).getName() + " zu landen");

		}
		System.out.println("T > um ziellos durch das Weltall zu schweben....");
		System.out.println("X > um du das Spiel zu beenden.\n ❗ACHTUNG: Spielstand wird nicht gespeichert!");

	}

	/**
	 * handleAdventureChoice setzt die Optionen aus showAdventureMenu durch Methoden
	 * der SpaceAdventureGame-Instanz um
	 * 
	 */

	public static void handleAdventureChoice(String choice) {
		switch (choice) {
		case "P":
			spaceAdventureGame.runPlanet(0);
			break;
		case "Q":
			spaceAdventureGame.runPlanet(1);
			break;
		case "R":
			spaceAdventureGame.runPlanet(2);
			break;
		case "T":
			System.out.println("Du schwebst gerade ziellos durch das Weltall...");
			break;
		case "X":
			System.out.println("War nett mit dir zu fliegen! Das Spiel ist hiermit beendet");
			break;
		default: {
			System.out.println("Ungueltige Eingabe. Du schwebst gerade ziellos durch das Weltall");
//			runAdventureMenu();
		}
			break;
		}
	}

	public static SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public static void setSpaceShip(SpaceShip spaceShip) {
		SpaceAdventureApp.spaceShip = spaceShip;
	}

	public static ParkPlatz getParkPlatz() {
		return parkPlatz;
	}

	public static SpaceAdventureGame getSpaceAdventureGame() {
		return spaceAdventureGame;
	}

	public static void setSpaceAdventureGame(SpaceAdventureGame spaceAdventureGame) {
		SpaceAdventureApp.spaceAdventureGame = spaceAdventureGame;
	}

}
