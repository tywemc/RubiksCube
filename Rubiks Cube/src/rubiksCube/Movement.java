package rubiksCube;

import java.util.Random;

/**
 * class for rotating a side of the cube
 */
public class Movement {

	private RubiksCube cube;

	public Movement(RubiksCube cube) {
		this.cube = cube;
	}

	public void rTurn(boolean prime) {
		cube.colorChange(27, 29, 35, 33, !prime); // face corners
		cube.colorChange(28, 32, 34, 30, !prime); // face edges
		cube.colorChange(24, 51, 38, 6, !prime); // side corners1
		cube.colorChange(25, 52, 37, 7, !prime); // side edges
		cube.colorChange(26, 53, 36, 8, !prime); // side corners2
	}

	public void lTurn(boolean prime) {
		cube.colorChange(9, 11, 17, 15, !prime); // face corners
		cube.colorChange(10, 14, 16, 12, !prime); // face edges
		cube.colorChange(42, 47, 20, 2, !prime); // side corners1
		cube.colorChange(43, 46, 19, 1, !prime); // side edges
		cube.colorChange(44, 45, 18, 0, !prime); // side corners2
	}

	public void fTurn(boolean prime) {
		cube.colorChange(18, 20, 26, 24, !prime); // face corners
		cube.colorChange(19, 23, 25, 21, !prime); // face edges
		cube.colorChange(15, 45, 29, 8, !prime); // side corners1
		cube.colorChange(16, 48, 28, 5, !prime); // side edges
		cube.colorChange(17, 51, 27, 2, !prime); // side corners2
	}

	public void dTurn(boolean prime) {
		cube.colorChange(45, 47, 53, 51, !prime); // face corners
		cube.colorChange(46, 50, 52, 48, !prime); // face edges
		cube.colorChange(17, 44, 35, 26, !prime); // side corners1
		cube.colorChange(14, 41, 32, 23, !prime); // side edges
		cube.colorChange(11, 38, 29, 20, !prime); // side corners2
	}

	public void uTurn(boolean prime) {
		cube.colorChange(0, 2, 8, 6, !prime); // face corners
		cube.colorChange(1, 5, 7, 3, !prime); // face edges
		cube.colorChange(9, 18, 27, 36, !prime); // side corners1
		cube.colorChange(12, 21, 30, 39, !prime); // side edges
		cube.colorChange(15, 24, 33, 42, !prime); // side corners2
	}

	public void bTurn(boolean prime) {
		cube.colorChange(36, 38, 44, 42, !prime); // face corners
		cube.colorChange(37, 41, 43, 39, !prime); // face edges
		cube.colorChange(33, 53, 11, 0, !prime); // side corners1
		cube.colorChange(34, 50, 10, 3, !prime); // side edges
		cube.colorChange(35, 47, 9, 6, !prime); // side corners2
	}

	public void scramble() {
		Random rand = new Random();
		int turns = rand.nextInt(50) + 50;

		for (int i = 0; i < turns; i++) {
			int move = rand.nextInt() % 6;
			boolean prime = rand.nextBoolean();
			if (move == 0) {
				rTurn(prime);
			} else if (move == 1) {
				lTurn(prime);
			} else if (move == 2) {
				fTurn(prime);
			} else if (move == 3) {
				dTurn(prime);
			} else if (move == 4) {
				uTurn(prime);
			} else if (move == 5) {
				bTurn(prime);
			}
		}

	}

}
