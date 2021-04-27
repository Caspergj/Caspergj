public class SodukoLogic {
	
	//Takes a number, a row, and a soduko and checks if the number is in that row
	public static boolean isInRow(int number, int row, int[][] soduko) {
		boolean isInRow = false;
		int i = 0;
		while (i < 9 && !isInRow) {
			if(soduko[row][i] == number)
				isInRow = true;
			i++;
		}
		return isInRow;
	}
	
	public static boolean isInColumn(int number, int column, int[][] soduko) {
		boolean isInColumn = false;
		int i = 0;
		while (i < 9 && !isInColumn) {
			if(soduko[i][column] == number)
				isInColumn = true;
			i++;
		}
		return isInColumn;
	}
	
	public static boolean isInSquare(int number, int row, int column, int[][] soduko) {
		boolean isInSquare = false;
		int rowScale = row / 3;
		int columnScale = column / 3;
		
		for(int i = 0; i < 3; i++)
			for( int j = 0; j < 3; j++)
				if(soduko[i + (rowScale * 3)][j + (columnScale * 3)] == number)
					isInSquare = true;
		return isInSquare;
	}
	
}