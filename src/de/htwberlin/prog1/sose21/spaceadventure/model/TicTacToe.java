package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.InputMismatchException;
import java.util.Random;

/**
 * Erstellt ein TicTacToe-Puzzle, Subklasse von Puzzle Spieler spielt eine Runde
 * gegen den Computer
 * 
 * @author ana-maria garlau
 * 
 */

public class TicTacToe extends Puzzle {

	private boolean isItATie = false;

	private String[][] board = { { " ", "|", " ", "|", " " }, { "-", "+", "-", "+", "-" }, { " ", "|", " ", "|", " " },
			{ "-", "+", "-", "+", "-" }, { " ", "|", " ", "|", " " }, };

	/**
	 * Konstruktor ruft den Konstruktor der Superklasse mit Defaultwerten auf> name,
	 * beschreibung, artefact
	 * 
	 */

	public TicTacToe() {
		super("TicTacToe", "Spiele eine Runde TicTacToe gegen den Computer.", "Eine Curry Wurst");
		// TODO Auto-generated constructor stub
	}

	/**
	 * attemptPuzzle ueberschreibt die Methode der Superklasse Praesentiert
	 * TicTacToe Spiel Via Userinput soll der User das Puzzle loesen Je nach Outcome
	 * des Spiels werden Attribute isSolved, isItATie und artefact gesetzt
	 */

	@Override
	public void attemptPuzzle() {
		System.out.println("Gib eine Position 1-9!");

		String[][] boardPosition = { { "1", "|", "2", "|", "3" }, { "-", "+", "-", "+", "-" },
				{ "4", "|", "5", "|", "6" }, { "-", "+", "-", "+", "-" }, { "7", "|", "8", "|", "9" }, };
		for (int i = 0; i < boardPosition.length; i++) {
			for (int j = 0; j < boardPosition[i].length; j++) {
				System.out.print(boardPosition[i][j]);
			}
			System.out.println();
		}

		System.out.println("=================");
//	drawBoard();
		boolean gameOver = isGameOver();

		while (!gameOver) {
			System.out.println("=================");
			playHuman();
			gameOver = isGameOver();
			if (gameOver) {
				break;
			}
			System.out.println("=================");
			randomizeComputer();
			System.out.println("=================");
			gameOver = isGameOver();
			if (gameOver) {
				break;
			}
			System.out.println("give position 1-9");

		}
//		System.out.println("is puzzle solved is " + this.isPuzzleSolved());
//		System.out.println("did the computer win " + this.isDidComputerWin());
//		System.out.println("is board full" + isBoardFull() );
		if (!this.isPuzzleSolved() && !this.isDidComputerWin()) {

			// System.out.println("It s a tie");
		}

		resetBoard();
	}

	
	/**
	 * resetBoard setzt das Brett zu Initialwerten zurueck
	 * 
	 */
	
	public void resetBoard() {
		board[0][0] = " ";
		board[0][2] = " ";
		board[0][4] = " ";
		board[2][0] = " ";
		board[2][2] = " ";
		board[2][4] = " ";
		board[4][0] = " ";
		board[4][2] = " ";
		board[4][4] = " ";

	}

	/**
	 * isGameOver ueberprueft, ob das Spiel beendet ist
	 * Durchsucht das Brett nach moeglichen Gewinnerstrings
	 * Checkt, ob das Brett voll ist
	 * Benachrichtigt den Spieler, falls das Spiel vorbei ist
	 * @return boolean true, wenn einen Gewinnerstring gefunden wurde 
	 * oder wenn das Brett  voll ist
	 */
	
	public boolean isGameOver() {
		if (checkForWinner("XXX")) {
//		System.out.println("Human won");
			this.setPuzzleSolved(true);
			this.setArtefact(null);
			return true;
		} else if (checkForWinner("OOO")) {
			System.out.println("Der Computer hat dich besiegt...");
			this.setDidComputerWin(true);
			return true;
		} else if (isBoardFull() && !checkForWinner("XXX") && !checkForWinner("OOO")) {
//		System.out.println("It s a tie");
			return true;
		} else {
			return false;
		}

	}

	/**
	 * checkForWinner checkt alle Gewinnmoeglichkeiten> rows, columns, diagonals
	 * nach Gewinnerstrings
	 * @param String whoWon zB "XXX" fuer Spieler oder "OOO" fuer den Computer
	 * @return boolean true nur wenn eine Gewinnerkombination gefunden wurde
	 */
	
	public boolean checkForWinner(String whoWon) {

		String row1 = board[0][0] + board[0][2] + board[0][4];
		String row2 = board[2][0] + board[2][2] + board[2][4];
		String row3 = board[4][0] + board[4][2] + board[4][4];
		String col1 = board[0][0] + board[2][0] + board[4][0];
		String col2 = board[0][2] + board[2][2] + board[4][2];
		String col3 = board[0][4] + board[2][4] + board[4][4];
		String diag1 = board[0][0] + board[2][2] + board[4][4];
		String diag2 = board[0][4] + board[2][2] + board[4][0];
		String[] winningPoss = { row1, row2, row3, col1, col2, col3, diag1, diag2 };
		for (String x : winningPoss) {
//				System.out.println(x);
			if (x.equals(whoWon)) {

				return true;
			}
		}

		return false;
	}

	/**
	 * isBoardFull ueberprueft, ob das Brett voll ist,
	 * d.h. alle Positionen mit "X" oder "O" besetzt sind
	 * @return boolean true wenn das Brett voll ist
	 */
	
	public boolean isBoardFull() {
		boolean isFull = false;
		for (int i = 0; i < board.length; i = i + 2) {
			for (int j = 0; j < board[i].length; j = j + 2) {
				if (board[i][j] != "X" && board[i][j] != "O") {
//					System.out.println("Geht noch");
					return false;
				}

			}

		}
		return true;
	}

	/**
	 * playHuman steuert den Spielverlauf fuer den menschlichen Player  
	 * checkt ob seine Moves erlaubt sind
	 * benachrichgt ihn, wenn eine Position bereits besetzt ist,
	 *  wenn er sich ausserhalb des Spiels befindet
	 *  und wo er seinen letzten Move gemacht hat
	 */
	
	public void playHuman() {
//		System.out.println("Insert a position 1-9");
		int choice = takeInput();
		;
		boolean legal = canYouMove(choice);
		while (!legal) {
			if (choice > 9 || choice <= 0) {
				System.out.println("Du hast das Spielbrett verlassen, probiere eine andere Position 1>9");
				choice = takeInput();
				legal = canYouMove(choice);
			} else {
				System.out.println("Position ist besetzt, versuch eine andere 1>9");
				choice = takeInput();
				legal = canYouMove(choice);
			}

		}
		System.out.println("Dein letztes Move war Position " + choice);
		handleInput(choice, "human");
//		drawBoard();
	}

	
	/**
	 * randomizeComputer steuert den Spielverlauf fuer den Player Computer
	 * randomisiert die Moves vom Computer
	 * checkt ob seine Moves erlaubt sind 
	 * erstellt neue randomisierte moegliche Moves bis 
	 * ein erlaubter Move gefunden wird
	 */
	
	public void randomizeComputer() {

		Random rand = new Random();
		int randComputerPosition = rand.nextInt(9) + 1;
		boolean legal = canYouMove(randComputerPosition);
		while (!legal) {
			randComputerPosition = rand.nextInt(9) + 1;
			legal = canYouMove(randComputerPosition);
		}
		System.out.println("Der Computer hat ein 'O' in Position " + randComputerPosition + " gesetzt");
		handleInput(randComputerPosition, "computer");

	}
	
	/**
	 * takeInput nimmt Input von Playern an 
	 * ueberprueft auf fehlerhafte Angaben
	 * fordert den Player auf, eine erneute Eingabe zu machen bis
	 * seine Eingabe fehlerfrei ist
	 * @return int nb wenn der Input fehlerfrei ist
	 */

	public int takeInput() {
		boolean isOk = false;
		int nb = -1;
		while (!isOk) {
			try {
				nb = scanner.nextInt();
				isOk = true;

			} catch (InputMismatchException e) {
				System.out.println("Ooops, das war keine Zahl. Versuch es nochmal!");
				scanner.nextLine();

			}
		}
		return nb;

	}

	/**
	*  handleInput setzt je nach Playertyp ein Symbol auf das Spielfeld
	*@param int nb > die vom Player gewaehlte Position
	*@param typeOfPlayer String: typ von Spieler, dh human oder computer  
	*/
	
	public void handleInput(int nb, String typeOfPlayer) {
		String symbol = " ";
		if (typeOfPlayer.equals("human")) {
			symbol = "X";
		} else if (typeOfPlayer.equals("computer")) {
			symbol = "O";
		} else {
			System.out.println("There is no such player");
		}
		switch (nb) {
		case 1:
			board[0][0] = symbol;
			drawBoard();
			break;
		case 2:
			board[0][2] = symbol;
			drawBoard();
			break;
		case 3:
			board[0][4] = symbol;
			drawBoard();
			break;
		case 4:
			board[2][0] = symbol;
			drawBoard();
			break;
		case 5:
			board[2][2] = symbol;
			drawBoard();
			break;
		case 6:
			board[2][4] = symbol;
			drawBoard();
			break;
		case 7:
			board[4][0] = symbol;
			drawBoard();
			break;
		case 8:
			board[4][2] = symbol;
			drawBoard();
//			System.out.println(board[4][2]);
			break;
		case 9:
			board[4][4] = symbol;
			drawBoard();
			break;
		default:
//			System.out.println("Du bist ausserhalb des Spiels... 1-9");
			break;
		}
	}

	
	/**
	* drawBoard gibt das Spielbrett aus 
	*  
	*/
	
	public void drawBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public String[][] getBoard() {
		return board;
	}
	
	/**
	*  canYouMove checkt, ob ein Move erlaubt ist
	* @param position int : Zahl 1-9 
	* @return boolean true, wenn die ausgewaehlte Position erlaubt ist
	*/

	public boolean canYouMove(int position) {
		switch (position) {
		case 1:
			if (board[0][0].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 2:
			if (board[0][2].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 3:
			if (board[0][4].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 4:
			if (board[2][0].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 5:
			if (board[2][2].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 6:
			if (board[2][4].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 7:
			if (board[4][0].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 8:
			if (board[4][2].equals(" ")) {
				return true;
			} else {

				return false;
			}
		case 9:
			if (board[4][4].equals(" ")) {
				return true;
			} else {

				return false;
			}
		default:
//			System.out.println("Du bist ausserhalb des Spiels... 1-9");
			return false;
		}

	}

	public boolean isItATie() {
		return isItATie;
	}

//	public static void main(String[] args) {
//		TicTacToe x = new TicTacToe();
//		x.attemptPuzzle();
//		
// 
//
//}

}
