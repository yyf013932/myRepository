public class SudokuTest {

	public static void main(String[] args) {
		Sudoku su = new Sudoku();
		for (int i = 1; i < 4; i++) {
			su.readData("data" + i + ".txt");
			long a = System.currentTimeMillis();
			su.calculate();
			long b = System.currentTimeMillis();
			su.printNodes();
			System.out.println("Test" + i + " Cost " + (b - a) / (double) 1000
					+ "s");
		}
	}
}
