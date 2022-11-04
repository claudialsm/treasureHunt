package com.lesson.treasureHunt;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		Scanner inputObj = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = inputObj.nextLine();
		
		boolean gridQuery = true;
		int size = 0;
		while (gridQuery) {
			try {
				System.out.println("Enter the grid size (3 or higher): ");
				size = Integer.parseInt(inputObj.nextLine());
				if (size > 2) {
					gridQuery = false;
				};
			}
			catch (Exception e) {
				System.out.println("Oops, that didn't work!");
			}

		}
		Grid g1 = new Grid();
		g1.createGrid(size);

		// Generate the objects on the grid
		Player p1 = new Player(name);
		p1.setRandomLocation(g1);

		Treasure t1 = new Treasure();
		t1.setRandomLocation(g1);

		Enemy e1 = new Enemy();
		e1.setRandomLocation(g1);
//		g1.updateGrid(e1.getXPosition(), e1.getYPosition(), e1.getCharacter());

		boolean gameStarted = true;

//		GameState GS = new GameState();
//		GS.startGame();

		while (gameStarted) {
			g1.showGrid(size);
			g1.calculateDistance(p1, t1);
			
			System.out.println(
					"Enter a direction, 'w' for up, 'a' for left, 's' for down, 'd' for right, 'x' for exit game...");
			String direction = inputObj.nextLine();
			switch (direction) {
			case "w":
				p1.moveUp(g1);
				break;
			case "a":
				p1.moveLeft(g1);
				break;
			case "s":
				p1.moveDown(g1);
				break;
			case "d":
				p1.moveRight(g1);
				break;
			case "x":
				System.out.println(p1.getName() + " has quit the game.");
				gameStarted = false;
				break;
			default:
				System.out.println("Enter a direction, 'w' for up, 'a' for left, 's' for down, 'd' for right...");
				break;
			}
			
			if ((p1.getXPosition() == t1.getXPosition()) && (p1.getYPosition() == t1.getYPosition())) {
				System.out.println("Congratulations " + p1.getName() + "! You win!");
				gameStarted = false;
			}
			
			if ((p1.getXPosition() == e1.getXPosition()) && (p1.getYPosition() == e1.getYPosition())) {
				System.out.println("Game over, you died! :(");
				gameStarted = false;
			}
		}
	}
}
