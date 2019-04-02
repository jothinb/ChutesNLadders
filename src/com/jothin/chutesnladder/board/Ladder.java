package com.jothin.chutesnladder.board;

public class Ladder {
	private Square startPosition;
	private Square endPosition;
	public Ladder(Square startPosition, Square endPosition) {
		this.startPosition=startPosition;
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
