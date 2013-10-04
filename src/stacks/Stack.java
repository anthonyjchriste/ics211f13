public class Stack<E> {

	private Node<E> top; //Keeps track of what's currently on top of the Stack.
	private int size;
	
	/**
	 * Constructor that creates an empty Stack.
	 */
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	
	/**
	 * Pushes an item on top of the Stack.
	 * 
	 * @param item An item to be pushed on top of the Stack.
	 */
	public void push(E item) {
		this.top = new Node<E>(item, top);
		this.size++;
	}
	
	/**
	 * Returns whats on top of the stack.  Throws an exception if the Stack is empty.
	 * 
	 * @return Returns whats on top of the Stack.
	 */
	public E peek() {
		if(this.top == null) {
			throw new IllegalStateException("Can't peek() into an empty stack.");
		}
		return this.top.getData();
	}
	
	/**
	 * Removes and returns the item on top of the Stack.  Throws an exception if the Stack is empty.
	 * 
	 * @return Returns the item on top of the Stack.
	 */
	public E pop() {
		if(this.top == null) {
			throw new IllegalStateException("Can't peek() into an empty stack.");
		}
		E data = this.top.getData(); //Temporary variable to hold the item we need to return
		this.top = this.top.getNext(); //Removes the top item
		this.size--;
		return data;
	}
	
	/**
	 * Returns the size of the Stack.
	 * 
	 * @return Returns the size of the Stack.
	 */
	public int size() {
		return this.size;
	}

}
