public class StringManipulation {
	
	public static String removeExcessSpaces(String inputString) {
	
		//This method removes any exces spaces from the string if there are any
		//The variable j counts the number of exces spaces
		
		int i = 0;
		int j = 0;
		String fixedString = "";
		while (i < inputString.length()) {
			j = 0;
			if (inputString.charAt(i) != ' ')
				fixedString = fixedString + inputString.charAt(i);
			else {
				while (inputString.charAt(i + j + 1) == ' ')
					j = j + 1;
				if (inputString.charAt(i + j + 1) == '.' || inputString.charAt(i + j + 1) == ',')
					; //Does nothing (we do not want to add a space if it is after a word and right before a dot or a comma)
				else
					fixedString = fixedString + inputString.charAt(i);
			}
			i = i + 1 + j;
		}
		return fixedString;
	
	}
	
}