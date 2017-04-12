package mino.core.randomizer;

public class History {

	// Start with a history containing 2 Z pieces and 2 S pieces.
	// Similar to TGM2, but in a different order. This makes more
	// sense since the current piece is also in the history, therefore
	// on the first pass, the first 2 items are modified.
	private char[] history = new char[]{'Z','S','Z','S'};
	
	public void push(char pieceIdentifier) {
		history[3] = history[2];
		history[2] = history[1];
		history[1] = history[0];
		history[0] = pieceIdentifier;
		
		System.out.println("4th:" + history[3] + " 3rd:" + history[2] + " next:" + history[1] + " curr:" + history[0]);
	}
	
	public boolean has(char pieceIdentifier) {
		for (int i = 0; i < history.length /*4*/; i++) {
			if (history[i] == pieceIdentifier) {
				return true;
			}
		}
		return false;
	}
	
	public char getCurrent() {
		return history[0];
	}
	
	public char getNext() {
		return history[1];
	}
	
}
