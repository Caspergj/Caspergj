import java.util.Arrays;
public class SodukoSolver {
	
	public static void main (String[] args) {
		
		int[][] soduko = SodukoManipulation.importSoduko();
		SodukoManipulation.print(soduko);
		
		long startTime = System.nanoTime();
		int[][] solvedSoduko = solveSoduko(soduko);
		long endTime = System.nanoTime();
		double executionTime = endTime - startTime;
		System.out.println();
		SodukoManipulation.print(solvedSoduko);
		System.out.println();
		System.out.println();
		System.out.println(executionTime/1000000000 + " s");
		
	}
	//Logic to actually solve the sudoku
	public static int[][] solveSoduko(int[][] inputSudoku) {
		
		int[][] outputSudoku = new int[9][9];
		for(int k = 0; k < 9; k++)
			for(int l = 0; l < 9; l++)
				outputSudoku[k][l] = inputSudoku[k][l];
		
		int counter = 0;
		int i = counter / 9;
		int j = counter % 9;
		int currentNumber = 1;
		boolean numberIsSet = false;
		while(counter < 81) {
				numberIsSet = false;
				if(inputSudoku[i][j] != 0) { //hvis tallet står i den oprindelige sudoku
					counter = counter + 1;
					i = counter / 9;
					j = counter % 9;
				}
				else {
					currentNumber = outputSudoku[i][j] + 1;
					while(currentNumber < 10 && !numberIsSet) {
						if(!SodukoLogic.isInRow(currentNumber, i, outputSudoku) && !SodukoLogic.isInColumn(currentNumber, j, outputSudoku) && !SodukoLogic.isInSquare(currentNumber, i, j, outputSudoku)) {
							outputSudoku[i][j] = currentNumber;
							numberIsSet = true;
							counter = counter + 1;
							i = counter / 9;
							j = counter % 9;
							}
							currentNumber = currentNumber + 1;
						}
						if(!numberIsSet) {
							outputSudoku[i][j] = 0;
							counter = counter - 1;
							i = counter / 9;
							j = counter % 9;
							while(inputSudoku[i][j] != 0) {
							counter = counter - 1;
							i = counter / 9;
							j = counter % 9;
							}
						}
				}
		}
		return outputSudoku;
	}
}