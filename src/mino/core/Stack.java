package mino.core;

import mino.core.piece.Piece;

public class Stack {
	
	public final static short GRID_HEIGHT = 24;
	public final static short GRID_WIDTH = 10;
	
	private char[][] stack = new char[GRID_HEIGHT][GRID_WIDTH];
	
	public Stack() {
		for (int y = 0; y < GRID_HEIGHT; y++) {
			for (int x = 0; x < GRID_WIDTH; x++) {
				stack[y][x] = 'X';
			}
		}
	}
	
	public char getData(int x, int y) {
		return stack[y][x];
	}
	
	public void add(Piece piece) {
		int ppx = piece.getPosX();
		int ppy = piece.getPosY();
		
		for (int y = 0; y < piece.getHeight(); y++) {
			for (int x = 0; x < piece.getWidth(); x++) {
				if (piece.getData(x, y) != 'X') {
					stack[ppy + y][ppx + x] = piece.getData(x, y);
				}
			}
		}
		
		lineClear();
	}
	
	public void lineClear() {
		boolean isClear = true;
		for (int y = 0; y < GRID_HEIGHT; y++) {
			isClear = true;
			
			for (int x = 0; x < GRID_WIDTH; x++) {
				if (stack[y][x] == 'X')
					isClear = false;
			}
			
			if (isClear) {
				//removeLine(y);
			}
		}
	}
	
	private void removeLine(int y) {
		for (int x = 0; x < GRID_WIDTH; x++) {
			stack[y][x] = 'X';
		}
	}

}
