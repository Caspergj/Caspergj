import java.util.Arrays;

//This program counts the number of words from a txt-file. The counter uses the same defenition of words as Microsoft Word (every combination og letters, numbers and signs seperated by spaces)

public class WordCounter {
	
	public static void main (String[] args) {
		
		String inputString = "";
		String fixedString = "";
		
		inputString = FileImport.getTxtFile();								//Imports the given txt document into one long String
		System.out.println(inputString);
		fixedString = StringManipulation.removeExcessSpaces(inputString);	//Fixes the string for exces spaces
		System.out.println(fixedString);
		String[] words = fixedString.split(" ");							//Splits the texts words into different elements of an array
		System.out.println(Arrays.toString(words));
		logic(words);
		}
	
	private static void logic(String[] words) {
		//Program logic to make mappings and solving the actual problem
		System.out.println("Number of words in the text: " + words.length);
		System.out.println();
		System.out.println("The words and their occurences are");
		
		int i = 0;
		int j = 0;
		int leftCounter = 0;		//Is used to check if the word has already been counted
		int counter = 1; 			//Counts number of excess occurences - Therefore it starts and is reset at 1
		boolean duplicate = false;	//Is used to check if the word has already been counted
		while(i < words.length) {
			
			//This loop checks if this word has already been counted, if that is the case the counting is ignored
			while(leftCounter < i && !duplicate) {
				if (words[leftCounter].compareToIgnoreCase(words[i]) == 0) //Returns zero if the strings are the same, therefore we check if the expression is equal to zero
					duplicate = true;
				leftCounter = leftCounter + 1;
			}
			if (!duplicate) {
				j = i + 1;
				while(j < words.length) {
					if(words[i].compareToIgnoreCase(words[j]) == 0) //Returns zero if the strings are the same, therefore we check if the expression is equal to zero
					counter = counter + 1;
					j = j + 1;
				}
				System.out.println(words[i] + ": " + counter);
				counter = 1;
			}
			leftCounter = 0;
			duplicate = false;
			i = i + 1;
		}
	}
}