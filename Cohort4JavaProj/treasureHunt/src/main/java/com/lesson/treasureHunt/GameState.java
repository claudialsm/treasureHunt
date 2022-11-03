package com.lesson.treasureHunt;

import java.util.Scanner;

public class GameState {
	public void startGame() {
		// Generate the grid
		Scanner inputObj = new Scanner(System.in);
		System.out.println("Enter the grid size: ");
		int size = Integer.parseInt(inputObj.nextLine());		
		Grid g1 = new Grid();
		g1.createGrid(size);
		
		// Generate the objects on the grid
		Player p1 = new Player();
		p1.setRandomLocation(size);
		g1.updateGrid(p1.getXPosition(), p1.getYPosition(), p1.getCharacter());
		
		Treasure t1 = new Treasure();
		t1.setRandomLocation(size);
		g1.updateGrid(t1.getXPosition(), t1.getYPosition(), t1.getCharacter());
		
		Enemy e1 = new Enemy();
		e1.setRandomLocation(size);
		g1.updateGrid(e1.getXPosition(), e1.getYPosition(), e1.getCharacter());
		
//		g1.showGrid(size);
		
//		g1.calculateDistance(p1, t1);
		
//		g1.updateGrid(p1.getXPosition(), p1.getYPosition(), p1.getCharacter());
//		g1.updateGrid(t1.getXPosition(), t1.getYPosition(), t1.getCharacter());
//		g1.updateGrid(e1.getXPosition(), e1.getYPosition(), e1.getCharacter());
//		g1.showGrid(size);
		
//		g1.calculateDistance(p1, t1);
	}
	
	public void winGame(Player p1, Treasure t1) {
		if ((p1.getXPosition() == t1.getXPosition()) && (p1.getYPosition() == t1.getYPosition())) {
			System.out.println("Congratulations! You win!");
		}
	}
	
	public void loseGame(Player p1, Enemy e1) {
		if ((p1.getXPosition() == e1.getXPosition()) && (p1.getYPosition() == e1.getYPosition())) {
			System.out.println("Game over - you lose!");
		}
	}
}
