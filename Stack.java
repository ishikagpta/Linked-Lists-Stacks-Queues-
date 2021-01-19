/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Linked Lists, Stacks, & Queues, Stack
 * @date 11/20/20 
 */

/**
 * @version 1.0 This Stack class is a subclass of the LinkedList class that uses
 *          the LinkedList class to build a stack data structure
 *
 */
public class Stack extends LinkedList {

	@Override
	/**
	 * This method insert is an overridden version of the LinkedList insert method.
	 * It calls the push method and tests it using the newData object.
	 */
	public void insert(Object newData, int index) {
		try {
			push(newData);
		} catch (LinkedListException e) {
			e.getMessage();
		}
	}

	@Override
	/**
	 * This method remove is an overridden version of the LinkedList remove method.
	 * It calls the pop method and tests it.
	 */
	public Object remove(int index) {
		try {
			return pop();
		} catch (LinkedListException e) {
			return e;
		}
	}

	/**
	 * This method pushes an object into the stack. It starts with a try statement
	 * that has an if statement where it checks if the Object next from the
	 * parameter equals null. If not, it sets head equal to a new Node with
	 * parameters Object next and the head. Else, it throws a LinkedListException.
	 * After the try statement, the catch statement catches any LinkedListException
	 * statements and messages.
	 * 
	 * @param next
	 * @throws LinkedListException
	 */
	public void push(Object next) throws LinkedListException {
		try {
			if (next != null) {
				head = new Node(next, head);
			} else {
				throw new LinkedListException("The object cannot be null!");
			}
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method pops and returns an object out of the stack. It starts with a try
	 * statement that has an if statement that checks if the Stack isEmpty. If it
	 * is, it throws a LinkedListException. Else, Object presentObject is set to the
	 * head data. The head is then set to the head next. The object presentObject is
	 * finally returned. After the try statement, the catch statement catches any
	 * LinkedListException statement and messages and returns it.
	 * 
	 * @return presentObject
	 * @throws LinkedListException
	 */
	public Object pop() throws LinkedListException {
		try {
			if (isEmpty()) {
				throw new LinkedListException("Cannot pop from an empty list!");
			} else {
				Object presentObject = head.getData();
				head = head.getNext();
				return presentObject;
			}
		} catch (LinkedListException e) {
			return e.getMessage();
		}
	}

	/**
	 * This main method is the driver for the Stack class and tests it
	 * 
	 * @param args
	 * @throws LinkedListException
	 */
	public static void main(String[] args) throws LinkedListException {
		// Objects of Stack types are created
		Stack firstStack = new Stack();
		Stack secondStack = new Stack();

		// These statements test the Stack push method on the first Stack
		firstStack.push("new");
		firstStack.push(99);
		firstStack.push(33.95624576);
		firstStack.push(22);
		firstStack.push("hello");

		// This statement tests the super class equals method on the first and second
		// Stack
		System.out.println(firstStack.equals(secondStack));

		// This statement tests the super class toString method on the first Stack
		System.out.println(firstStack.toString());

		// This statement prints the first Stack
		System.out.println("The firstStack stack is: [" + firstStack + "]");

		// This while loop tests the Stack pop method as it keeps popping from the Stack
		// until the first Stack is empty which tests the super class isEmpty method
		while (!firstStack.isEmpty()) {
			System.out.println("Popped from stack: " + firstStack.pop());
			System.out.println("The stack now is: [" + firstStack + "]");
		}

		// This statement tests the super class equals method on the first and second
		// Stack
		System.out.println(firstStack.equals(secondStack));

		// These statements test the overridden Stack insert method
		firstStack.insert("hello", 5);
		firstStack.insert(90, 4);

		// This statement prints the first Stack
		System.out.println(firstStack);

		// These statements test the overridden Stack remove method
		firstStack.remove(3);
		firstStack.remove(6);

		// This statement tests the superclass toString method on the first Stack
		System.out.println(firstStack.toString());

		// This statement tests the pop method on the second Stack
		System.out.println(secondStack.pop());

		// This statement tests the super class equals method on the first and second
		// Stack
		System.out.println(firstStack.equals(secondStack));

		// These statements test the Stack push method
		firstStack.push(null);
		firstStack.push("new");
		firstStack.push(99);
		firstStack.push(33.95624576);
		firstStack.push(22);
		firstStack.push("hello");
		secondStack.push("new");
		secondStack.push(99);
		secondStack.push(33.95624576);
		secondStack.push(2);
		secondStack.push("hello");

		// This statement tests the super class equals method on the first and second
		// Stack
		System.out.println(firstStack.equals(secondStack));
	}
}
