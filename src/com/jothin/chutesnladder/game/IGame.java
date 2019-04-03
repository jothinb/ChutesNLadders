package com.jothin.chutesnladder.game;

/**
 * The Game Interface. When an object implementing interface <code>IGame</code>
 * they should provide implementation algorithm for play.
 * 
 * @author jothinadhamuni
 *
 */
public interface IGame {

	
	/**
	 * Play the game with given players.
	 * @param players Players
	 */
	void play(String [] players);
}
