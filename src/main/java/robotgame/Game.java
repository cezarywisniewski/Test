package robotgame;

import java.util.Scanner;

public class Game {

	public  void processUserInput(String userInput, Robot robot) {
		String params = "";
		String directionString;
		int x;
		int y;
		Position gps;
		GameArea drivingGrid = new GameGrid(5,5);
		String action;
		action = userInput.split(" ")[0];
		if(!validCommand(action)){
			return;
		}
		if (Command.PLACE == Command.valueOf(action)) {
			try {
				params = userInput.split(" ")[1];
			}catch(ArrayIndexOutOfBoundsException aoob){
				System.out.println("Invalid commnad: " + userInput);
				return;
			}
			if (params.split(",").length == 3) {
				try {
					x = Integer.parseInt(params.split(",")[0]);
					y = Integer.parseInt(params.split(",")[1]);
					directionString = params.split(",")[2];
					gps = new Position(x, y, directionString);
					if(drivingGrid.isValidPosition(gps)){
						robot.init(gps,drivingGrid);
					}else{
						throw new InvalidCommandException();
					}	
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid commnad: " + userInput);
				} catch (InvalidCommandException e) {
					//Ignore command;
				} catch(Exception any){
					System.out.println(any.getMessage());
				}
			}else{
				System.out.println("Invalid commnad: " + userInput);
			}
		} else if (Command.MOVE == Command.valueOf(action)) {
			robot.forward(drivingGrid);
		} else if (Command.RIGHT == Command.valueOf(action)) {
			robot.right();
		} else if (Command.LEFT == Command.valueOf(action)) {
			robot.left();
		} else if (Command.REPORT == Command.valueOf(action)) {
			robot.report();
		}
	}

	private boolean validCommand(String action) {
		try{
			Command.valueOf(action);
		}catch(IllegalArgumentException iae){
			return false;
		}
		return true;
	}

	public String takeInputFromUser(Scanner in) {
		String userInput;
		System.out.println("Enter a command or 'x' to exit: ");
		userInput = in.nextLine();
		return userInput;
	}

}
