import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class SodukoManipulation {
	
	public static int squareSize = 3;
	
	//Precondtion: Sodukoen er firkantet
	public static void print(int[][] sudoku) {
		
		for(int i = 0; i < 9; i ++) {
			System.out.println();
			if (i % 3 == 0 && i != 0) {
				for(int k = 0; k < 21; k++)
					System.out.print("-");
				System.out.println();
			}
			for(int j = 0; j < 9; j ++){
				if (j % 3 == 0 && j != 0)
					System.out.print("|" + " ");
				System.out.print(sudoku[i][j] + " ");
				
			}
		}
	}
	
	public static int[][] importSoduko() {
		Scanner keyboard = new Scanner(System.in);
		int[][] sudokuLoad = new int[squareSize*squareSize][squareSize*squareSize];
		boolean fileNotFound = false;

		do{
			System.out.println("Please enter the filename of the Sudoku. ");
			fileNotFound = false;
			try{
				FileReader file = new FileReader(keyboard.nextLine());
				Scanner loader = new Scanner(file);
				
			
				for(int i = 0; i < squareSize*squareSize; i ++){
					for(int j = 0; j < squareSize*squareSize; j ++){
						sudokuLoad[i][j] = loader.nextInt();
					}
				}
			}catch(FileNotFoundException e){
				System.out.println("The entered filename does not exist.");
				fileNotFound = true;
			}catch(InputMismatchException e){
				System.out.println("The file is not formatted correctly.");
				System.exit(0);
			}catch(NoSuchElementException e){
				System.out.println("The file is not formatted correctly.");
				System.exit(0);
			}
		}while(fileNotFound);
		

		return sudokuLoad;
	
	}
	
}