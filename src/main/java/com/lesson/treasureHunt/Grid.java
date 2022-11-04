package com.lesson.treasureHunt;

import java.lang.Math;

public class Grid {
	public String[][] coordinates;
	private int size;
	
	public void createGrid(int size) {
		this.size = size;
		coordinates = new String[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				coordinates[x][y] = " • ";
			}
		}
				
//		System.out.println(size + "*" + size + " grid generated...");
	}
	
	// Getter methods
	 public int getSize() {
		 return size;
	 }
	
	// Update Grid
	public void updateGrid(int x, int y, String unit) {
		coordinates[y][x] = unit;
	}
	
	// Show Grid
	public void showGrid(int size) {
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print(coordinates[x][y]);
			}
			System.out.println(" ");
		}
	}
	
	public void calculateDistance(Player p, Treasure t) {
		int pXPos = p.getXPosition();
		int pYPos = p.getYPosition();
		
		int tXPos = t.getXPosition();
		int tYPos = t.getYPosition();
		
		int calcX = pXPos - tXPos;
		int calcY = pYPos - tYPos;
		
		int absX = Math.abs(calcX);
		int absY = Math.abs(calcY);
		
		double absXsq = Math.pow(absX, 2);
		double absYsq = Math.pow(absY, 2);
		double distance = Math.sqrt(absXsq + absYsq);
		
		System.out.println(p.getName() + " is approximately " + Math.round(distance) + "m away from " + t.getName());
		
//		System.out.println("The distance between " + p.getName() + " and " + t.getName() + " is " + absX + " horizontally.");
//		System.out.println("The distance between " + p.getName() + " and " + t.getName() + " is " + absY + " vertically.");
	}
}

