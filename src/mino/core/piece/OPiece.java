package mino.core.piece;

public class OPiece extends Piece {

	public OPiece() {
		super(
			new char[][]{
				{'O','O'},
				{'O','O'},
			}
		, 5, 0);
	}

	@Override
	public Piece clone() {
		Piece clone = new OPiece();
		clone.setPosX(getPosX());
		clone.setPosY(getPosY());
		return clone;
	}

	@Override
	public void leftRotation() {
		// O pieces don't rotate.
	}

	@Override
	public void rightRotation() {
		// O pieces don't rotate.
	}

}
