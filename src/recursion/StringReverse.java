/**
 * In this class you need to implement a recursion and iteration method that reverses a String.  
 * 
 * @author Alan Ho
 */
public class StringReverse {

	/**
	 * Reverses a String recursively.
	 * Hint: You can use the String class methods charAt and substring.
	 * Example 1: str.charAt(0) //Returns the first character of the String.
	 * Example 1a: str = "smiles"  str.charAt(4) //Returns character 'e'.
	 * Example 2: str.substring(0, 3) //Returns a new string containing characters index 0 to 2.
	 * Example 2a: str = "smiles"  str.substring(1, 5) //Returns "mile", which are characters 1 to 4.
	 * 
	 * @param s A String to reverse recursively.
	 * @return A String that is reversed.
	 */
	public static String stringReverseRecursion(String str) {
		return "";
	}
	
	/**
	 * Reverses a String iteratively.
	 * Hint: You can use the String class methods charAt.
	 * Example 1: str.charAt(0) //Returns the first character of the String.
	 * Example 1a: str = "smiles"  str.charAt(4) //Returns character 'e'.
	 * 
	 * @param s A String to reverse iteratively.  
	 * @return A String that is reversed.
	 */
	public static String stringReverseIteration(String str) {
		return "";
	}
	
	/** ATTEMPT THIS SECTION ONLY IF YOU'VE SUCCESSFULLY COMPLETED THE METHODS ABOVE 
		IF YOU THINK YOU'VE SOLVED THESE NEW PROBLEMS, UNCOMMENT THE IF STATEMENTS IN
		THE MAIN METHOD PERTAINING TO THESE METHODS
	*/
	
	/**
	 * Sums the digits of a number. 
	 * Example 1: sumDigits(126) returns 9
	 * Hint 1: Mod (%) by 10 yields the rightmost digit (126 % 10 is 6).
	 * Hint 2: Divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 
	 * 
	 * @param n A number whose digits are to be added together.
	 * @return An integer whose number represents the digits of the original number summed.
	 */
	public static int sumDigitsRecursion(int n) {
		return 0;
	}
	
	/**
	 * Sums the digits of a number. 
	 * Example 1: sumDigits(126) returns 9
	 * Hint 1: Mod (%) by 10 yields the rightmost digit (126 % 10 is 6).
	 * Hint 2: Divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 
	 * 
	 * @param n A number whose digits are to be added together.
	 * @return An integer whose number represents the digits of the original number summed.
	 */
	public static int sumDigitsIteration(int n) {
		return 0;
	}
	
	/**
	 * Counts the number of lowercase 'x' chars in a String.
	 * Example 1: countX("xxhixx") returns 4
	 * Hint 1: Like the reverse String method, use String class substring method.
	 * 
	 * @param str The string to count how many lowercase 'x' are in it.
	 * @return The total number of lowercase 'x' in the String.
	 */
	public static int countXRecursion(String str) {
		  return 0;
	}
	
	/**
	 * Counts the number of lowercase 'x' chars in a String.
	 * Example 1: countX("xxhixx") returns 4
	 * Hint 1: Like the reverse String method, use String class substring method.
	 * 
	 * @param str The string to count how many lowercase 'x' are in it.
	 * @return The total number of lowercase 'x' in the String.
	 */
	public static int countXIteration(String str) {
		  return 0;
	}
	
	public static void main(String[] args) {
		
		try {
			//Two Strings that you need to reverse with the methods that you create.
			String recursionString = "This string tests your recursion method.";
			String iterationString = "This string tests your iteration method.";
			
			//Calls your recursion and iteration method and puts the result into new Strings. 
			String stringRecursionMethod = stringReverseRecursion(recursionString);
			String stringIterarionMethod = stringReverseIteration(iterationString);
			
			//Reverses the original Strings for testing purposes.
			String sbRecursion = new StringBuilder(recursionString).reverse().toString();
			String sbIteration = new StringBuilder(iterationString).reverse().toString();
			
			//Prints whether or not you've successfully reversed the Strings.
			if(stringRecursionMethod.equals(sbRecursion)) {
				System.out.println("Congratulations! You've reversed the String by recursion!!");
			} else {
				System.out.println("ERROR: Recursion method.\nYou got : " + stringRecursionMethod);
				System.out.println("You need: " + sbRecursion);
			}
			
			System.out.println();
			if(stringIterarionMethod.equals(sbIteration)) {
				System.out.println("Congratulations! You've reversed the String by iteration!!");
			} else {
				System.out.println("ERROR: Iteration method.\nYou got : " + stringIterarionMethod);
				System.out.println("You need: " + sbIteration);
			}
			
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		/** DELETE THIS LINE IF YOU THINK YOU'VE SOLVED THE ADDITIONAL RECURSIVE METHODS 
		 
		//sumDigits method
		System.out.println("sumDigitsRecursion(126)")
		int sum = sumDigitsRecursion(126); 
		if(sum == 9) {
			System.out.println("\nCongratulations! You've successfully summed all the digits");
		} else {
			System.out.println("\nERROR: sumDigits.\nYou need 9, but instead got: " + sum);
		}
		
		System.out.println("sumDigitsRecursion(49)")
		sum = sumDigitsRecursion(49);
		if(sum == 13) {
			System.out.println("\nCongratulations! You've successfully summed all the digits");
		} else {
			System.out.println("\nERROR: sumDigits.\nYou need 13, but instead got: " + sum);
		}
		
		System.out.println("sumDigitsIteration(126)")
		sum = sumDigitsIteration(126); 
		if(sum == 9) {
			System.out.println("\nCongratulations! You've successfully summed all the digits");
		} else {
			System.out.println("\nERROR: sumDigits.\nYou need 9, but instead got: " + sum);
		}
		
		System.out.println("sumDigitsIteration(49)")
		sum = sumDigitsIteration(49);
		if(sum == 13) {
			System.out.println("\nCongratulations! You've successfully summed all the digits");
		} else {
			System.out.println("\nERROR: sumDigits.\nYou need 13, but instead got: " + sum);
		}
		
		//countX method
		int count = countXRecursion("xxhixx");
		if(count == 4) {
			System.out.println("\nCongratulations! You've counted all the x's!");
		} else {
			System.out.println("\nERROR: countX.\n You need 4, but instead got: " + count);
		}
		
		count = countXRecursion("xhixhix");
		if(count == 3) {
			System.out.println("\nCongratulations! You've counted all the x's!");
		} else {
			System.out.println("\nERROR: countX.\n You need 3, but instead got: " + count);
		}
		
		count = countXIteration("xxhixx");
		if(count == 4) {
			System.out.println("\nCongratulations! You've counted all the x's!");
		} else {
			System.out.println("\nERROR: countX.\n You need 4, but instead got: " + count);
		}
		
		count = countXIteration("xhixhix");
		if(count == 3) {
			System.out.println("\nCongratulations! You've counted all the x's!");
		} else {
			System.out.println("\nERROR: countX.\n You need 3, but instead got: " + count);
		}
		
		DELETE THIS LINE IF YOU THINK YOU'VE SOLVED THE ADDITIONAL RECURSIVE METHODS */
		 
	}
}
