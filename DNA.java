import java.util.ListIterator;

/**
 * 
 * @author Haowei Chen hxc713
 *
 */
public class DNA extends DoubleLinkedList<DNA.Base> {

	/**
	 * Declare a new doublelinkedlist to store current list.
	 */
	DoubleLinkedList<Base> current = new DoubleLinkedList<Base> ();

	/**
	 * give A C G T type value
	 * @author Haowei Chen hxc713
	 *
	 */
	public enum Base {
		A, C, G, T;	  
	}

	/**
	 * This method will returns a String representation of the DNA. The string should be
	 *  the letters (without spaces) representing the amino acids
	 */
	public String toString() {
		StringBuilder str = new StringBuilder(); 

		/**
		 * append to string
		 */
		for (DNA.Base dna: this) {
			str.append(dna);
		}
		return str.toString();
	}


	/**
	 * 
	 * @param s
	 * @return returns a the DNA sequence represented by the String.
	 * @throws IllegalArgumentException
	 */
	public static DNA string2DNA(String s) throws IllegalArgumentException {
		DNA output = new DNA();

		/**
		 * this loop will append each character inside the string to its proper DNA.Base value
		 */
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				output.addToBack(Base.A);
			}
			else if (s.charAt(i) == 'C') {
				output.addToBack(Base.C);
			} 
			else if (s.charAt(i) == 'G') {
				output.addToBack(Base.G);
			}
			else if (s.charAt(i) == 'T') {
				output.addToBack(Base.T);
			}
			else {
				System.out.println(s.charAt(i));
				throw new IllegalArgumentException();
			}
		}
		return output;
	}

	/**
	 * remove numbases from the start of dna and then append the remaining bases of dna to the end of this DNA. 
	 * If dna has fewer than numbases bases, then nothing is appended. The parameter dna may be destroyed by this method.
	 * @param dna
	 * @param numbases
	 */
	public void splice(DNA dna, int numbases) {
		ListIterator<Base> itr = this.iterator();
		int ptr = 0;
		Base next = itr.next();

		/**
		 * This loop will undergo the process of splicing. 
		 */
		while(itr.hasNext()) {
			ptr = ptr +1;
			if (ptr <= numbases) {
				dna.removeFromFront();
				this.append(dna);
			}
			else if (ptr > numbases) {
				return;
			}
			next = itr.next();
		}

	}


	/**
	 * 
	 * @param dna1 A DNA type list.
	 * @param dna2 A DNA type list.
	 * @param n
	 * @return returns true if the last n bases of dna1 exactly match the first n bases of dna2. Returns false if there is no such match.
	 */
	public static boolean overlaps(DNA dna1, DNA dna2, int n) {
		ListIterator<Base> itr1 = dna1.iterator();
		ListIterator<Base> itr2 = dna2.iterator();
		int ptr = 0;
		int ptr1 = n;

		/**
		 * This loop will move the nodeptr to the n from the last node(position)
		 */
		while (itr1.hasNext() && ptr < (dna1.size() - n)) {
			itr1.next();
			ptr++;
		}

		/**
		 * This loop will compare if two n nodes are equal.
		 */
		while (itr1.hasNext() && itr2.hasNext() && ptr1 >= 0) {
			ptr1 = ptr1 - 1;
			DNA.Base current = itr1.next();
			DNA.Base current1 = itr2.next();
			if(!current.equals(current1)) {
				return false;

			}
		}

		return true;
	}


	/**
	 * Takes two strings that represent DNA sequences, determines the greater overlap, the end of the first 
	 * to the start of the second or the end of the second to the start of the first. The method then performs 
	 * the appropriate splicing to create the minimum DNA sequence that splices the two strings and prints the 
	 * result. The main method should not throw any exceptions. Instead, if bad data is entered, the method 
	 * should print an appropriate message.
	 * @param dna1 A DNA type list.
	 * @param dna2 A DNA type list.
	 */
	public static void main(DNA dna1, DNA dna2) {
		int s1 = dna1.size();
		int s2 = dna2.size();
		int length = 0;
		int length1 = 0;

		/**
		 * This loop will undergo the seqeuence of splicing. 
		 */
		for (int i = 0; i < s1; i++) {
			if ( DNA.overlaps(dna1, dna2, i) == true) {
				length++;
			}
			else if ( DNA.overlaps(dna1, dna2, i) == false) {
				i =s1;
			}

		}
		for (int i = 0; i < s2; i++) {
			if (DNA.overlaps(dna1, dna2, i)) {
				length1++;

			}
			else if (DNA.overlaps(dna1, dna2, i)) {
				i = s2;
			}
		}

		if (length > length1) {
			dna1.splice(dna2, length);
		}
		if (length <= length1) {
			dna2.splice(dna1, length1);
		}
	}




	/**
	 * this method works as an interaction pain
	 * @param args
	 */
	public static void mainArg(String[] args) {
		// TODO Auto-generated method stub
		DNA input = new DNA();
		input.addToFront(Base.A);
		input.addToBack(Base.C);
		input.addToBack(Base.G);
		input.addToBack(Base.T);
		input.addToBack(Base.G);
		input.addToBack(Base.T);
		System.out.println(input.toString());

		try {
			System.out.println(DNA.string2DNA("ACT").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
