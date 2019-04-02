package com.jothin.chutesnladder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.jothin.chutesnladder.board.Board;
import com.jothin.chutesnladder.board.Player;
import com.jothin.chutesnladder.board.Spinner;

public class Game {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
		
		scanner.close();
		playGame(playerNames);

	}
	
	public static void playGame(String[] playerNames) {
		Board.buildBoard();
		Spinner spinner = new Spinner(6);
		Player[] players = preparePlayerList (playerNames,spinner) ;
		boolean winnderFound = false;
		int iteration =1;
		while (!winnderFound) {
			for (Player player : players) {
				int spinVal = player.spin(spinner);
				int currentPosition = player.getCurrentPosition() != null ? player.getCurrentPosition().getId() :0;
				int newPostion = currentPosition+spinVal;
				
				if (newPostion < 100) {
					player.setCurrentPosition(Board.squares[newPostion]);
					System.out.print(iteration +": "+ player.getName() +": " + currentPosition +"--->" +newPostion);
					if (null != player.getCurrentPosition().getChute()) {
						player.moveDown();
						System.out.print("-- CHUTE --->" +player.getCurrentPosition().getId());
					} else if (null != player.getCurrentPosition().getLadder()) {
						player.moveUp();
						System.out.print("-- LADDER --->" +player.getCurrentPosition().getId());
					}
					}else {
						System.out.println("Turn Ignored because scored above 100 --" + player.getName());
					}
				System.out.println("\n"); 
				iteration++;
				if (player.isWinner() ) { winnderFound=true;System.out.println("The winner is " + player.getName() + "!"); break;}
				
			}
			if (winnderFound) break;
		}
		
		
	}

	private static Player[] preparePlayerList(String[] playerNames, Spinner sp) {
		
		Player[] players = new Player[playerNames.length];
		int i=0;
		for (String string : playerNames) {
			players[i] = new Player(string,sp.spin());
			i++;
		}
		Comparator<Player> compareByFisrtSpinRank = (p1,p2) -> { if (p1.getSpinPositionRank()  > p2.getSpinPositionRank()) {
			return 1;
		}else {return -1;}};
		Arrays.sort(players, compareByFisrtSpinRank);
		return players;
		
	}		

}
