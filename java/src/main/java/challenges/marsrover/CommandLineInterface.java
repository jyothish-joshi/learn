package challenges.marsrover;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineInterface {
	
	private static final String STR_PATTERN_GRID_SIZE = "(\\d)\\s+(\\d)";
	private static final String STR_PATTERN_INITIAL_POSITION = "(\\d\\s+\\d)\\s+(E|W|N|S)";
	private static final String STR_PATTERN_INSTRUCTIONS = "(L|R|M)+";
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static Tuple getGridSize() throws InputEnded{
		String input = getInput();
		return getTuple(input);
	}
	
	public static Tuple getTuple(String input){
		int sizeX, sizeY;
		Pattern pattern = Pattern.compile(STR_PATTERN_GRID_SIZE);
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()){
			sizeX = Integer.parseInt(matcher.group(1));
			sizeY = Integer.parseInt(matcher.group(2));
		} else {
			throw new RuntimeException("Invalid tuple format: "+input);
		}
		return new Tuple(sizeX, sizeY);
	}
	
	public static Position getInitialPosition() throws InputEnded{
		String input = getInput();
		Tuple tuple;
		Pattern pattern = Pattern.compile(STR_PATTERN_INITIAL_POSITION);
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()){
			tuple = getTuple(matcher.group(1));
		} else {
			throw new RuntimeException("Invalid Position format: "+input);
		}
		return new Position(tuple,Direction.valueOf(matcher.group(2)));
	}
	
	public static String getInstructions() throws InputEnded{
		String input = getInput();
		Pattern pattern = Pattern.compile(STR_PATTERN_INSTRUCTIONS);
		Matcher matcher = pattern.matcher(input);
		if(!matcher.find()){
			throw new RuntimeException("Invalid Instruction format: "+input);
		}
		return input;
	}
	
	private static String getInput() throws InputEnded{
		String input = scanner.nextLine();
		if(input.equals("")){
			scanner.close();
			throw new InputEnded();
		}
		return input;
	}
}
