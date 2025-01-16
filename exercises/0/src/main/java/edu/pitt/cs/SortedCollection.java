package edu.pitt.cs;

//TODO: Import libraries as needed
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.Map;

public class SortedCollection {
	// TODO: Add member variables or methods as needed
	Map<Integer, Integer> map = new TreeMap<>();
	int c = 0;
	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		// TODO: Implement
		map.put(n, 0);
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		int min = ((TreeMap<Integer, Integer>) map).firstKey();
		map.remove(min);
		return min;
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.
		for (String i : args)
		{
			int p;
			try{
				p = Integer.parseInt(i);
				collection.add(p);
			}
			catch (NumberFormatException e){
				showUsage();
				return;
			}
		}
			
		
		// If any commandline argument is not a number, call showUsage() and return.
		
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
