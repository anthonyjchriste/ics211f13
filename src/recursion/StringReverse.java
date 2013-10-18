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
	}
}
