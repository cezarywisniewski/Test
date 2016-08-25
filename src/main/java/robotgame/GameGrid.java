package robotgame;

public class GameGrid extends Area implements GameArea {
	private int columns;
	private int rows;
	
	public GameGrid(int columns, int rows) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public boolean isValidPosition(Position position){
		if(position.getX() < 0 || position.getX() >= rows ){
			return false;
		}
		if(position.getY() < 0 || position.getY() >= columns ){
			return false;
		}
		return true;
		
	}
}
