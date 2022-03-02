// CMPS390
// MinHeapDriver.java
// Kuo-pao Yang
/* s = {"D", "F", "I", "C", "H", "A", "E", "J", "B", "G"};
  	  A
     / \
    B   C
   / \ / \
  D  G I  E
 / \ /
J  F H
 The Min Heap has 10 items
 A B C D G I E J F H
*/
public class MinHeapDriver {
	public static void main(String[] argv) {
		MinHeap aHeap = createMinHeap();
		testMinHeapOperations(aHeap);
	} // end main

public static MinHeap createMinHeap() {
	MinHeap aHeap = new MinHeap();
	String[] s = {"C", "H", "J", "F", "B", "G", "D", "I", "A", "E"};
	System.out.println("Testing add()");
	for (int i=0; i < s.length; i++) {
		System.out.print(s[i] + " ");
		aHeap.add(s[i]);
	}
	aHeap.display();
	return aHeap;
} // creatMinHeap

public static void testMinHeapOperations(MinHeap aHeap) {
	System.out.println("Testing isEmpty() returns = " + aHeap.isEmpty() + "(should be false)");
			System.out.println("Testing getMin() returns = " + aHeap.getMin() + "(should be A)");
					System.out.println("Removing entries in descending order:");
			while (!aHeap.isEmpty()) {
				System.out.print(aHeap.removeMin() + " ");
			}
			System.out.println("(should be A B C D E F G H I J)");
 	} // end testMinHepOperations
} // end MinHeapDriver
/* OUTPUT
 Testing add()
 D F I C H A E J B G
 The Min Heap has 10 items
 A B C D G I E J F H
 Testing isEmpty() returns = false (should be false)
 Testing getMin() returns = A (should be A)
 Removing entries in descending order:
 A B C D E F G H I J (should be A B C D E F G H I J)
*/