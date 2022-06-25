import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Haowei Chen hxc713
 *
 * @param <T>
 */
public class DoubleLinkedList<T> implements Iterable<T>{


	/** 
	 * a reference to the first node of the double linked list
	 */
	private DLNode<T> front;

	/** 
	 * a reference to the last node of a double linked list
	 */
	private DLNode<T> back;

	/** 
	 * Create an empty double linked list.
	 */
	public DoubleLinkedList() {
		front = back = null;
	}

	/** 
	 * Returns true if the list is empty.
	 * @return  true if the list has no nodes
	 */
	public boolean isEmpty() {
		return (getFront() == null);
	}

	/**
	 * Returns the reference to the first node of the linked list.
	 * @return the first node of the linked list
	 */
	protected DLNode<T> getFront() {
		return front;
	}

	/**
	 * Sets the first node of the linked list.
	 * @param node  the node that will be the head of the linked list.
	 */
	protected void setFront(DLNode<T> node) {
		front = node;
	}

	/**
	 * Returns the reference to the last node of the linked list.
	 * @return the last node of the linked list
	 */
	protected DLNode<T> getBack() {
		return back;
	}

	/**
	 * Sets the last node of the linked list.
	 * @param node the node that will be the last node of the linked list
	 */
	protected void setBack(DLNode<T> node) {
		back = node;
	}

	/**
	 * Add an element to the head of the linked list.
	 * @param element  the element to add to the front of the linked list
	 */
	public void addToFront(T element) {
		DLNode<T> newFront = new DLNode<T>(element, null, null);
		if (this.getFront() != null) {
			this.getFront().setPrevious(newFront);
			newFront.setNext(this.getFront());
			this.setFront(newFront);
		}
		else { 
			this.setBack(newFront);
			this.setFront(newFront);
		}
	}
	
	/**
	 * Override the equals method of Object. Two double linked lists are equal if they contain the same elements in the same order
	 */
	@Override
	public boolean equals(Object e) {
		if (e instanceof DoubleLinkedList) {
			e = (DoubleLinkedList<T>) e;
			DLNode<T> current1 = ((DoubleLinkedList) e).getFront();
			DLNode<T> current2 = this.getFront();
			
			/**
			 * This loop will traverse the list and compare if the data stored in current1 and 2 are equal to each other.
			 */
			while (current1 != null && current2 != null) {
				if (current1.equals(current2)) {
				current1 = current1.getNext();
				current2 = current2.getNext();
				}
				else
					return false;
			}
		}
		return true;
	}
	
	/**
	 * a void method that takes a DoubleLinkedList and appends the nodes of the linked list to the end of the nodes of this list. 
	 * @param e
	 */
	public void append(DoubleLinkedList<T> e) {
		DLNode<T> currentBack = this.getBack();
		DLNode<T> currentFront = e.getFront();
		currentFront.setPrevious(currentBack);
		currentBack.setNext(currentFront);
		 
	}
 
	/**
	 * Add an element to the tail of the linked list.
	 * @param element  the element to add to the tail of the linked list
	 */
	public void addToBack(T element) {
		DLNode<T> newBack = new DLNode<T>(element, null, null);
		if(this.isEmpty() == false){
			newBack.setPrevious(this.getBack());
			this.getBack().setNext(newBack);
			this.setBack(newBack);

		}
		else{
			this.setBack(newBack);
			this.setFront(newBack);
		}
	}

	/**
	 * Remove and return the element at the front of the linked list.
	 * @return the element that was at the front of the linked list
	 * @throws NoSuchElementException if attempting to remove from an empty list
	 */
	public T removeFromFront() throws NoSuchElementException {
		if(this.isEmpty() == true) {
			throw new NoSuchElementException();
		}   
		T firstElement = this.getFront().getElement();    
		if(this.getFront() == this.getBack()) {
			this.setFront(null);
			this.setBack(null);
		}
		else {
			this.setFront(this.getFront().getNext());
			this.getFront().setPrevious(null);
		}
		return firstElement;
	}

	/**
	 * Remove and return the element at the back of the linked list.
	 * @return the element that was at the back of the linked list
	 * @throws NoSuchElementException if attempting to remove from an empty list
	 */
	public T removeFromBack() throws NoSuchElementException {
		if(this.isEmpty() == true) {
			throw new NoSuchElementException();
		}   
		T lastElement = this.getBack().getElement();    
		if(this.getFront() == this.getBack()) {
			this.setFront(null);
			this.setBack(null);
		}
		else {
			this.setBack(this.getBack().getPrevious());
			this.getBack().setNext(null);
		}
		return lastElement;
	}
	
	/**
	 * A helper method to get the size of the list.
	 * @return
	 */
	public int size() {
		ListIterator<T> itr = this.iterator();
		int size = 0;
		
		/**
		 * This loop will increase the size till it equals the length of the list.
		 */
		while(itr.hasNext()) {
			size++;
			itr.next();
		}
		return size;
	}

	/**
	 * Returns an listiterator for the linked list that starts at the head of the list and runs to the tail.
	 * @return  the iterator that runs through the list from the head to the tail
	 */
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>(this);
	}

	
	/**
	 * this method works as an interaction pain
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList<Integer> test = new DoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> test1 = new DoubleLinkedList<Integer>();
		test.addToFront(1);
		test1.addToFront(1);
		test.addToFront(2);
		test1.addToFront(2);
		System.out.println(test.equals(test1));
		System.out.println(test.size());
		
	}
	

}
