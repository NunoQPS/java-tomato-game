package com.perisic.tomato.engine;

import java.net.URL;

/**
 * Main class where the games are coming from. 
 * Basic functionality
 */
public class GameEngine {
	String thePlayer = null;

	/**
	 * Each player has their own game engine.
	 * 
	 * @param player
	 */
	public GameEngine(String player) {
		thePlayer = player;
	}

	int counter = 0;
	int score = 0; 
/*
 * Retrieves a game. This basic version only has two games that alternate.
 */
	public URL nextGame() {
		if (counter++ % 2 == 0) {
			return GameEngine.class.getResource("/tomato1.png");
		} else {
			return GameEngine.class.getResource("/tomato2.png");
		}
	}

	/**
	 * Checks if the parameter i is a solution to the game URL. If so, score is increased by one. 
	 * @param game
	 * @param i
	 * @return
	 */
	public boolean checkSolution(URL game, int i) {
		if (i == 1) {
			score++; 
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Retrieves the score. 
	 * 
	 * @param player
	 * @return
	 */
	public int getScore() {
		return score;
	}

}
