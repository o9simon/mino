package mino.core.piece;

public class IPiece extends Piece {

	private int rotationState = 0;
	
	public IPiece() {
		super(new char[][]{
			{'I'},
			{'I'},
			{'I'},
			{'I'}
		}, 5, 0);
	}
	
	@Override
	public Piece clone() {
		Piece clone = new IPiece();
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
				{'I'},
				{'I'},
				{'I'},
				{'I'},
			});
		} else {
			setData(new char[][]{{'I','I','I','I'}});
		}
		
		rotationState = nextRotationState;
	}

}
