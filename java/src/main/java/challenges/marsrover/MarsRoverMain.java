package challenges.marsrover;

public class MarsRoverMain {
	
	public static Tuple gridSize;

	public static void main(String[] args){
		try {
			gridSize = CommandLineInterface.getGridSize();
			Position position;
			String instructions;
			while(true){
				position = CommandLineInterface.getInitialPosition();
				instructions = CommandLineInterface.getInstructions();
				MarsRover marsRover = new MarsRover(position);
				marsRover.move(instructions);
				System.out.print(marsRover);
			}
		} catch (InputEnded e) {
			System.out.println("Thank you for navigating Mars Rover using Java");
		}
	}
}


















