import java.util.Stack;
import java.util.NoSuchElementException;

/*
 * Queue with two stacks. Implement a queue with two stacks so that each queue
 * operations takes a constant amortized number of stack operations.
 * 
 * Elements are pushed a maximum of 2 times and popped a maximum of 2 times.
 */
public class Queue<T> {
	private Stack<T> s1;	// push into back of queue
	private Stack<T> s2;	// pop from front of queue
	private int size;		// size of the stack
	
	public Queue() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T peek() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
		}
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}
	
	// Inserts data into back of queue
	public void enqueue(T data) {
		s1.push(data);
		size = size + 1;
	}
	
	// Removes data from the front of queue
	public T dequeue() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
		}
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		size = size - 1;
		return s2.pop();
	}
	
	public static void main(String[] args) {
		/*
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		*/
	}
}
