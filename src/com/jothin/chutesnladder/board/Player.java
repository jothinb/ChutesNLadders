package com.jothin.chutesnladder.board;
public class Player {
	
	private Square currentPosition;

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public Player(String name,int spinPositionRank) {
		this.name =name;
		this.spinPositionRank = spinPositionRank;
	}
	
	private String name;
	
	private int spinPositionRank;

	public Square getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Square currentPosition) {
		this.currentPosition = currentPosition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int spin(Spinner sp) {
		int newSpinVal = sp.spin();
		return newSpinVal;
	}
	
	public boolean isWinner() {
		return this.currentPosition.getId() == 100 ? true : false;
	}

	public int getSpinPositionRank() {
		return spinPositionRank;
	}
	
	public void moveUp() {
		this.currentPosition = this.currentPosition.getLadder().getEndPosition();
	}
	
	public void moveDown() {
		this.currentPosition = this.currentPosition.getChute().getEndPosition();
	}

	public void setSpinPositionRank(int spinPositionRank) {
		this.spinPositionRank = spinPositionRank;
	}

	
	
	

}
