package com.jothin.chutesnladder.board;

/**
 * The Chute.
 * @author jothinadhamuni
 *
 */
public class Chute {
	/**
	 * The Starte Square
	 */
	private Square startPosition;
	/**
	 * The End Square.
	 */
	private Square endPosition;
	public Chute(Square startPosition, Square endPosition) {
		this.startPosition=startPosition;
		this.endPosition= endPosition;
	}
	public Chute(Square endPosition) {
		this.endPosition= endPosition;
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
