package com.lesson.treasureHunt;

import java.util.Random;

public class Unit {
	 private String name;
	 private int xPosition;
	 private int yPosition;
	 private String character;
	 
	 public Unit() {
		 this.name = "Unit";
		 this.xPosition = 0;
		 this.yPosition = 0;
	}

	 // Getter methods
	 public String getCharacter() {
		 return character;
	 }
	 
	 public String getName() {
		 return name;
	 }
		  
	 public int getXPosition() {
		 return xPosition;
	 }
	 
	 public int getYPosition() {
		 return yPosition;
	 }
	 
	 // Setter methods
	 public void setCharacter(String character) {
		 this.character = character;
	 }
	 
	 public void setName(String name) {
		  this.name = name;
	}
	 
	 public void setXPosition(int xPosition) {
		 // TO DO: if statement to check if out of bounds
		  this.xPosition = xPosition;
		 }
	 
	 public void setYPosition(int yPosition) {
		 // TO DO: if statement to check if out of bounds
		  this.yPosition = yPosition;
		 }
	 
	 // Other methods
	 public int randomLocation(int size) {
		 Random rand = new Random();
		 int location = rand.nextInt(size);

		 return location;
		}
	
//	 public void setRandomLocation(Grid grid) {
//		 int randomX = randomLocation(grid.getSize());
//		 int randomY = randomLocation(grid.getSize());
//		 
//		 boolean unassignedSpace = true;
//		 
//		 while (unassignedSpace) {
//			 if (grid.coordinates[randomX][randomY] == " • ") {
//				 setXPosition(randomX);
//				 setYPosition(randomY); 
//				 unassignedSpace = false;
//			 }
//		 }
//			 
//
//	 }
	 
		public void setRandomLocation(Grid grid) {
			boolean unassignedSpace = true;
			int randomX = randomLocation(grid.getSize());
			int randomY = randomLocation(grid.getSize());

//			System.out.println("X position = " + this.xPosition);
//			System.out.println("randomX = " + randomX);
//			System.out.println("Y position = " + this.yPosition);
//			System.out.println("randomY = " + randomY);

			while (unassignedSpace) {
				if ((grid.coordinates[randomX][randomY] == " • ") && (grid.coordinates[randomX][randomY] != " P ") && (grid.coordinates[randomX][randomY] != " T ") && (grid.coordinates[randomX][randomY] != " E ")) {
//					System.out.println("if");
					setXPosition(randomX);
					setYPosition(randomY);
					grid.updateGrid(this.getXPosition(), this.getYPosition(), this.getCharacter());
					unassignedSpace = false;
					break;
				}

				else {
//					System.out.println("else");
					randomX = randomLocation(grid.getSize());
					randomY = randomLocation(grid.getSize());
				}	
			}
		}
	 
	 public void moveLeft(Grid grid) {
		 if (this.xPosition > 0) {
			 grid.updateGrid(this.xPosition, this.yPosition, " • ");
			 this.xPosition -= 1;
			 grid.updateGrid(this.xPosition, this.yPosition, this.getCharacter());
		 }
		 else {
			 System.out.println("You cannot move further left.");
		 }
	 }
	 
	 public void moveRight(Grid grid) {
		 if (this.xPosition < (grid.getSize() - 1)) {
			 grid.updateGrid(this.xPosition, this.yPosition, " • ");
			 this.xPosition += 1;
			 grid.updateGrid(this.xPosition, this.yPosition, this.getCharacter());
		 }
		 else {
			 System.out.println("You cannot move further right.");
		 }
	 }
	 
	 public void moveUp(Grid grid) {
		 if (this.yPosition > 0) {
			 grid.updateGrid(this.xPosition, this.yPosition, " • ");
			 this.yPosition -= 1;
			 grid.updateGrid(this.xPosition, this.yPosition, this.getCharacter());
		 }
		 else {
			 System.out.println("You cannot move further up.");
		 }
	 }
	 
	 public void moveDown(Grid grid) {
		 if (this.yPosition < (grid.getSize() - 1)) {
			 grid.updateGrid(this.xPosition, this.yPosition, " • ");
			 this.yPosition += 1;
			 grid.updateGrid(this.xPosition, this.yPosition, this.getCharacter());
		 }
		 else {
			 System.out.println("You cannot move further down.");
		 }
	 }
}