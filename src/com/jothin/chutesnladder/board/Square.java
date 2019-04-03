package com.jothin.chutesnladder.board;

/**
 * The Square class which is used create the Game Board.
 * @author jothinadhamuni
 *
 */
public class Square {

	/**
	 * The Square Id.
	 */
	private int id;
	/**
	 * The Ladder.
	 */
	private Ladder ladder;
	/**
	 * The Chute.
	 */
	private Chute chute;
	/**
	 * The Game Board.
	 */
	private Board board;
	
	public Square(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ladder getLadder() {
		return ladder;
	}
	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
		ladder.setStartPosition(this);
	}
	public Chute getChute() {
		return chute;
	}
	public void setChute(Chute chute) {
		chute.setStartPosition(this);
		this.chute = chute;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	

}
