package basic.oop.dip.sort;

public class Computer {
	
	private SortSolution solution;
	
	public void setSortSolution(SortSolution solution) {
		this.solution = solution;
	}

	public void callSort() {
		solution.doSort();
	}
	
}
