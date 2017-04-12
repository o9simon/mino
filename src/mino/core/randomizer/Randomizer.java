package mino.core.randomizer;

import java.util.Random;

import mino.core.piece.Piece;

/**
 * The piece randomizer is a mix between the randomizer of TGM1 and the randomizer of TGM2.
 * This is not a 100% accurate port of the TGM randomizer.
 * 
 * For more information :
 * http://tetris.wikia.com/wiki/TGM_randomizer
 */
public class Randomizer {
	
	private char[] pieces = new char[]{'I','J','L','O','S','T','Z'};
	private boolean first = true;
	private Random rand = new Random();
	private History history = new History();
	private Factory factory = new Factory();

	public Piece getCurrent() {
		return factory.create(history.getNext());
	}
	
	public Piece getNext() {
		return factory.create(history.getNext());
	}
	
	public void generate() {
		char randPiece = randPiece();
		
		// Each time a piece is generated, the game will try a certain number of times
		// to generate a tetromino that doesn't match any in the history. TGM1 uses 4 tries.
		int tries = 1;
		while (history.has(randPiece) || tries < 4) {
			randPiece = randPiece();
			tries++;
		}
		
		history.push(randPiece);

		// On the first pass, push a new tetromino that will become the current piece.
		if (first) {
			// The game never deals an S, Z or O as the first piece, to avoid a forced
			// overhang.
			while (randPiece == 'S' || randPiece == 'Z' || randPiece == 'O') {
				randPiece = randPiece();
			}
			
			history.push(randPiece);
			first = false;
		}
	}
	
	private char randPiece() {
		return pieces[rand.nextInt(pieces.length)];
	}
	
}
