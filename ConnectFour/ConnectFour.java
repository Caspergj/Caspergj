/*
** This program is a Java-model og the board game ConnectFour
** The game lacks input-control and draw-logic. Could be added later
*/
import java.util.Scanner;
public class ConnectFour {

	public static Scanner keyboard = new Scanner(System.in);
	public static int height = 6;
	public static int length = 7;
	public static int[][] board = new int[height][length];
	public static boolean isPlayer1 = true;
	public static boolean theGameIsOver = false;
	public static int winningLength = 4;			//Can be changed to play Connect(insert number here)
	
	public static void main (String[] args) {
		
		while(!theGameIsOver) {
			visualize();
			play();
			if (gameCheck() == 1) {
				visualize();
				System.out.println("Congratulations player 1 - You have won the game!");
				theGameIsOver = true;
			}
			else if (gameCheck() == 2) {
				visualize();
				System.out.println("Congratulations player 2 - You have won the game!");
				theGameIsOver = true;
			}	
		}
	}
	
	private static void visualize() {
		
		for(int k = 1; k < length + 1; k++)
			System.out.print(k + " ");
		System.out.println();
		for(int i = 0; i < height; i++) {
			System.out.println();
			for(int j = 0; j < length; j++)
				System.out.print(board[i][j] + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void play() {
		
		//Takes user input
		if (isPlayer1)
			System.out.print("Where do you want to play player 1?: ");
		else
			System.out.print("Where do you want to play player 2?: ");
		int playCollum = keyboard.nextInt(); 
		
		//Checks if the collum is full
		if (board[0][playCollum - 1] != 0)
			System.out.println("The collum is full, please select another");
		else {
			//Sees where the next highest free space is in that collum
			int i = height - 1;
			while (board[i][playCollum - 1] != 0)
				i = i - 1;
			if(isPlayer1) {
				board[i][playCollum - 1] = 1;
				isPlayer1 = false;
			}
			else {
				board[i][playCollum - 1] = 2;
				isPlayer1 = true;
			}
		}
	}
	
	private static int gameCheck() {
		
		//Loops thorugh all the points and looks for 4 in a row only to the right, down and down diagonally to the left and right
		int numberInCurrentCell = 0;
		for(int i = 0; i < height; i++)
			for(int j = 0; j < length; j++) {
				if (board[i][j] == 1 || board[i][j] == 2) {
					numberInCurrentCell = board[i][j];
					if (length - j >= winningLength) //Sees if four in a line to the right is a possiblity
						if (board[i][j + 1] == numberInCurrentCell && board[i][j + 2] == numberInCurrentCell && board[i][j + 3] == numberInCurrentCell)
							return numberInCurrentCell;
					
					if (height - i >= winningLength) //Sees if four in a line to the bottom is a possibility
						if (board[i + 1][j] == numberInCurrentCell && board[i + 2][j] == numberInCurrentCell && board[i + 3][j] == numberInCurrentCell) 
							return numberInCurrentCell;
					
					if (height - i >= winningLength && length - j >= winningLength)	//Sees if 4 in a row diagonally down to the right is a possibility
						if (board[i + 1][j + 1] == numberInCurrentCell && board[i + 2][j + 2] == numberInCurrentCell && board[i + 3][j + 3] == numberInCurrentCell) 
							return numberInCurrentCell;
					
					if (j >= winningLength - 1 && height - i >= winningLength) //Sees if 4 in a row to the bottom left is a possibility
						if (board[i + 1][j - 1] == numberInCurrentCell && board[i + 2][j - 2] == numberInCurrentCell && board[i + 3][j - 3] == numberInCurrentCell)
							return numberInCurrentCell;
				}	
		}
		return 0; //Nobody has won yet (Edge case not accounted for (the board is full will still return nobody has won yet))
	}
}