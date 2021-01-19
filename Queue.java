/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Linked Lists, Stacks, & Queues, Queue
 * @date 11/20/20 
 */

/**
 * 
 * @version 1.0 This Queue class is a child class that inherits and uses the
 *          LinkedList class to build a queue data structure
 *
 */
public class Queue extends LinkedList {

	@Override
	/**
	 * This method insert is an overridden version of the LinkedList insert method.
	 * It calls the enqueue method and tests it using the newData object.
	 * 
	 * @param newData
	 * @param index
	 */
	public void insert(Object newData, int index) {
		try {
			enqueue(newData);
		} catch (LinkedListException e) {
			e.getMessage();
		}
	}

	@Override
	/**
	 * This method remove is an overridden version of the LinkedList remove method.
	 * It calls the dequeue method and tests it.
	 * 
	 * @param index
	 */
	public Object remove(int index) {
		try {
			return dequeue();
		} catch (LinkedListException e) {
			return e;
		}
	}

	/**
	 * This method dequeues an object from the queue and returns it. It starts a try
	 * statement where it first checks if the Queue is empty and throws a
	 * LinkedListException if true. Else, theres a while loop that checks if the
	 * presentNext next Node does not equal null. If true, Node pastNext equals the
	 * presentNext node that has the head in it. The presentNext node equals the
	 * presentNext next Node. After the while loop, if the pastNext node equals
	 * null, the Object newData is equal to the head data. Head is then set to the
	 * next Node. Else, Object newData is set equal to the presentNext Node data and
	 * the pastNext node sets the next to presentNext Node's next. In the end before
	 * the catch statement, the Object newData is returned. In the catch statement
	 * under the try statement, it catches any LinkedListExceptions and returns any
	 * exception messages.
	 * 
	 * @return newData
	 * @throws LinkedListException
	 */
	public Object dequeue() throws LinkedListException {
		Node presentNext = head;
		Node pastNext = null;
		Object newData = null;
		try {
			if (isEmpty()) {
				throw new LinkedListException("Cannot dequeue from empty list!");
			} else {
				while (presentNext.getNext() != null) {
					pastNext = presentNext;
					presentNext = presentNext.getNext();
				}
				if (pastNext == null) {
					newData = head.getData();
					head = head.getNext();
				} else {
					newData = presentNext.getData();
					pastNext.setNext(presentNext.getNext());
				}
			}
			return newData;
		} catch (LinkedListException e) {
			return e.getMessage();
		}
	}

	/**
	 * This method enqueues an object into the queue. It first does a try statement
	 * in which an if statement checks if the parameter Object next is equal to null
	 * and throws a LinkedListException statement if true. Else, head is set equal
	 * to a new Node with Object next as a parameter and head as a parameter. Under
	 * the try statement, there is a catch statement that catches any
	 * LinkedListException and exception messages.
	 * 
	 * @param next
	 * @throws LinkedListException
	 */
	public void enqueue(Object next) throws LinkedListException {
		try {
			if (next == null) {
				throw new LinkedListException("Cannot enqueue null object!");
			} else {
				head = new Node(next, head);
			}
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This main method is the driver for the queue class and tests it.
	 * 
	 * @param args
	 * @throws LinkedListException
	 */
	public static void main(String[] args) throws LinkedListException {
		// Objects of Queue types are created
		Queue firstQueue = new Queue();
		Queue secondQueue = new Queue();

		// These statements enqueue objects to the first Queue
		firstQueue.enqueue("alice");
		firstQueue.enqueue(55);
		firstQueue.enqueue("jam");
		firstQueue.enqueue(76.8);
		firstQueue.enqueue("sam");

		// This statement prints the first Queue
		System.out.println("The queue is: [" + firstQueue + "]");

		// This statement tests the super class equals method on the first and second
		// Queue
		System.out.println(firstQueue.equals(secondQueue));

		// These statements dequeue the first Queue until it is empty. It does so by
		// going through a while loop that stops looping right before the first Queue is
		// empty
		while (!firstQueue.isEmpty()) {
			System.out.println("Dequeued from first queue: " + firstQueue.dequeue());
			System.out.println("The queue now is: [" + firstQueue + "]");
		}

		// This statement tests the super class equals method on the first and second
		// Queue
		System.out.println(firstQueue.equals(secondQueue));

		// These statements test the overridden Queue insert method
		firstQueue.insert("hello", 5);
		firstQueue.insert(90, 4);

		// This statement prints the first Queue
		System.out.println(firstQueue);

		// These statements test the overridden Queue remove method
		firstQueue.remove(3);
		firstQueue.remove(6);

		// This statement tests the toString method on the first Queue
		System.out.println(firstQueue.toString());

		// This statement tests the isEmpty method on the first Queue
		System.out.println(firstQueue.isEmpty());

		System.out.println("Dequeued from the second queue" + secondQueue.dequeue());

		// This statement tests the super class equals method on the first and second
		// Queue
		System.out.println(firstQueue.equals(secondQueue));

		// These statements test the enqueue method of the Queue class
		firstQueue.enqueue("alice");
		firstQueue.enqueue(55);
		firstQueue.enqueue("jam");
		firstQueue.enqueue(76.8);
		firstQueue.enqueue("sam");
		secondQueue.enqueue("alice");
		secondQueue.enqueue(55);
		secondQueue.enqueue("jam");
		secondQueue.enqueue(76.9);
		secondQueue.enqueue("sam");

		// This statement tests the super class equals method on the first and second
		// Queue
		System.out.println(firstQueue.equals(secondQueue));

		// This statement tests the enqueue method of the Queue class
		secondQueue.enqueue(null);
	}

}
