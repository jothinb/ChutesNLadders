package com.jothin.chutesnladder.board;
import java.util.Random;

public class Spinner {
	int maxNum;
	int minNum;
	public Spinner(int minNum,int maxNum){
		this.maxNum=maxNum;
		this.minNum=minNum;
	}
	public  int  spin() {
		java.util.Random r = new Random();
		//return (int) (minNum + Math.round((maxNum-minNum) * Math.random()));
		//return r.nextInt(maxNum)+1;
		return r.nextInt((maxNum - minNum) + 1) + minNum;
	}

}
