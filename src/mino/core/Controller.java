package mino.core;

import mino.core.counter.MoveCounter;
import mino.core.counter.RotationCounter;
import mino.core.piece.Piece;
import mino.core.randomizer.Randomizer;
import mino.core.counter.DownCounter;
import mino.core.counter.GravityCounter;

public class Controller {
	
	private Randomizer randomizer = new Randomizer();
	private CollisionDetector collision = new CollisionDetector();
	
	private Stack stack = new Stack();
	private Piece piece;
	
	private MoveCounter move = new MoveCounter();
	private DownCounter down = new DownCounter();
	private GravityCounter gravity = new GravityCounter();
	private RotationCounter rotation = new RotationCounter();
	
	public Controller() {
		randomizer.generate();
		piece = randomizer.getCurrent();
	}
	
	public char getData(int x, int y) {
		int ppx = piece.getPosX();
		int ppy = piece.getPosY();
		char tmp;
		
		if (x >= ppx && x < ppx + piece.getWidth() && y >= ppy && y < ppy + piece.getHeight()) {
			tmp = piece.getData(x - ppx, y - ppy);
			if (tmp != 'X') {
				return tmp;
			} else {
				return stack.getData(x, y);
			}
		} else {
			return stack.getData(x, y);
		}
	}
	
	public void down() {
		gravity.reset();
		
		if (down.allowed()) {
			if (collision.down(stack, piece)) {
				stack.add(piece);
				randomizer.generate();
				piece = randomizer.getCurrent();
			} else {
				piece.down();
			}
		}
	}
	
	public void left() {
		if (move.allowed()) {
			if (collision.down(stack, piece)) {
				stack.add(piece);
				randomizer.generate();
				piece = randomizer.getCurrent();
			} else if (!collision.left(stack, piece)) {
				piece.left();
			}
		}
	}
	
	public void right() {
		if (move.allowed()) {
			if (collision.down(stack, piece)) {
				stack.add(piece);
				randomizer.generate();
				piece = randomizer.getCurrent();
			} else if (!collision.right(stack, piece)) {
				piece.right();
			}
		}
	}
	
	public void leftRotation() {
		if (rotation.allowed()) {
			if (collision.down(stack, piece)) {
				stack.add(piece);
				randomizer.generate();
				piece = randomizer.getCurrent();
			} else if (!collision.leftRotation(stack, piece)) {
				piece.leftRotation();
			}
		}
	}
	
	public void rightRotation() {
		if (rotation.allowed()) {
			if (collision.down(stack, piece)) {
				stack.add(piece);
				randomizer.generate();
				piece = randomizer.getCurrent();
			} else if (!collision.rightRotation(stack, piece)) {
				piece.rightRotation();
			}
		}
	}
	
	public void update() {
		move.update();
		down.update();
		rotation.update();
		gravity.update();
		
		if (gravity.allowed()) {
			piece.down();
		}
	
	}
	
}
