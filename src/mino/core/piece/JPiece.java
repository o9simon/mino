package mino.core.piece;

public class JPiece extends Piece {
	
	private int rotationState = 0;
	
	public JPiece() {
		super(
			new char[][]{
				{'X','J'},
				{'X','J'},
				{'J','J'}
			}
		, 5, 0);
	}
	
	@Override
	public Piece clone() {
		Piece piece = new LPiece();
		piece.setData(getData());
		piece.setPosX(getPosX());
		piece.setPosY(getPosY());
		return piece;
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
				{'J','J','J'},
				{'X','X','J'}
			});
		} else if (nextRotationState == 1) {
			setData(new char[][]{
				{'J','J'},
				{'J','X'},
				{'J','X'}
			});
		} else if (nextRotationState == 2) {
			setData(new char[][]{
				{'J','X','X'},
				{'J','J','J'}
			});
		} else if (nextRotationState == 3) {
			setData(new char[][]{
				{'X','J'},
				{'X','J'},
				{'J','J'}
			});
		}
		
		rotationState = nextRotationState;
	}
	
}
