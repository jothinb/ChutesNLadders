package com.jothin.chutesnladder.board;

import java.util.stream.IntStream;

public final class Board {
	
	public static Square[] squares = new Square[100];
	
	public static final void buildBoard() {
		IntStream.range(0, 100).forEach(i -> {squares[i] = new Square(i + 1); });
		setupLadders();
		setupChutes();
	}
	
	private static void setupLadders() {
		squares[1].setLadder( new Ladder(squares[1],squares[38]));
		
		squares[4].setLadder(new Ladder(squares[4],squares[14]));
		
		squares[9].setLadder(new Ladder(squares[9],squares[31]));
		
	/*	squares[21].setLadder(new Ladder(squares[21, 42));
		
		squares[28].setLadder(new Ladder(squares[28, 84));
		
		squares[36].setLadder(new Ladder(squares[36, 43));
		
		squares[51].setLadder(new Ladder(squares[51, 68));
		
		squares[71].setLadder(new Ladder(squares[71, 91));
		
		squares[80].setLadder(new Ladder(squares[80, 100));		*/

	}
	
	private static void setupChutes() {
		squares[98].setChute(new Chute(squares[98],squares[78]));
		
	/*	squares[95].setChute(new Chute(95, 75));
		
		squares[93].setChute(new Chute(93, 73));
		
		squares[87].setChute(new Chute(87, 24));
		
		squares[64].setChute(new Chute(64, 60));
		
		squares[62].setChute(new Chute(62, 19));
		
		squares[56].setChute(new Chute(56, 53));
		
		squares[49].setChute(new Chute(49, 11));
		
		squares[47].setChute(new Chute(47, 26));
		
		squares[16].setChute(new Chute(16, 6));	*/	

	}
	
	/* private static Ladder  prepareLadder(int start, int end) {
		return new Ladder(squares[start, end);
	}
	private static Chute  prepareChute(int start, int end) {
		return new Chute(start, end);
	} */
}
