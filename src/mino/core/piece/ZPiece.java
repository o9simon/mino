package mino.core.piece;

public class ZPiece extends Piece {

	private int rotationState = 0;
	
	public ZPiece() {
		super(new char[][]{
			{'Z','Z','X'},
			{'X','Z','Z'}
		}, 5, 0);
	}
	
	@Override
	public Piece clone() {
		Piece clone = new ZPiece();
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
				{'Z','Z','X'},
				{'X','Z','Z'}
			});
		} else if (nextRotationState == 1) {
			setData(new char[][]{
				{'X','Z'},
				{'Z','Z'},
				{'Z','X'}
			});
		}
		
		rotationState = nextRotationState;
	}

}
