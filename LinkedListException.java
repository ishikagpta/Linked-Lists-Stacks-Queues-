/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Linked Lists, Stacks, & Queues, LinkedListException 
 * @date 11/20/20 
 */

/**
 * 
 * @version 1.0 This is the LinkedListException class that inherits the
 *          Exception class to be used as an exception class for the List,
 *          Stack, and Queue class
 *
 */
public class LinkedListException extends Exception {

	/**
	 * This is a no arg class constructor that calls the parent constructor in its
	 * body that contains a message
	 */
	public LinkedListException() {
		super("Invalid input or unable to use input due to empty list!");
	}

	/**
	 * This is a class constructor that takes in String message as an argument and
	 * calls the parent constructor in its body to use and print the argument
	 * 
	 * @param message
	 */
	public LinkedListException(String message) {
		super("Invalid input or unable to use input in current list: " + message);
	}
}
