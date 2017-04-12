package mino.core.randomizer;

import mino.core.piece.IPiece;
import mino.core.piece.JPiece;
import mino.core.piece.LPiece;
import mino.core.piece.OPiece;
import mino.core.piece.Piece;
import mino.core.piece.SPiece;
import mino.core.piece.TPiece;
import mino.core.piece.ZPiece;

public class Factory {

	public Piece create(char pieceIdentifier) {
		if (pieceIdentifier == 'I') {
			return new IPiece();
		} else if (pieceIdentifier == 'J') {
			return new JPiece();
		} else if (pieceIdentifier == 'L') {
			return new LPiece();
		} else if (pieceIdentifier == 'O') {
			return new OPiece();
		} else if (pieceIdentifier == 'S') {
			return new SPiece();
		} else if (pieceIdentifier == 'T') {
			return new TPiece();
		} else /* if (piece == 'Z') */ {
			return new ZPiece();
		}
	}
	
}
