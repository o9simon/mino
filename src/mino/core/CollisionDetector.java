package mino.core;

import mino.core.piece.Piece;

public class CollisionDetector {

	/**
	 * Check if a piece can go left.
	 * 
	 * @param stack
	 * @param piece 
	 * @return boolean
	 */
	public boolean left(Stack stack, Piece piece) {
		Piece clone = piece.clone();
		clone.left();
		
		int ppx = clone.getPosX();
		int ppy = clone.getPosY();
		int pieceHeight = clone.getHeight();
		int pieceWidth = clone.getWidth();

		if (ppx < 0) {
			return true;
		}
			
		for (int y = 0; y < pieceHeight; y++) {
			for (int x = 0; x < pieceWidth; x++) {
				if (clone.getData(x, y) != 'X' && stack.getData(ppx + x, ppy + y) != 'X') {
					return true;
				}	
			}		
		}
		
		return false;
	}
	
	/**
	 * Check if a piece can go right.
	 * 
	 * @param stack
	 * @param piece 
	 * @return boolean
	 */
	public boolean right(Stack stack, Piece piece) {
		Piece clone = piece.clone();
		clone.right();
		
		int ppx = clone.getPosX();
		int ppy = clone.getPosY();
		int pieceHeight = clone.getHeight();
		int pieceWidth = clone.getWidth();

		if (ppx + pieceWidth > Stack.GRID_WIDTH) {
			return true;
		}
			
		for (int y = 0; y < pieceHeight; y++) {
			for (int x = 0; x < pieceWidth; x++) {
				if (clone.getData(x, y) != 'X' && stack.getData(ppx + x, ppy + y) != 'X') {
					return true;
				}	
			}		
		}
		
		return false;
	}
	
	/**
	 * Check if a piece can go down.
	 * 
	 * @param stack
	 * @param piece 
	 * @return boolean
	 */
	public boolean down(Stack stack, Piece piece) {
		Piece clone = piece.clone();
		clone.down();
		
		int ppx = clone.getPosX();
		int ppy = clone.getPosY();
		int pieceWidth = clone.getWidth();
		int pieceHeight = clone.getHeight();
		
		if (ppy + pieceHeight > Stack.GRID_HEIGHT) {
			return true;
		}
		
		for (int y = 0; y < pieceHeight; y++) {
			for (int x = 0; x < pieceWidth; x++) {
				if (clone.getData(x, y) != 'X' && stack.getData(ppx + x, ppy + y) != 'X') {
					return true;
				}	
			}		
		}
		
		return false;
	}
	
	/**
	 * Check if the piece can rotate left. Only the collision with the stack are
	 * detected. Collisions with the walls should be avoided by changing the
	 * position of the piece depending on its position in the grid.
	 * 
	 * @param stack
	 * @param piece
	 * @return boolean
	 */
	public boolean leftRotation(Stack stack, Piece piece) {
		Piece clone = piece.clone();
		clone.leftRotation();
		
		int ppx = clone.getPosX();
		int ppy = clone.getPosY();
		int pieceWidth = clone.getWidth();
		int pieceHeight = clone.getHeight();

		for (int y = 0; y < pieceHeight; y++) {
			for (int x = 0; x < pieceWidth; x++) {
				if (clone.getData(x, y) != 'X' && stack.getData(ppx + x, ppy + y) != 'X') {
					return true;
				}	
			}		
		}
		
		return false;
	}
	
	/**
	 * Check if the piece can rotate right. Only the collision with the stack are
	 * detected. Collisions with the walls should be avoided by changing the
	 * position of the piece depending on its position in the grid.
	 * 
	 * @param stack
	 * @param piece
	 * @return boolean
	 */
	public boolean rightRotation(Stack stack, Piece piece) {
		Piece clone = piece.clone();
		clone.rightRotation();
		
		int ppx = clone.getPosX();
		int ppy = clone.getPosY();
		int pieceWidth = clone.getWidth();
		int pieceHeight = clone.getHeight();

		for (int y = 0; y < pieceHeight; y++) {
			for (int x = 0; x < pieceWidth; x++) {
				if (clone.getData(x, y) != 'X' && stack.getData(ppx + x, ppy + y) != 'X') {
					return true;
				}	
			}		
		}
		
		return false;
	}
	
}
