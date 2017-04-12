package mino.core.piece;

public abstract class Piece {
	
	// This point refers to the top left corner
	private int posX;
	private int posY;

	private char[][] data;
	
	public Piece(char[][] data, int startingPosX, int startingPosY) {
		this.data = data;
		this.posX = startingPosX;
		this.posY = startingPosY;
	}
	
	public abstract Piece clone();
	public abstract void leftRotation();
	public abstract void rightRotation();
	
	protected void setData(char[][] data) {
		this.data = data;
	}
	
	protected char[][] getData() {
		return data;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public char getData(int x, int y) {
		return data[y][x];
	}
	
	public void down() {
		posY += 1;
	}
	
	public void right() {
		posX += 1;
	}
	
	public void left() {
		posX -= 1;
	}
	
	public int getWidth() {
		return this.data[0].length;
	}
	
	public int getHeight() {
		return this.data.length;
	}
	
	
}
