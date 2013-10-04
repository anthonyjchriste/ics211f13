public class Node<E> {
	
	private E data;	//Holds the data for a Node.
	private Node<E> next; //Points to the next Node, if any.
	
	/**
	 * Constructor that sets the Node's data, and next Node pointer.
	 * 
	 * @param data Data to be stored in this node.
	 * @param next Next pointer to the next Node.
	 */
	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}
	
	/**
	 * Constructor that sets the Node's data and sets the next Node pointer to null.
	 * 
	 * @param data Data to be stored in this node.
	 */
	public Node(E data) {
		this(data, null); //Calls the overloaded Node constructor that takes two parameters.
	}
	
	/**
	 * Returns the data at this node.
	 * 
	 * @return Returns the data at this node.
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * Sets this Node's data.
	 * 
	 * @param data The data to be stored in this Node.
	 */
	public void setData(E data) {
		this.data = data;
	}
	
	/**
	 * Returns the next Node of this Node.
	 * 
	 * @return Returns the next Node.
	 */
	public Node<E> getNext() {
		return this.next;
	}
	
	/**
	 * Sets this Node's next Node.
	 * 
	 * @param next The next Node of this Node.
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}