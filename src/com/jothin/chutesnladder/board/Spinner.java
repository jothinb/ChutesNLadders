package com.jothin.chutesnladder.board;

import java.util.Random;

/**
 * The Spinner  class.
 * @author jothinadhamuni
 *
 */
public class Spinner {
	int maxNum;
	int minNum;

	public Spinner(int minNum, int maxNum) {
		this.maxNum = maxNum;
		this.minNum = minNum;
	}

	public int spin() {
		java.util.Random r = new Random();
		return r.nextInt((maxNum - minNum) + 1) + minNum;
	}

}
