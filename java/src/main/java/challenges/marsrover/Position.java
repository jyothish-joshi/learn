package challenges.marsrover;

public class Position {
	private Tuple coordinates;
	private Direction direction;
	
	public Position(Tuple coordinates, Direction direction){
		this.coordinates = coordinates;
		this.direction = direction;
	}
	
	public Tuple getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Tuple coordinates) {
		this.coordinates = coordinates;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public String toString(){
		return new StringBuilder()
				.append("[")
				.append(coordinates)
				.append(",")
				.append(direction)
				.append("]")
				.toString();
	}
}
