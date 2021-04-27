import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class FileImport {
	
	public static String getTxtFile() {
		
		String outputString = "";
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the filename of the txt-file");
		try {
		FileReader file = new FileReader(keyboard.nextLine());
		Scanner reader = new Scanner(file);
		
		//Reads the given file and puts it into one long string
		while(reader.hasNextLine()) {
			outputString = outputString + reader.nextLine();
		}
		
		} catch(FileNotFoundException e) {
			System.out.println("The file was not found");
			System.exit(0);
		}
		return outputString;
	}
}