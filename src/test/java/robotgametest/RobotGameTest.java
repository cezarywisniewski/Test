package robotgametest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import robotgame.Robot;
import robotgame.Direction;
import robotgame.GameArea;
import robotgame.GameGrid;
import robotgame.Position;

public class RobotGameTest {

	Robot robot;
	Position position;
	GameArea gameArea;

	@Before
	public void setUp() {
		robot = new Robot();
		position = new Position();
		gameArea = new GameGrid(5,5);
		position.setX(3);
		position.setY(2);
		position.setDirection(Direction.EAST);
	}

	@Test
	public void testRobotCreate() {
		assertTrue(robot != null);
	}

	@Test
	public void testRobotInit() {
		robot.init(position, gameArea);
		assertTrue(robot.getCurrentPosition().getX() == 3
				&& robot.getCurrentPosition().getY() == 2
				&& robot.getCurrentPosition().getDirection() == Direction.EAST);
	}

	@Test
	public void testRobotForward() {
		robot.init(position, gameArea);
		robot.forward(gameArea);
		assertTrue(robot.getCurrentPosition().getX() == 4);
	}

	@Test
	public void testRobotForwardOffTheTableFarEnd() {
		robot.init(position, gameArea);
		robot.forward(gameArea);
		robot.forward(gameArea);
		assertTrue(robot.getCurrentPosition().getX() == 4);
	}

	@Test
	public void testRobotForwardOffTheTableNearEnd() {
		robot.init(position, gameArea);
		robot.right();
		robot.right();
		robot.forward(gameArea);
		robot.forward(gameArea);
		robot.forward(gameArea);
		robot.forward(gameArea);
		assertTrue(robot.getCurrentPosition().getX() == 0);
	}

	@Test
	public void testRobotRight() {
		robot.init(position, gameArea);
		robot.right();
		assertTrue(robot.getCurrentPosition().getDirection() == Direction.SOUTH);
	}

	@Test
	public void testRobotLeft() {
		robot.init(position, gameArea);
		robot.left();
		assertTrue(robot.getCurrentPosition().getDirection() == Direction.NORTH);
	}

}
