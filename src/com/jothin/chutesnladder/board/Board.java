package com.jothin.chutesnladder.board;

import java.util.stream.IntStream;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.BOARD_SIZE;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.CHUTES_SQUARES;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.LADDER_SQUARES;

public final class Board {
	
	private  Square[] squares ;

	private  Square[] buildBoard(int noOfSquares) {
		squares = new Square[noOfSquares];
		IntStream.range(0, noOfSquares).forEach(i -> {
			squares[i] = new Square(i + 1);
		});
		return squares;
		
	}
	
	public Board(int noOfSquares,int[][] ladderSquares,int[][] chutesSquares) {
		this.squares = buildBoard(noOfSquares);
		buildLadders(LADDER_SQUARES);
		setupChutes(CHUTES_SQUARES);
	}

	private  void buildLadders(int[][] ladderSquares) {
		for (int i = 0; i < ladderSquares.length; i++) {
			int startId = ladderSquares[i][0];
			int endId = ladderSquares[i][1];
			setupLadder(startId, endId);
		}

		/*
		 * squares[4].setLadder(new Ladder(squares[4],squares[14]));
		 * 
		 * squares[9].setLadder(new Ladder(squares[9],squares[31]));
		 * 
		 * squares[21].setLadder(new Ladder(squares[21, 42));
		 * 
		 * squares[28].setLadder(new Ladder(squares[28, 84));
		 * 
		 * squares[36].setLadder(new Ladder(squares[36, 43));
		 * 
		 * squares[51].setLadder(new Ladder(squares[51, 68));
		 * 
		 * squares[71].setLadder(new Ladder(squares[71, 91));
		 * 
		 * squares[80].setLadder(new Ladder(squares[80, 100));
		 */

	}

	private  Ladder setupLadder(int startId, int endId) {
		assert endId > startId : "End num should be greater than start num";
		assert endId<BOARD_SIZE && startId < BOARD_SIZE : "End and start should be less than board size";
		Ladder la = new Ladder(this.squares[endId-1]);
		squares[startId-1].setLadder(la);
		return la;
	}

	private  Chute setupChute(int startId, int endId) {
		assert startId > endId : "End num should be less than start num";
		assert endId<BOARD_SIZE && startId < BOARD_SIZE : "End and start should be less than board size";
		Chute ch = new Chute(squares[endId-1]);
		squares[startId-1].setChute(ch);
		return ch;
	}

	private  void setupChutes(int[][] chutesSquares) {
		for (int i = 0; i < chutesSquares.length; i++) {
			int startId = chutesSquares[i][0];
			int endId = chutesSquares[i][1];
			assert endId > startId : "End num should be greater than start num";
			setupChute(startId, endId);
		}

		/*
		 * squares[98].setChute(new Chute(squares[98],squares[78]));
		 * 
		 * squares[95].setChute(new Chute(95, 75));
		 * 
		 * squares[93].setChute(new Chute(93, 73));
		 * 
		 * squares[87].setChute(new Chute(87, 24));
		 * 
		 * squares[64].setChute(new Chute(64, 60));
		 * 
		 * squares[62].setChute(new Chute(62, 19));
		 * 
		 * squares[56].setChute(new Chute(56, 53));
		 * 
		 * squares[49].setChute(new Chute(49, 11));
		 * 
		 * squares[47].setChute(new Chute(47, 26));
		 * 
		 * squares[16].setChute(new Chute(16, 6));
		 */

	}

	public Square[] getSquares() {
		return squares;
	}

	/*
	 * private static Ladder prepareLadder(int start, int end) { return new
	 * Ladder(squares[start, end); } private static Chute prepareChute(int start,
	 * int end) { return new Chute(start, end); }
	 */
	
	
}
