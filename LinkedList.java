/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Linked Lists, Stacks, & Queues, LinkedList
 * @date 11/20/20 
 */

/**
 * 
 * @version 1.0 This is the LinkedList superclass that creates the LinkedList
 *          data structure used by the child classes Stack and Queue. It
 *          demonstrates the functionality of the LinkedList data structure in
 *          the main method.
 *
 */
public class LinkedList {
	/**
	 * Inner class Node to be used by the LinkedList interface
	 *
	 */
	class Node {
		// creates instance variable data to be used in the LinkedList outer class to
		// represent data in a Node
		private Object data;
		// creates instance variable next to be used in the LinkedList outer class to
		// represent the link to the next Node
		private Node next;

		/**
		 * This constructor initializes the Object data variable to the newData Object
		 * in the parameter. It also initializes Node next variable to null
		 * 
		 * @param newData
		 */
		public Node(Object newData) {
			data = newData;
			next = null;
		}

		/**
		 * This is a no arg Node class constructor that initializes instance variable
		 * data to 0 and instance variable next to null
		 */
		public Node() {
			data = 0;
			next = null;
		}

		/**
		 * This method gets and returns Object data
		 * 
		 * @return data
		 */
		public Object getData() {
			return data;
		}

		/**
		 * This method sets Object data
		 * 
		 * @param data
		 */
		public void setData(Object data) {
			this.data = data;
		}

		/**
		 * This method gets and returns Node next
		 * 
		 * @return next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * This method sets Node next to the Node next parameter
		 * 
		 * @param next
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * This class constructor initializes instance variable Object data to parameter
		 * newData and instance variable Node next to parameter link
		 * 
		 * @param newdata
		 * @param link
		 */
		public Node(Object newData, Node link) {
			data = newData;
			next = link;
		}
	}

	// this instance variable Node head to keep track of the head of the LinkedList
	// that is initialized to null
	Node head = null;

	/**
	 * This method checks to see if the list is empty or not. If the head is null,
	 * it returns true and false if not
	 * 
	 * @return true
	 * @return false
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method inserts an Object at the given index in the list. It creates a
	 * try statement where it checks first to ensure that all arguments are valid,
	 * and if not, LinkedListException is thrown. Else, if the list was empty and
	 * index equals 0, it set the head to a new Node with the newData argument in
	 * it. Else if the list has one element in it and index is equal to 0 or index
	 * is just equal to 0, it sets the head to a new Node with the newNode and head
	 * argument in it. Else, it loops through the linked list until two positions
	 * before the index where the Node is set to the next Node. It also makes the
	 * Node next equal to a new Node with the newData and Node next as arguments. In
	 * the catch statement, it catches any LinkedListExceptions.
	 * 
	 * @param newData
	 * @param index
	 * @throws LinkedListException
	 */
	public void insert(Object newData, int index) throws LinkedListException {
		Node presentNext = head;
		try {
			if (newData == null || index >= size() || index < 0) {
				throw new LinkedListException("The object or index is invalid/out of bounds");
			} else if (isEmpty() && (index == 0)) {
				head = new Node(newData);
			}

			else if (((size() == 1) && (index == 0)) || (index == 0)) {
				head = new Node(newData, head);
			}

			else {
				for (int i = 0; i < index - 1; i++) {
					presentNext = presentNext.next;
				}

				presentNext.next = new Node(newData, presentNext.next);
			}
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method deletes the Object at a given index in the list. It creates a try
	 * statement where it first checks all invalid arguments and throws a
	 * LinkedListException if it is invalid. Else if the list has only one element
	 * and the index is 0 or the index is 0 and the size is grater than 1, head is
	 * set to the next element. Else, up until two elements before the given index,
	 * the present Node is set to the next Node and i increments to keep the while
	 * loop going. The presentNext next node is then set to two Nodes later at the
	 * correct index. For catching the exceptions, the catch statement catches them
	 * and receives the exception message.
	 * 
	 * @param index
	 * @throws LinkedListException
	 */
	public void delete(int index) throws LinkedListException {
		Node presentNext = head;
		try {
			if ((index >= size()) || (index < 0)) {
				throw new LinkedListException(
						"Index cannot be higher than or equal to the list! It also cannot be below 0! It also cannot delete from an empty list!");

			} else if (((size() == 1) && (index == 0)) || ((index == 0) && (size() > 1))) {
				head = head.next;
			} else {
				int i = 0;
				while (i < index - 1) {
					presentNext = presentNext.next;
					i++;
				}

				presentNext.next = presentNext.next.next;
			}
		} catch (

		LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method returns the size of the list. It does so by while looping through
	 * the Nodes until the last node keeping count of the amount of Nodes by using
	 * amount and setting the presentNext node to the next node. It then finally
	 * returns the amount of Nodes.
	 * 
	 * @return amount
	 */
	private int size() {
		int amount = 0;
		Node presentNext = head;
		while (presentNext != null) {
			amount++;
			presentNext = presentNext.next;
		}
		return amount;
	}

	/**
	 * This method removes an Object at the given index in the list and returns it.
	 * It starts with a try statement in which it first checks if the size is equal
	 * to 1 and index equals 0 or if index is equal to 0 and the size is greater
	 * than 1. If so, the present object is equal to the head data and head is set
	 * to the next element. Else if the size of the list is greater than 1, index is
	 * less than the size of the list, and the index is greater than 0, a for loop
	 * goes through the linkedlist until two positions before the index where the
	 * Node is set to the next Node. The present object is set equal to the
	 * presentNext next Node data. It also makes the presentNext next equal to the
	 * presentNext next.next. Else, the linkedlistexception is thrown. For catching
	 * the exceptions, the catch statement catches them and receives the exception
	 * message.
	 * 
	 * @param index
	 * @return presentObject
	 * @throws LinkedListException
	 */
	public Object remove(int index) throws LinkedListException {
		Object presentObject = null;
		Node presentNext = head;
		try {
			if (((size() == 1) && (index == 0)) || ((index == 0) && (size() > 1))) {
				presentObject = head.data;
				head = head.next;
			} else if ((size() > 1) && (index < size()) && (index > 0)) {
				for (int i = 0; i < index - 1; i++) {
					presentNext = presentNext.next;
				}

				presentObject = presentNext.next.data;
				presentNext.next = presentNext.next.next;
			} else {
				throw new LinkedListException(
						"Index cannot be higher than or equal to the list! It also cannot be below 0!");
			}
			return presentObject;
		} catch (LinkedListException e) {
			return e.getMessage();
		}
	}

	/**
	 * This method appends a new Object to the list. It starts with a try statement
	 * in which if the newData object given in the parameter is equal to null, a
	 * linkedlistexception is thrown. Else if the list is empty, head is set to a
	 * new Node taking in the newData as a parameter. Else, while the linked list is
	 * not null, the presentNext Node is set equal to the next Node. The presentNext
	 * next node is set equal to a new Node with parameter newData. For catching the
	 * exceptions, the catch statement catches them and receives the exception
	 * message.
	 * 
	 * @param newData
	 * @throws LinkedListException
	 */
	public void append(Object newData) throws LinkedListException {
		Node presentNext = head;
		try {
			if (newData == null) {
				throw new LinkedListException("Object cannot be null!");
			} else if (isEmpty()) {
				head = new Node(newData);
			} else {
				while (presentNext.next != null) {
					presentNext = presentNext.next;
				}

				presentNext.next = new Node(newData);
			}
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method prints out the Linked list as a string. While the linked list is
	 * not empty, the String is equal to the presentNext Node data. There is an if
	 * statement within the while loop that sets the String equal to a comma while
	 * the presentNext next Node is not null. Finally in the while loop, the
	 * presentNext Node is set to the presentNext next Node. The string is then
	 * returned in the end outside of the while loop.
	 * 
	 * @return str
	 */
	public String toString() {
		Node presentNext = head;
		String str = "";
		while (presentNext != null) {
			str += presentNext.data;

			if (presentNext.next != null)
				str += ", ";

			presentNext = presentNext.next;
		}

		return str;
	}

	/**
	 * This method finds the index of a given Object in the list. It starts with a
	 * try statement in which an if statement that has the condition that the
	 * parameter object target is not null goes through every Node in the Linked
	 * List through a while loop and if the data in the Node does not equal the
	 * target, the index value is incremented. Else, since the Node data would equal
	 * the target, the index value would be returned. Underneath the if-else
	 * statement in the while loop makes the presentNext Node equal to the next
	 * Node. The else statement after the original if statement throws a
	 * LinkedListException if the target is null. Underneath this entire try
	 * statement, there is a catch statement that catches and stores the message
	 * from any LinkedListException thrown.
	 * 
	 * @param target
	 * @return index, -1
	 * @throws LinkedListException
	 */
	public int indexOf(Object target) throws LinkedListException {
		try {
			Node presentNext = head;
			int index = 0;

			if (target != null) {
				while (presentNext != null) {
					if (!(presentNext.data.equals(target)))
						index++;
					else
						return index;

					presentNext = presentNext.next;
				}
			} else {
				throw new LinkedListException();
			}
			return -1;
		} catch (LinkedListException e) {
			return -1;
		}

	}

	/**
	 * This method checks to see if one list is a deep copy of another list. It
	 * firsts checks to see if the parameter other Object is null, if so, it returns
	 * false. Else if the class of the current Linked List object and the other
	 * Object are not the same, it returns false. Else, LinkedList that is set equal
	 * to the LinkedList typecasted other Object and Node thisCurrent stores the
	 * current Linked List head and Node otherCurrent stores the that object head.
	 * In the else statement, there is a while loop that checks if thisCurrent and
	 * otherCurrent Node are not null. Within the while loop, if thisCurrent data
	 * does not equal otherCurrent data it returns false. Else, thisCurrent equals
	 * thisCurrent next Node and otherCurrent equals otherCurrent next Node.
	 * Underneath the while loop, if thisCurrent doesn't equal null and otherCurrent
	 * equals null, it returns false. Else if thisCurrent equals null and
	 * otherCurrent does not equal null, it returns false. Else, it returns true.
	 */
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (this.getClass() != other.getClass()) {
			return false;
		} else {
			LinkedList that = (LinkedList) other;
			Node thisCurrent = this.head;
			Node otherCurrent = that.head;

			while (thisCurrent != null && otherCurrent != null) {
				if (!thisCurrent.data.equals(otherCurrent.data)) {
					return false;
				} else {
					thisCurrent = thisCurrent.next;
					otherCurrent = otherCurrent.next;
				}
			}
			if (thisCurrent != null && otherCurrent == null) {
				return false;
			} else if (thisCurrent == null && otherCurrent != null) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * This main method is the driver of the class and tests the LinkedList data
	 * structure.
	 * 
	 * @param args
	 * @throws LinkedListException
	 */
	public static void main(String[] args) throws LinkedListException {
		// Objects of LinkedList types are created
		LinkedList firstList = new LinkedList();
		LinkedList secondList = new LinkedList();
		LinkedList thirdList = new LinkedList();
		LinkedList fourthList = new LinkedList();
		LinkedList fifthList = new LinkedList();
		LinkedList sixthList = new LinkedList();

		// these statements test the LinkedList insert method
		firstList.insert("fox", 12);
		firstList.insert(null, 0);

		// this statement tests the LinkedList append method
		firstList.append(null);

		// these statements test the LinkedList indexOf method
		System.out.println(firstList.indexOf("fox"));
		System.out.println(firstList.indexOf(null));

		// these statements tests the LinkedList append method
		firstList.append(805);
		firstList.append(32);
		firstList.append("suzie");
		firstList.append("steven");
		firstList.append(32.56);
		firstList.append(25.8);

		// this statement prints the firstList
		System.out.println("First List: [" + firstList + "]");

		// this statement tests the LinkedList insert method
		firstList.insert("school", 2);

		// this statement tests the toString LinkedList method
		System.out.println("The first list after inserting at the index 2: ");
		System.out.println(firstList.toString());

		// these statements test the remove LinkedList method
		firstList.remove(0);
		System.out.println("The first list after removing at the index 0: " + firstList);

		// these statements test the insert LinkedList method
		firstList.insert("lollipop", 0);
		System.out.println("The first list after inserting at the index 0: " + firstList);

		// these statements test the remove LinkedList method
		System.out.println("Removing index 50 from the first list: " + firstList.remove(50));
		System.out.println("The first list after removing at the index 50: " + firstList);

		// this statement test the indexOf LinkedList method
		System.out.println("The index of Object 32 in the first list is: " + firstList.indexOf(32));

		// this statement tests the size LinkedList method
		System.out.println("The size of the first list is: " + firstList.size());

		// this statement tests the append LinkedList method
		secondList.append("j");

		// this statement tests the size LinkedList method
		System.out.println("The size of the second list is: " + secondList.size());

		// these statements test the append LinkedList method
		secondList.append(54.9886);
		secondList.append("ken");
		secondList.append(21);
		secondList.append("jen");
		secondList.append(77);

		// this statement prints the second list
		System.out.println("Second List: [" + secondList + "]");

		// these statements test the remove LinkedList method
		secondList.remove(5);
		System.out.println("The second list after removing at the index 5: " + secondList);

		// these statements test the delete LinkedList method
		secondList.delete(3);
		System.out.println("The second list after deleting at the index 3: " + secondList);
		secondList.delete(50);

		// these statements test the insert LinkedList method
		secondList.insert("alex", 0);
		System.out.println("The second list after inserting at the index 0: " + secondList);

		// these statements test the delete LinkedList method
		secondList.delete(0);
		System.out.println("The second list after deleting at the index 0: " + secondList);

		// these statements test the insert LinkedList method
		secondList.insert(60.4, 1);
		System.out.println("The second list after inserting at the index 1: " + secondList);

		// these statements test the indexOf LinkedList method
		secondList.indexOf("j");
		System.out.println("The index of Object j in the second list is " + secondList.indexOf("j"));
		System.out.println("The index of Object mmm in the second list is " + secondList.indexOf("mmm"));

		// these statements test the size LinkedList method
		secondList.size();
		System.out.println("The size of the second list is: " + secondList.size());

		// these statements test the equals LinkedList method
		System.out.println(firstList.equals(secondList));
		System.out.println(thirdList.equals(thirdList));
		System.out.println(thirdList.equals(fourthList));

		// these statements test the remove LinkedList method
		System.out.println(secondList.remove(15));
		System.out.println("The second list after removing at the index 15: " + secondList);

		// this statement tests the insert LinkedList method
		secondList.insert(189, 15);

		// these statements test the delete LinkedList method
		thirdList.delete(2);
		System.out.println("The third list after deleting at the index 2: " + thirdList);

		// these statements test the remove LinkedList method
		System.out.println(thirdList.remove(0));
		System.out.println(secondList.remove(8));

		// these statements test the append LinkedList method
		fifthList.append("rainbow");
		fifthList.append(8);
		fifthList.append(39.39);
		sixthList.append("rainbow");
		sixthList.append(8);
		sixthList.append(39.39);

		// this statement tests the equals LinkedList method
		System.out.println(fifthList.equals(sixthList));
	}
}
