package mino.core.piece;

public class LPiece extends Piece {

	private int rotationState = 0;
	
	public LPiece() {
		super(
			new char[][]{
				{'L','X'},
				{'L','X'},
				{'L','L'}
			}
		, 5, 0);
	}
	
	@Override
	public Piece clone() {
		Piece clone = new LPiece();
		clone.setData(getData());
		clone.setPosX(getPosX());
		clone.setPosY(getPosY());
		return clone;
	}

	@Override
	public void leftRotation() {
		if (rotationState > 0) {
			rotation(rotationState - 1);
		} else {
			rotation(3);
		}
	}

	@Override
	public void rightRotation() {
		if (rotationState < 3) {
			rotation(rotationState + 1);
		} else {
			rotation(0);
		}
	}
	
	private void rotation(int nextRotationState) {
		if (nextRotationState == 0) {
			setData(new char[][]{
				{'X','X','L'},
				{'L','L','L'}
			});
		} else if (nextRotationState == 1) {
			setData(new char[][]{
				{'L','L'},
				{'X','L'},
				{'X','L'}
			});
		} else if (nextRotationState == 2) {
			setData(new char[][]{
				{'L','L','L'},
				{'L','X','X'}
			});
		} else if (nextRotationState == 3) {
			setData(new char[][]{
				{'L','X'},
				{'L','X'},
				{'L','L'}
			});
		}
		
		rotationState = nextRotationState;
	}

}
