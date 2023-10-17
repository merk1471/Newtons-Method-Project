public class OrderedLinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private int size;
	
	public OrderedLinkedList(){
		Node<T> newNode = head;
		
		
	}
	
	public void insert(T val) {
		int place = 0; 
		
		   Node<T> newNode = new Node<>(val, null);

		    if (head == null || head.getData().compareTo(val) < 0) {
		        // Insert at the beginning of the list or into an empty list
		        newNode.setNext(head);
		        head = newNode;
		    } else {
		        Node<T> current = head;
		        Node<T> previous = null;

		        while (current != null && current.getData().compareTo(val) > 0) {
		            previous = current;
		            current = current.getNext();
		        }

		        // Insert between previous and current
		        previous.setNext(newNode);
		        newNode.setNext(current);
		    }

		    size++; // Don't forget to update the size of the list.
		}
	
	
		
		
	
	
	public T get(int i) throws IndexOutOfBoundsException {
		size = getSize();
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
		for (int j = 0;j<i;j++) {
			
			if (j != i) {
				++j;
				head = head.getNext();
				
			}
			
								}
		}
		return (head.getData());
		}
	
	
	public int getSize() {
		return size;
	}
}

