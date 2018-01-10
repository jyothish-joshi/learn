package challenges.marsrover;

public enum Direction {
	E,S,W,N;
	
	public static Direction leftOf(Direction direction){
		Direction returnDirection;
		int inputDirectionOrdinal = direction.ordinal();
		if(inputDirectionOrdinal <= 0){
			returnDirection = N;
		} else {
			returnDirection = Direction.values()[inputDirectionOrdinal-1];
		}
		return returnDirection;
	}
	
	public static Direction rightOf(Direction direction){
		Direction returnDirection;
		int inputDirectionOrdinal = direction.ordinal();
		if(inputDirectionOrdinal >= 3){
			returnDirection = E;
		} else {
			returnDirection = Direction.values()[inputDirectionOrdinal+1];
		}
		return returnDirection;
	}
}
