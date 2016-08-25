package robotgame;

public class Robot extends Toy {

	private Position position = null;
	private Position lastPos = null;

	public Position getCurrentPosition() {
		return position;
	}

	@Override
	public void forward(GameArea gameArea) {
		lastPos = position.clone();
		if (position != null) {
			if (position.getDirection() == Direction.NORTH) {
				position.setY(position.getY() + 1);
			} else if (position.getDirection() == Direction.SOUTH) {
				position.setY(position.getY() - 1);
			} else if (position.getDirection() == Direction.EAST) {
				position.setX(position.getX() + 1);
			} else {
				position.setX(position.getX() - 1);
			}
			if(!isValidPosition(gameArea)){
				position = lastPos;
			}
		}
	}

	@Override
	public void right() {
		if (position != null) {
			if (position.getDirection() == Direction.NORTH) {
				position.setDirection(Direction.EAST);
			} else if (position.getDirection() == Direction.SOUTH) {
				position.setDirection(Direction.WEST);
			} else if (position.getDirection() == Direction.EAST) {
				position.setDirection(Direction.SOUTH);
			} else {
				position.setDirection(Direction.NORTH);
			}
		}
	}

	@Override
	public void left() {
		if (position != null) {
			if (position.getDirection() == Direction.NORTH) {
				position.setDirection(Direction.WEST);
			} else if (position.getDirection() == Direction.SOUTH) {
				position.setDirection(Direction.EAST);
			} else if (position.getDirection() == Direction.EAST) {
				position.setDirection(Direction.NORTH);
			} else {
				position.setDirection(Direction.SOUTH);
			}
		}
	}

	public void report() {
		if (position != null) {
			System.out.println(position.getX() + "," + position.getY()
					+ "," + position.getDirection());
		}

	}
	
	private boolean isValidPosition(GameArea gameArea){
		return gameArea.isValidPosition(position);
	}

	public void init(Position gps, GameArea gameArea) {
		lastPos = position;
		position = gps;
		if(!isValidPosition(gameArea)){
			position = lastPos;
		}
	}

}
