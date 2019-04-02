package com.jothin.chutesnladder.board;
import java.util.Random;

public class Spinner {
	int maxNum;
	public Spinner(int maxNum){
		this.maxNum=maxNum;
	}
	public  int  spin() {
		java.util.Random r = new Random();
		return r.nextInt(maxNum)+1;
	}

}
