package robotgame;

public abstract class Toy {

	public Toy() {
		super();
	}

	public abstract void left();

	public abstract void right();

	public abstract void forward(GameArea gameArea);

}