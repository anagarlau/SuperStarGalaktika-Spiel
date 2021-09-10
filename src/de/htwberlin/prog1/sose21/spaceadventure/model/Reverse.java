package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Erstellt ein Reverse-Puzzle, Subklasse von Puzzle 
 * drei Woerter werden angezeigt,
 * Spieler soll sie rückwärts wieder eingeben
 * 
 * @author ana-maria garlau
 * 
 */
public class Reverse extends Puzzle {
	private String[] reverseChoices = { "You", "elephants", "doctors", "aligators", "pandas", "disgust", "eats",
			"bathes", "barfed", "scores" };

	/**
	 * Konstruktor ruft den Konstruktor der Superklasse mit Defaultwerten auf> name,
	 * beschreibung, artefact
	 * 
	 */

	public Reverse() {
		super("Reverse", "Du hast 30 seconds um ein String Wort fuer Wort rueckwaerts einzugeben", "Stein");
		 
	}

	/**
	 * attemptPuzzle ueberschreibt die Methode der Superklasse Praesentiert Reverse
	 * Puzzle Via Userinput soll der User das Puzzle loesen Je nach Outcome des
	 * Spiels werden Attribute isSolved und artefact gesettet
	 */

	@Override
	public void attemptPuzzle() {

		LocalDateTime twentySecondsLater = LocalDateTime.now().plusSeconds(15);
		String strToReverse1 = randomizeString();
		String strToReverse2 = randomizeString();
		String strToReverse3 = randomizeString();
		String strToReverse = strToReverse1 + " " + strToReverse2 + " " + strToReverse3;
		String strReversed1 = this.reverseString(strToReverse1);
		String strReversed2 = this.reverseString(strToReverse2);
		String strReversed3 = this.reverseString(strToReverse3);
		String strToCompare = strReversed1 + " " + strReversed2 + " " + strReversed3;

		String choice = "MEOW";

		//System.out.println(strToCompare);
		System.out.println("Bitte den String rueckwaerts eintippen! Groß/Kleinschreibung sind nicht zu beachten");

		System.out.println("=======================================");
		System.out.println(strToReverse);
		System.out.println("=======================================");
		long startTime = System.currentTimeMillis();
		choice = scanner.nextLine();
		long stopTime = System.currentTimeMillis();
		long reactionTime = stopTime - startTime;
		long timeToWait = 30000;
		if (reactionTime < timeToWait && !this.compareStrings(choice, strToCompare)) {
			System.out.println("Du hattest es zu eilig und hast dich vertippt!");
		} else if (this.compareStrings(choice, strToCompare) && reactionTime < timeToWait) {
			System.out.println("Gut gemacht! Du hast " + reactionTime / 1000 + " Sekunden gebraucht");
			this.setPuzzleSolved(true);
			this.setArtefact(null);
		} else {
			System.out
					.println("Leider warst du zu langsam... \n Du hast " + reactionTime / 1000 + " Sekunden gebraucht");
		}

	}

	/**
	 * compareStrings vergleicht 2 Strings
	 * 
	 * @param str1 String
	 * @param str2 String
	 * @return boolean true wenn die Strings aequivalent sind
	 */

	public boolean compareStrings(String str1, String str2) {
		str1 = str1.toLowerCase().trim();
		str2 = str2.toLowerCase().trim();
		if (str1.length() != str2.length()) {
			return false;
		} else {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					return false;

				}

			}
			return true;
		}
	}

	/**
	 * reverseString gibt einen String rueckwaerts zurueck
	 * 
	 * @param string String
	 * @return reversed String > string rueckwarts geschrieben
	 */

	public String reverseString(String string) {

		StringBuilder strToReverse = new StringBuilder(string);
		StringBuilder reversed = strToReverse.reverse();
//		System.out.println(reversed.toString());
		return reversed.toString();
	}

	/**
	 * randomizeString randomisiert einen Index des reverseChoices String[] Attribut
	 * 
	 * @return x String aus reverseChoices String[] Attribut
	 */

	public String randomizeString() {
		Random rand = new Random();
		String x = reverseChoices[rand.nextInt(this.reverseChoices.length)];
		return x;
	}

	public String[] getReverseChoices() {
		return reverseChoices;
	}

	public void setReverseChoices(String[] reverseChoices) {
		this.reverseChoices = reverseChoices;
	}

//	public static void main(String[] args) {
//		Reverse x = new Reverse();
////		System.out.println(x.getDescription());
//		x.runPuzzle();
////		String m = x.randomizeString();
////		x.reverseString(m);
//// 		System.out.println(x.compareStrings("ana", "aNa") );
//		
//	}
}
