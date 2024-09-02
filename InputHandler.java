package renderin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

enum Direction {
	UP, DOWN, LEFT, RIGHT, FORWARD, BACKWARD, C_UP, C_DOWN, C_LEFT, C_RIGHT
}

public class InputHandler implements KeyListener{

	private HashSet<Direction> keys;

	InputHandler() {
		keys = new HashSet<>();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 87 -> keyAdd(Direction.FORWARD); // W
		case 83 -> keyAdd(Direction.BACKWARD); // S
		case 65 -> keyAdd(Direction.LEFT); // A
		case 68 -> keyAdd(Direction.RIGHT); // D
		case 32 -> keyAdd(Direction.UP); // SPACE
		case 16 -> keyAdd(Direction.DOWN); // SHIFT
		
		case 37 -> keyAdd(Direction.C_LEFT); // left
		case 38 -> keyAdd(Direction.C_UP); // up
		case 39 -> keyAdd(Direction.C_RIGHT); // right
		case 40 -> keyAdd(Direction.C_DOWN); // down
		default -> {/* empty */}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 87 -> keys.remove(Direction.FORWARD); // W
		case 83 -> keys.remove(Direction.BACKWARD); // S
		case 65 -> keys.remove(Direction.LEFT); // A
		case 68 -> keys.remove(Direction.RIGHT); // D
		case 32 -> keys.remove(Direction.UP); // SPACE
		case 16 -> keys.remove(Direction.DOWN); // SHIFT
		
		case 37 -> keys.remove(Direction.C_LEFT); // left
		case 38 -> keys.remove(Direction.C_UP); // up
		case 39 -> keys.remove(Direction.C_RIGHT); // right
		case 40 -> keys.remove(Direction.C_DOWN); // down

		default -> {/* empty */}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/* Not needed */}

	private void keyAdd(Direction x) {
		if (!keys.contains(x)) {
			keys.add(x);
		}
	}

	public HashSet<Direction> getKeys() {
		return new HashSet<>(keys);	//ConcurrentModificationExceptions
	}
}
