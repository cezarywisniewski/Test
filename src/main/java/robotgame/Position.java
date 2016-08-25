package robotgame;

public class Position {

	int x;
	int y;
	Direction direction = Direction.NORTH;
	
	public Position(int x, int y, String direction) throws InvalidCommandException{
		if(isValidDirection(direction)){
			setX(x);
			setY(y);
			setDirection(direction);
		}else{
			throw new InvalidCommandException();
		}	
	}

	private boolean isValidDirection(String direction) {
		for (Direction c : Direction.values()) {
	        if (c.name().equals(direction)) {
	            return true;
	        }
	    }
	    return false;
	}

	public Position() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
			this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
			this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(String direction)  {
		this.direction = Direction.valueOf(direction);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Position clone(){
		Position clonedPos = new Position();
		clonedPos.setX(getX());
		clonedPos.setY(getY());
		clonedPos.setDirection(getDirection());
		return clonedPos;
	}
}
