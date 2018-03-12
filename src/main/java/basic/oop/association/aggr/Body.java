package basic.oop.association.aggr;

import java.util.HashSet;
import java.util.Set;

public class Body {
	
	public Set<Cell> cells;
	
	public Body() {
		cells = new HashSet<Cell>();
	}
	
	public void addCells(Set<Cell> cells) {
		cells.addAll(cells);
	}
	
	public void printAllCells() {
		for (Cell cell : cells) {
			System.out.println(cell.getCellSize());
		}
	}

}
