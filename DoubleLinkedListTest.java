import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * 
 * @author Haowei Chen hxc713
 *
 */
public class DoubleLinkedListTest {
	

	/**
	 * Test the correctness of isEmpty method. 
	 */
	@Test
	public void testIsEmpty() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		assertEquals(false, test.isEmpty());
		assertEquals(true, test1.isEmpty());
	}
	
	/**
	 * Test the correctness of getFront method.
	 */
	@Test
	public void testGetFront() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test1.addToBack("a");
		test1.addToBack("b");
		test2.addToBack("");
		
		
		assertEquals(1, test.getFront().getElement());
		assertEquals("a", test1.getFront().getElement());
		assertEquals("", test2.getFront().getElement());
	}
	
	
	/**
	 * Test the correctness of setFront method.
	 */
	@Test
	public void testSetFront() {
		DoubleLinkedList test = new DoubleLinkedList();
		test.setFront(null);
		assertEquals(null, test.getFront());
	}
	
	
	/**
	 * Test the correctness of getBack method.
	 */
	@Test
	public void testGetBack() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test1.addToBack("a");
		test1.addToBack("b");
		test2.addToBack("");
		
		assertEquals(2, test.getBack().getElement());
		assertEquals("b", test1.getBack().getElement());
		assertEquals("", test2.getBack().getElement());
	}
	
	
	/**
	 * Test the correctness of setBack method.
	 */
	@Test
	public void testSetBack() {
		DoubleLinkedList test = new DoubleLinkedList();
		test.setBack(null);
		assertEquals(null, test.getBack());
	}
	
	/**
	 * Test the correctness of addToFront method.
	 */
	@Test
	public void testAddToFront() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test.addToFront(4);
		test1.addToBack("a");
		test1.addToBack("b");
		test1.addToFront(" ");
		test2.addToBack("");
		test2.addToFront(null);
		
		assertEquals(4,test.getFront().getElement());
		assertEquals(" ",test1.getFront().getElement());
		assertEquals(null,test2.getFront().getElement());
	}
	
	/**
	 * Test the correctness of addToBack method.
	 */
	@Test
	public void testAddToBack() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test.addToBack(4);
		test1.addToBack("a");
		test1.addToBack("b");
		test1.addToBack(" ");
		test2.addToBack("");
		test2.addToBack(null);
		
		assertEquals(4,test.getBack().getElement());
		assertEquals(" ",test1.getBack().getElement());
		assertEquals(null,test2.getBack().getElement());
	}

	/**
	 * Test the correctness of append method.
	 */
	@Test
	public void testAppend() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test1.addToBack("a");
		test1.addToBack(" ");
		test2.addToBack(1);
		test2.addToBack(2);
		test2.addToBack("a");
		test2.addToBack(" ");
		test.append(test1);
		assertEquals(test2, test);
	}
	
	/**
	 * Test the correctness of equals method.
	 */
	@Test
	public void testEquals() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test1.addToBack("a");
		test1.addToBack(" ");
		test2.addToBack(1);
		test2.addToBack(2);
		test2.addToBack("a");
		test2.addToBack(" ");
		test.append(test1);
		assertEquals(true, test.equals(test2));
		assertEquals(false, test.equals(test1));
	}
	
	
	/**
	 * Test the correctness of removeFromFront method.
	 */
	@Test
	public void testRemoveFromFront() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test2.addToBack(1);
		test.removeFromFront();
		test2.removeFromFront();
		assertEquals(2, test.getFront().getElement());
		NoSuchElementException exception = assertThrows(NoSuchElementException.class,
	            ()->{test1.removeFromFront();} );
		assertEquals(null, test2.getFront());
	}
	
	/**
	 * Test the correctness of removeFromBack method.
	 */
	@Test
	public void testRemoveFromBack() {
		DoubleLinkedList test = new DoubleLinkedList();
		DoubleLinkedList test1 = new DoubleLinkedList();
		DoubleLinkedList test2 = new DoubleLinkedList();
		test.addToBack(1);
		test.addToBack(2);
		test2.addToBack(1);
		test.removeFromBack();
		test2.removeFromBack();
		assertEquals(1, test.getFront().getElement());
		NoSuchElementException exception = assertThrows(NoSuchElementException.class,
	            ()->{test1.removeFromFront();} );
		assertEquals(null, test2.getFront());
	}
}
