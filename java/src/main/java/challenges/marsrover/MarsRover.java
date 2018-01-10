package challenges.marsrover;

public class MarsRover {

	private Position position;

	public MarsRover(Position position) {
		this.position = position;
	}

	public void move(String instructionStr) {
		char[] instructions = instructionStr.toCharArray();
		for (char instruction : instructions) {
			switch (instruction) {
			case 'L':
				position.setDirection(Direction.leftOf(position.getDirection()));
				break;
			case 'R':
				position.setDirection(Direction.rightOf(position.getDirection()));
				break;
			case 'M':
				position.setCoordinates(getUpdatedCoordinates(position));
				break;
			default:
				throw new RuntimeException("Invalid instruction: " + instruction);
			}
		}
	}

	private Tuple getUpdatedCoordinates(Position position) {
		Tuple coordinates = position.getCoordinates();
		int roverX = coordinates.getX();
		int roverY = coordinates.getY();
		Direction direction = position.getDirection();
		switch (direction) {
		case E:
			if(roverX < MarsRoverMain.gridSize.getX()) roverX++;
			break;
		case N:
			if(roverY < MarsRoverMain.gridSize.getY()) roverY++;
			break;
		case W:
			if(roverX > 0) roverX--;
			break;
		case S:
			if(roverY > 0) roverY--;
			break;
		default:
			throw new RuntimeException("Invalid direction: "+direction);
		}
		return new Tuple(roverX, roverY);
	}

	public String toString() {
		return new StringBuilder().append(position.getCoordinates().getX()).append(" ")
				.append(position.getCoordinates().getY()).append(" ").append(position.getDirection()).append(" ")
				.toString();
	}

}
