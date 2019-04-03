package com.jothin.chutesnladder.game;

import static com.jothin.chutesnladder.util.ChutesLadderConfig.BOARD_SIZE;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.CHUTES_SQUARES;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.LADDER_SQUARES;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.SPIN_MAX;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.SPIN_MIN;

import java.util.Arrays;
import java.util.Comparator;

import com.jothin.chutesnladder.board.Board;
import com.jothin.chutesnladder.board.Spinner;

/**
 * 
 * Chutes and Ladders Game Implementation with 10*10 GameBoard and Spinner.
 * 
 * @author jothinadhamuni
 *
 */
public final class ChutesNLadders implements IGame {

	/**
	 * The ChutesNLadders Game Board.
	 */
	private Board board;

	

	/**
	 * The spinner which produces the random value.
	 */
	private Spinner spinner;
	
	
	
	/**
	 * The default constructor to create ChutesNLadders with 10*10 board and Spinner
	 */
	public ChutesNLadders() {
		this.spinner = createSpinner(SPIN_MIN, SPIN_MAX);
		this.board = prepareBoard(BOARD_SIZE, LADDER_SQUARES, CHUTES_SQUARES);
	}

	

	/**
	 * @param noOfSquares No of Squares.
	 * @param ladderSquares array of ladders squares with start and end .
	 * @param chutesSquares array of chutesSquares squares with start and end .
	 * @return Board The GameBoard
	 */
	private Board prepareBoard(int noOfSquares, int[][] ladderSquares, int[][] chutesSquares) {
		return new Board(noOfSquares, ladderSquares, chutesSquares);
	}

	/**
	 * Create Spinner instance to generate random number between given minimum and
	 * maximum value.
	 * 
	 * @param min
	 *            Minimum number
	 * @param max
	 *            Maximum number
	 * @return Spinner.
	 */
	private Spinner createSpinner(int min, int max) {
		Spinner spinner = new Spinner(min, max);
		return spinner;
	}

	
	/* (non-Javadoc)
	 * @see com.jothin.chutesnladder.game.IGame#play(java.lang.String[])
	 */
	public void play(String [] playerNames) {
		
		Player[] players  = preparePlayerList(playerNames);
		if (null == players || players.length < 2) {
			System.out.println("ChutesNLadders requires minimum 2  players to start the Game ");
			System.exit(0);
		}
		boolean foundWinner = false;
		int iteration = 1;
		while (!foundWinner) {
			for (Player player : players) {
				int spinVal = player.spin(spinner);
				int currentPosition = player.getCurrentPosition() != null ? player.getCurrentPosition().getId() : 0;
				int newPostion = currentPosition + spinVal;

				if (newPostion > 100) {
					// System.out.println("Turn Ignored because " + player.getName() + " scored
					// above 100");
					continue;
				} else {
					player.setCurrentPosition(this.board.getSquares()[newPostion - 1]);
					System.out
							.print(iteration + ": " + player.getName() + ": " + currentPosition + "--->" + newPostion);
					if (null != player.getCurrentPosition().getChute()) {
						player.moveDown();
						System.out.print("-- CHUTE --->" + player.getCurrentPosition().getId());
					} else if (null != player.getCurrentPosition().getLadder()) {
						player.moveUp();
						System.out.print("-- LADDER --->" + player.getCurrentPosition().getId());
					}

				}
				System.out.println("\n");
				iteration++;
				if (player.isWinner()) {
					foundWinner = true;
					System.out.println("The winner is " + player.getName() + "!");
					break;
				}

			}
		}

	}

	/**
	 * Prepare players and sort them based on the first spin value.
	 * 
	 * @param playerNames
	 *            The Players
	 * @return The Players array
	 */
	private Player[] preparePlayerList(String[] playerNames) {
		Player[] players = new Player[playerNames.length];
		int i = 0;
		for (String string : playerNames) {
			players[i] = new Player(string, this.spinner.spin());
			i++;
		}
		Comparator<Player> compareByFirstSpinRank = (p1, p2) -> {
			if (p1.getSpinPositionRank() > p2.getSpinPositionRank()) {
				return 1;
			} else {
				return -1;
			}
		};
		Arrays.sort(players, compareByFirstSpinRank);
		return players;

	}

}
