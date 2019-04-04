package com.jothin.chutesnladder.board;

/**
 * The Ladder.
 * 
 * @author jothinadhamuni
 *
 */
public class Ladder {
	/**
	 * The Start Square.
	 */
	private Square startPosition;
	/**
	 * The End Square.
	 */
	private Square endPosition;

	public Ladder(Square startPosition, Square endPosition) {
		this.startPosition = startPosition;
		this.startPosition.setLadder(this);
		this.endPosition = endPosition;
	}

	public Ladder(Square endPosition) {
		this.endPosition = endPosition;
	}

	public Square getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Square startPosition) {
		this.startPosition = startPosition;
	}

	public Square getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Square endPosition) {
		this.endPosition = endPosition;
	}

}
