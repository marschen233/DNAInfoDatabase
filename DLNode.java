/**
 * 
 * @author Haowei Chen hxc713
 *
 * The node of a double linked list.
 *
 * @param <T>
 */
public class DLNode<T> {
  /**
   * The element stored in the node.
   */
  private T element;
  
  /**
   * A pointer to the next node in the list.
   */
  private DLNode<T> next;
  
  /**
   * A pointer to the previous node of the list.
   */
  private DLNode<T> previous;
  
  /**
   * The constructor.  Creates a node and puts it into place in the double linked list.
   * @param element  the element to be stored in the node
   * @param previous the node that will be before this node in the list, or null if no node is before this one
   * @param next  the node that will be after this node in the list, or null of no node will be after this node
   */
  public DLNode(T element, DLNode<T> previous, DLNode<T> next) {
    this.element = element;
    this.next = next;
    this.previous = previous;
    if (next != null) {
      next.setPrevious(this);
    }
    if (previous != null) {
      previous.setNext(this);
    }
  }
 
  /**
   * Get the element stored in this node.
   * @return the element stored in the node
   */
  public T getElement() {
    return element;
  }
  
  /**
   * Gets the node that is before this node in the list.
   * @return  a reference to the node that comes before this node in the list
   */
  public DLNode<T> getPrevious() {
    return previous;
  }

  /**
   * Gets the node that is after this node in the list.
   * @return  a reference to the node that comes after this node in the list
   */
  public DLNode<T> getNext() {
    return next;
  }

  /**
   * Changes the value stored in the node
   * @param element the new value to store in the node
   */
  public void setElement(T element) {
    this.element = element;
  }

  /**
   * Sets the reference to the node that will be after this node in the list.
   * @param node  a reference to the node that will be after this node in the list
   */
  public void setNext(DLNode<T> node) {
    next = node;
  }
  
  /**
   * Sets the reference to the node that will be before this node in the list.
   * @param node  a reference to the node that will be before this node in the list
   */
  public void setPrevious(DLNode<T> node) {
    previous = node;
  }
  
  /**
   * This is an helper method that will compare if two nodes are the same. 
   * @param input
   * @return
   */
  public boolean equals(DLNode<T> input) {
	  if (input.getElement().equals(this.getElement()))
		  return true;
	  else
		  return false;
  }
}
