package com.jothin.chutesnladder;

import com.jothin.chutesnladder.board.Spinner;
import com.jothin.chutesnladder.game.ChutesNLadders;
import com.jothin.chutesnladder.game.IGame;

import static com.jothin.chutesnladder.util.ChutesLadderConfig.BOARD_SIZE;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.CHUTES_SQUARES;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.LADDER_SQUARES;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.SPIN_MAX;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.SPIN_MIN;


/**
 * 
 * Chutes and Ladder Game Runner.
 * 
 * @author jothinadhamuni
 *
 */
public class ChutesNLadderRunner {
	
	public static void main(String[] args) {
		
		
		// Uncomment to get the player names from Command Line
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no  Players between 2 to 4: ");
		
		int noOfPlayers = scanner.nextInt();
		
		while (2> noOfPlayers || noOfPlayers > 4) {
			System.out.println("Enter no  Players between 2 to 4: ");
			noOfPlayers = scanner.nextInt();
		}
		scanner.nextLine();
		String[] playerNames = new String[noOfPlayers];
		for (int i = 0; i < playerNames.length ; i++) {
			System.out.println("Enter Player Name : " +  (i+1));
			playerNames[i] = scanner.nextLine();
		}
		
		scanner.close(); */
		
		String[] playerNames = autoGeneratePlayers();
		IGame game =new ChutesNLadders.ChutesNLaddersBuilder(BOARD_SIZE, LADDER_SQUARES, CHUTES_SQUARES).withSpinner(SPIN_MIN, SPIN_MAX).withPlayers(playerNames).build();
		game.play();

	}

	/**
	 * Utility test  method to generate the random no of players  between 2 to 4.
	 * @return The player Names
	 */
	private static String[] autoGeneratePlayers() {
		Spinner spinner = new Spinner(2,4);
		int noOfPlayers = spinner.spin();
		String[] playerNames = new String[noOfPlayers];
		for (int i = 0; i < playerNames.length ; i++) {
			playerNames[i] = "Player"+(i+1);
		}
		return playerNames;
	}

}
