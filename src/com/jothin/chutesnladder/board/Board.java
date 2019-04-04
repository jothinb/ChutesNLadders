package com.jothin.chutesnladder.board;

import java.util.stream.IntStream;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.BOARD_SIZE;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.CHUTES_SQUARES;
import static com.jothin.chutesnladder.util.ChutesLadderConfig.LADDER_SQUARES;

public final class Board {

	private Square[] squares;

	private Square[] buildBoard(int noOfSquares) {
		squares = new Square[noOfSquares];
		IntStream.range(0, noOfSquares).forEach(i -> {
			squares[i] = new Square(i + 1);
		});
		return squares;

	}

	public Board(int noOfSquares, int[][] ladderSquares, int[][] chutesSquares) {
		this.squares = buildBoard(noOfSquares);
		buildLadders(LADDER_SQUARES);
		setupChutes(CHUTES_SQUARES);
	}

	private void buildLadders(int[][] ladderSquares) {
		for (int i = 0; i < ladderSquares.length; i++) {
			int startId = ladderSquares[i][0];
			int endId = ladderSquares[i][1];
			setupLadder(startId, endId);
		}
	}

	private Ladder setupLadder(int startId, int endId) {
		assert endId > startId : "End num should be greater than start num";
		assert endId < BOARD_SIZE && startId < BOARD_SIZE : "End and start should be less than board size";
		Ladder la = new Ladder(this.squares[endId - 1]);
		squares[startId - 1].setLadder(la);
		return la;
	}

	private Chute setupChute(int startId, int endId) {
		assert startId > endId : "End num should be less than start num";
		assert endId < BOARD_SIZE && startId < BOARD_SIZE : "End and start should be less than board size";
		Chute ch = new Chute(squares[endId - 1]);
		squares[startId - 1].setChute(ch);
		return ch;
	}

	private void setupChutes(int[][] chutesSquares) {
		for (int i = 0; i < chutesSquares.length; i++) {
			int startId = chutesSquares[i][0];
			int endId = chutesSquares[i][1];
			assert endId > startId : "End num should be greater than start num";
			setupChute(startId, endId);
		}
	}

	public Square[] getSquares() {
		return squares;
	}

}
