package de.htwberlin.prog1.sose21.spaceadventure.model;
import javax.swing.*;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;
import java.util.TimerTask;
/**
*  Subklasse von Puzzle 
*Prozessiert das CountStrings Puzzle
*  @author ana-maria garlau
*/
public class CountStrings extends Puzzle {
		
 
	/**
	 Konstruktor ruft den Konstruktor der Superklasse mit Defaultwerten auf>
	 *name, beschreibung, artefact
	 * 
	 * */
	public CountStrings() {
		super("CountString", "\n Du hast 20 Sekunden zur Verfuegung um zu zaehlen wie oft \"tam\" in einem gegebenen String vorkommt!", "eine Polenta");
		
	}
	
	/**
	*  attemptPuzzle ueberschreibt die Methode der Superklasse
	*	Praesentiert CountStrings Puzzle 
	*  Via Userinput soll der User das Puzzle loesen
	*  Je nach Outcome des Spiels werden Attribute isSolved und artefact gesettet
	*/
	
	@Override 
  	public void attemptPuzzle(){
 		
   		
 		//String choice = choice = scanner.nextLine().isEmpty() ?   "x" :   scanner.nextLine();
 		System.out.println("Wie oft kommt tam vor?");
 		System.out.println("======================");
 		int x = generateString();
 		String xToString = Integer.toString(x);
 		//System.out.println("Richtige Antwort ist... " + x);
 		System.out.println("======================");
 		String choice = "banana";
 		long startTime = System.currentTimeMillis();
 		choice = scanner.nextLine();
 		long stopTime = System.currentTimeMillis();
 		long reactionTime = stopTime - startTime;
 		long timeToWait = 20000;
 		if(reactionTime < timeToWait && !xToString.equals(choice) ){
 			System.out.println("Du hattest es zu eilig und hast dich verzaehlt");
 		}else if(xToString.equals(choice) && reactionTime < timeToWait){
 			System.out.println("Gut gemacht!");
 			 this.setPuzzleSolved(true);
  			this.setArtefact(null);
 		}else {
 			System.out.println("Leider warst du zu langsam... \n Du hast " + reactionTime/1000 + " Sekunden gebraucht");
 		}
 		
    
  	
 	}
 	
	/**
	*  generateString 
	*@return int randomTam: zaehlt das Vorkommen des Substrings "tam" in einer
	*  random generierten String aus tam und rex
	*  	
	*  */

	
	public int generateString(){
		Random rand = new Random();
		int randomTam = rand.nextInt(16);
 // 		System.out.println("random rex " + randomRex);
		String x = "";

 		
		StringBuilder y = new StringBuilder(x);
 		if(randomTam == 0){
 			y.append("rex");
 		} 
		//System.out.println("random tam " + randomTam);
		
		int randRex = 0;
		for(int i=0; i<randomTam; i++){
			y.append("tam");
			randRex = rand.nextInt(3);
			for(int j = 0; j<randRex; j++){
				//System.out.println("randRex " +randRex);
 				y.append("rex");
			}
		}
		
	 	 
  		x= y.toString();
  		System.out.println(x);
  		 
  		 return  randomTam;
		
	}
	
//Aufgabe falsch verstanden> 1.Version
//	public int generateString(){
//	Random rand = new Random();
//	int randomTam = rand.nextInt(16);
//
//	int randomRex = rand.nextInt(3);
////		System.out.println("random rex " + randomRex);
//	String x = "";
//	StringBuilder y = new StringBuilder(x);
//	System.out.println("random tam " + randomTam);
//	for(int i=0; i<randomTam; i++){
//		y.append("tam");
//	}
//	
//	ArrayList<Integer> multiplesOf3 = new ArrayList<Integer>();
//
//	for(int i = 0; i<=randomTam; i++){
//		if(i%3 == 0){
//			multiplesOf3.add(i);
////			System.out.println("i ist" + i);
//		}
//	
//	}
//	
//		for(int j=0; j<randomRex; j++){
//			int randomIndex = multiplesOf3.get(rand.nextInt(multiplesOf3.size()));	
//			y.insert(randomIndex, "rex");
//		}
//	
//		x= y.toString();
//		System.out.println(x);
//		 
//		 return  randomTam;
//	
//}
	
	
//	
// 	public static void main(String[] args) {
// 		CountStrings cStrings = new CountStrings();
//// 		System.out.println(cStrings.getDescription());
//// 		cStrings.generateString();
//// 		System.out.println(cStrings.isPuzzleSolved());
//  		 cStrings.attemptPuzzle();
// 		System.out.println(cStrings.isPuzzleSolved());
//
// 	
// }
//	
	
}