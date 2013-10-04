package assignment5;

public class ArrayReverse {

	/**
	 * This method takes in a String array and reverses the String objects within.
	 * MUST use a Stack to reverse the String objects in the given array.
	 * Hint: Use Generics for the Stack in this method.
	 * 
	 * @param array String array to be reversed.
	 * @return Returns a String array that has reversed the String objects within.
	 */
	private static String[] reverseTheArray(String[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method checks to see if two String arrays contain the same String object at the same indexes.
	 * 
	 * @param array1 First String array to be checked against.
	 * @param array2 Second String array to be checked against.
	 * @return true  Successfully checked each String object in both arrays and everything matched.
	 * @return false Either one of the two lengths do not match or there was a different String object found at the same index.
	 */
	private static boolean isTheSame(String[] array1, String[] array2) throws NullPointerException {
		//Base case check to see if any of the arrays are null.
		if(array1 == null || array2 == null) {
			throw new NullPointerException("One of these arrays are null!");
		}
		//Another base case check
		if (array1.length != array2.length) {
			return false;
		}
		
		//Can use either array1.length or array2.length in the boolean expression check because it's assumed they're the same size. 
		for (int i = 0; i < array1.length; i++) {
			if (!array1[i].equals(array2[i])) {
				//Like Anthony discussed in 10/02 lab, return as soon as you find something that doesn't match.
				return false;
			}
		}
		
		//Successfully checked each String object in both arrays and everything matched.
		return true;
	}

	public static void main(String[] args) {
		
		String[] reverseMe = {"Me", "Reverse", "You", "Until", "Sense", "No", "Makes", "This"};
		String[] inOrderArray = {"This", "Makes", "No", "Sense", "Until", "You", "Reverse", "Me"};

		//You can reverse the order of arrays and should still get the same result.
		//i.e. isTheSame(reverseTheArray(inOrderArray), reverseMe) in the if statement instead.
		if(isTheSame(reverseTheArray(reverseMe), inOrderArray)) {
			System.out.println("You've reversed me, hooray!");
		} else {
			System.out.println("Help, I'm still reversed!");
		}
	}

}
