import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Rabindra Raj Suwal
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree morse = new MorseCodeTree();

	/**
	 * returns a string with all the data in the tree in LNR order with a space in between them
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree(){
		ArrayList<String> tree = morse.toArrayList();
		String print = "";
		for(String letter: tree) {
			print += letter + " ";
		}
		return print.trim();
	}

	
	
	/**
	 * Converts a Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param morseCode the morse code
	 * @return english translation
	 */
	public static String convertToEnglish(String code){
		
		String[] codeletter;
		String[] codeword = code.split(" / ");
		String result = "";

		for(String temp: codeword) {
			codeletter = temp.split(" ");
			for(String tempLetter: codeletter) {
				result +=morse.fetch(tempLetter);
			}

			result += " ";
			
		}
		return result.trim();
	}
	
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param codeFile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(codeFile);
		String file = "";
		
		while(scanner.hasNextLine())
			file += scanner.nextLine() + "\n"; 
		scanner.close();
		return convertToEnglish(file.trim());
	}	
	
}