package mino.core.piece;

public class SPiece extends Piece {

	private int rotationState = 0;
	
	public SPiece() {
		super(new char[][]{
			{'X','S','S'},
			{'S','S','X'}
		}, 5, 0);
	}
	
	@Override
	public Piece clone() {
		Piece clone = new SPiece();
		clone.setData(getData());
		clone.setPosX(getPosX());
		clone.setPosY(getPosY());
		return clone;
	}

	@Override
	public void leftRotation() {
		if (rotationState == 0) {
			rotation(1);
		} else {
			rotation(0);
		}
	}

	@Override
	public void rightRotation() {
		if (rotationState == 0) {
			rotation(1);
		} else {
			rotation(0);
		}
	}

	private void rotation(int nextRotationState) {
		if (nextRotationState == 0) {
			setData(new char[][]{
				{'X','S','S'},
				{'S','S','X'}
			});
		} else if (nextRotationState == 1) {
			setData(new char[][]{
				{'S','X'},
				{'S','S'},
				{'X','S'}
			});
		}
		
		rotationState = nextRotationState;
	}
	
}
