package robotgame;

import java.util.Scanner;

public class GameApp {

	public static void main(String[] args) {
		
		String userInput = "";
		Robot robot = new Robot();
		Game game = new Game();
		Scanner in = new Scanner(System.in);
		boolean placed = false;
		do {
			userInput = game.takeInputFromUser(in);
			if (userInput.length() > 0 ) {
				if(placed || userInput.indexOf(Command.PLACE.toString()) > -1) {
					game.processUserInput(userInput, robot);
					placed = true;
				}
			}
		}while(!userInput.equalsIgnoreCase(Command.EXIT.toString()));
		in.close();

	}
	
}
