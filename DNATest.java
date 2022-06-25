import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * 
 * @author Haowei Chen hxc713
 *
 */
public class DNATest {

	/**
	 * Test the correctness of the toString method.
	 */
	@Test
	public void testToString() {
		DNA input = new DNA();
		input.addToFront(DNA.Base.A);
		input.addToBack(DNA.Base.C);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		
		assertEquals("ACGTGT", input.toString());
	}
	
	
	/**
	 * Test the correctness of the string2DNA method.
	 */
	@Test
	public void testString2DNA() {
		DNA input = new DNA();
		String s = new String();
		s = "ACGTCTC";
		assertEquals("ACGTCTC", input.string2DNA(s).toString() );
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
	            ()->{input.string2DNA("ACST");} );
		
	}
	
	/**
	 * Test the correctness of the Splice method.
	 */
	@Test
	public void testSplice() {
		DNA input = new DNA();
		input.addToFront(DNA.Base.A);
		input.addToBack(DNA.Base.C);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		
		DNA input1 = new DNA();
		input1.addToBack(DNA.Base.G);
		input1.addToBack(DNA.Base.T);
		
		input1.splice(input, 2);
		assertEquals("GTGTGT", input1.toString());
		assertEquals("GTGT", input.toString());
		
	}
	
	
	/**
	 * Test the correctness of the overlaps method.
	 */
	@Test
	public void testOverlaps() {
		DNA input = new DNA();
		input.addToFront(DNA.Base.A);
		input.addToBack(DNA.Base.C);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		
		DNA input1 = new DNA();
		input1.addToFront(DNA.Base.G);
		input1.addToBack(DNA.Base.T);
		input1.addToBack(DNA.Base.G);
		input1.addToBack(DNA.Base.T);
		input1.addToBack(DNA.Base.A);
		input1.addToBack(DNA.Base.C);
		
		assertEquals(true, DNA.overlaps(input1, input, 2));
		assertEquals(false, DNA.overlaps(input1, input, 3));
	}
	
	/**
	 * Test the correctness of the main method.
	 */
	@Test
	public void testMain() {
		DNA input = new DNA();
		input.addToFront(DNA.Base.A);
		input.addToBack(DNA.Base.C);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		input.addToBack(DNA.Base.G);
		input.addToBack(DNA.Base.T);
		
		DNA input1 = new DNA();
		input1.addToFront(DNA.Base.G);
		input1.addToBack(DNA.Base.T);
		input1.addToBack(DNA.Base.G);
		input1.addToBack(DNA.Base.T);
		input1.addToBack(DNA.Base.A);
		input1.addToBack(DNA.Base.C);
		
		DNA input2 = new DNA();
		input2.addToFront(DNA.Base.A);
		input2.addToBack(DNA.Base.C);
		input2.addToBack(DNA.Base.G);
		input2.addToBack(DNA.Base.T);
		
		DNA input3 = new DNA();
		input3.addToFront(DNA.Base.A);
		input3.addToBack(DNA.Base.C);
		input3.addToBack(DNA.Base.G);
		input3.addToBack(DNA.Base.T);
		input3.addToBack(DNA.Base.G);
		input3.addToBack(DNA.Base.T);
		
		DNA.main(input, input1);
		DNA.main(input3, input2);
		
		assertEquals("TGT", input.toString());
		assertEquals("GTGTACTGT", input1.toString());
		assertEquals("ACGTCGTGT", input2.toString());
		
	}

}
