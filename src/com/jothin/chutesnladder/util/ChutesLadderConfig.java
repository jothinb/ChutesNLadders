package com.jothin.chutesnladder.util;

/**
 * Utility class for Game Configuration. 
 * @author jothinadhamuni
 *
 */
public class ChutesLadderConfig {
	
	public static int BOARD_SIZE =10*10;
	public static int[][] LADDER_SQUARES = { { 4, 14 }, { 9, 31 }, { 21, 42 }, { 28, 84 }, { 36, 43 }, { 51, 68 }, { 71, 91 },
			{ 80, 100 } };
	public static int[][] CHUTES_SQUARES = { { 98, 78 }, { 95, 75 }, { 93, 73 }, { 87, 24 }, { 64, 60 }, { 62, 19 }, { 56, 53 },
			{ 49, 11 }, { 47, 26 }, { 16, 6 } };
	public static int SPIN_MIN=1;
	public static int SPIN_MAX=6;
	public static int MIN_NO_PLAYERS=2;
	public static int MAX_NO_PLAYERS=4;
	public static int WINNING_POINT =100;
	

}
