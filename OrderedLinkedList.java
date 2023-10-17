public class OrderedLinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private int size;
	
	public OrderedLinkedList(){
		head = null;
		size = 0;
		
	}
	
	public void insert(T val) {
		Node<T> newNode = new Node<>(val, null);
		while (head.getNext() != null && (head.getData()).compareTo(val)>0) {
			
			if (head.getNext() == null) {
				break;
			}
			else {
				head = head.getNext();
			}
		
	}
		if (head.getNext() == null) {

			head.setNext(newNode);
			
			newNode.setNext(head);
		}
		
	
	}
		
		
	
	
	public void get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int getSize() {
		return size;
	}
}