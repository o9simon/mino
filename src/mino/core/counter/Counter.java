package mino.core.counter;

public class Counter {

	private int currentFrame = 0;
	private int targetFrame = 10;
	
	public void setTargetFrame(int targetFrame) {
		this.reset();
		this.targetFrame = targetFrame;
	}
	
	public void update() {
		currentFrame++;
	}
	
	public void reset() {
		currentFrame = 0;
	}
	
	// If allowed, the counter resets itself to zero.
	// It's not required to call reset() manually.
	public boolean allowed() {
		if (currentFrame >= targetFrame) {
			reset();
			return true;
		} else {
			return false;
		}
	}
	
}
