package blockProject;

import java.util.Scanner;
import java.util.HashSet;

/**
 * @author CS3090 Assignment: BlockProjectTwo by Siesia Makaafi
 * @version February 22, 2026
 */
public class BlockProjectTwo {
	
	/**
	 * Check if the char passed can be parsed to an integer.
	 * 
	 * @param possibleNum - char that could be parsed to an integer
	 * @return true if char can be parsed to a integer, false otherwise 
	 */
	private static boolean isNum(char possibleNum) {
		try {
			Integer.parseInt(possibleNum + "");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	/**
	 * Run the password strength checker
	 * 
	 * @param args a String[] array that will not be used in this program
	 */
	public static void main(String[] args) {
		
		// variables used to check aspects of password
		int uniqueCharTypeCount = 0;
		boolean firstLowerCaseCharWasFound = false;
		boolean firstUpperCaseCharWasFound = false;
		boolean symbolCharWasFound = false;
		boolean numWasFound = false;
		
		// variables used to hold the info of the password
		String passwordStrInfo = "";
		HashSet<Character> uniqueChars = new HashSet<Character>();
		
		// variables to get and hold the password itself
		String password = "";
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter password to check its strength:");
		
		while(userInput.hasNext()){
			password = userInput.next();
			
			// check each char of password to evaluate strength of password
			for(char c : password.toCharArray()) {
				uniqueChars.add(c);
				
				if(!firstLowerCaseCharWasFound && Character.isLowerCase(c)) {
					uniqueCharTypeCount++;
					firstLowerCaseCharWasFound = true;
				} 
				else if(!firstUpperCaseCharWasFound && Character.isUpperCase(c)) {
					uniqueCharTypeCount++;
					firstUpperCaseCharWasFound = true;
				} 
				else if(!symbolCharWasFound) {
					uniqueCharTypeCount++;
					symbolCharWasFound = true;
				}
				else if(!numWasFound && isNum(c)) {
					uniqueCharTypeCount++;
					numWasFound = true;
				}
			}
			
			// use variables to see how strong the password is
			if(password.length() < 4 || uniqueChars.size() < 4) {
				passwordStrInfo = "really weak.";
			}
			else if(password.length() < 6 || uniqueChars.size() < 6) {
				passwordStrInfo = "weak.";
			}
			else if(password.length() < 10 && password.length() > 7 && uniqueCharTypeCount > 2 && uniqueChars.size() > 5) {
				passwordStrInfo = "strong.";
			}
			else if(password.length() > 9 && uniqueCharTypeCount == 4  && uniqueChars.size() > 5) {
				passwordStrInfo = "really strong.";
			}
			else {
				passwordStrInfo = "medium.";
			}
			
			System.out.println("The strength of this password is " + passwordStrInfo);
			break;
		}
		
		userInput.close();
	}
}
