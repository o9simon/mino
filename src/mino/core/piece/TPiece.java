package mino.core.piece;

public class TPiece extends Piece {

	private int rotationState = 0;
	
	public TPiece() {
		super(new char[][]{
			{'T','X'},
			{'T','T'},
			{'T','X'}
		}, 5, 0);
	}
	
	@Override
	public Piece clone() {
		Piece clone = new TPiece();
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
	
	public void rotation(int nextRotationState) {
		if (nextRotationState == 0) {
			setData(new char[][]{
				{'T','X'},
				{'T','T'},
				{'T','X'}
			});
		} else if (nextRotationState == 1) {
			setData(new char[][]{
				{'X','T','X'},
				{'T','T','T'}
			});
		} else if (nextRotationState == 2) {
			setData(new char[][]{
				{'X','T'},
				{'T','T'},
				{'X','T'}
			});
		} else if (nextRotationState == 3) {
			setData(new char[][]{
				{'T','T','T'},
				{'X','T','X'}
			});
		}
		
		rotationState = nextRotationState;
	}
}
