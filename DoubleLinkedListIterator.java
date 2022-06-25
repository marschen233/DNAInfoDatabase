/**
 * 
 * @author Haowei Chen hxc713
 *
 * @param <T>
 */
public class DoubleLinkedListIterator<T> implements java.util.ListIterator<T> {

	// nodeptr marks the current node as we are iterating
	private DLNode<T> nodeptr;
	private DLNode<T> last;
	private DLNode<T> node;

	/**
	 * Create an iterator for a linked list
	 * @param list the list we are creating an iterator for
	 */
	public DoubleLinkedListIterator(DoubleLinkedList<T> list) {
		nodeptr = list.getFront();
		last = list.getBack();
	}

	
	/**
	 * add the input to the current linked list
	 */
	@Override
	public void add(T e) {
		if (nodeptr == null)
			return;
		else {
			last.setNext(node);
			last = node;
		}
			
	}
	
	
	
	
	/**
	 * Returns true if there are more elements in the iteration
	 * @return true if there are more elements in the iteration
	 */
	@Override
	public boolean hasNext() {
		return nodeptr != null;
	}
	
	
	/**
	 * Returns true if there are previous elements in the iteration
	 */
	@Override
	public boolean hasPrevious() {
		return last != null;
	}

	/**
	 * Returns the next element of the iteration and "increments" the iteration
	 * @return the next element of the iteration
	 */
	@Override
	public T next() {
		T save = nodeptr.getElement();
		nodeptr = nodeptr.getNext();
		return save;
	}
	
	/**
	 * Returns the previous element of the iteration and "increments" the iteration
	 */
	@Override
	public T previous() {
		T save = last.getElement();
		last = last.getPrevious();
		return save;
	}
	
	
	/**
	 * set the previous or next to the return value
	 */
	@Override
	public void set(T e) {
		if (nodeptr.getNext() == null) {
			throw new IndexOutOfBoundsException();
		}
		nodeptr.getPrevious().setElement(e);
	}
	

	

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	/**
	 * this method works as an interaction pain
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
