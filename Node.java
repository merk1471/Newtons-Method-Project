public class Node<T>{
	private T data;
	private Node<T> next;
	
	public Node(T data, Node<T> next) {
		this.next = next;
		this.data = data; 
	}
	
	public Node<T> getNext(){
		return this.next;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setNext(Node<T> newNode) {
		this.next = newNode;
	}
}