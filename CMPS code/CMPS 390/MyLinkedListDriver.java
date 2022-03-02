// CMPS390
// MyLinkedListDriver.java
// Kuo-pao Yang
import java.util.*;
public class MyLinkedListDriver {
	public static void main(String args[]) {
		testStringList();
	} // end main
	public static void testStringList() {
		MyLinkedList myList = new MyLinkedList();
		System.out.println("\n<<-- Testing isEmpty() -->>");
		System.out.println("myList.isEmpty() = " + myList.isEmpty());
		System.out.println("\n<<-- Testing add to end -->>");
		System.out.println("myList.add(\"10\") = " + myList.add("10"));
		System.out.println("myList.add(\"20\") = " + myList.add("20"));
		System.out.println("myList.add(\"30\") = " + myList.add("30"));
		System.out.println("myList.add(\"40\") = " + myList.add("40"));
		System.out.println("myList = " + myList);
		System.out.println("\n<<-- Testing add at index -->>");
		System.out.println("myList.add(0, \"50\") = " + myList.add(0, "50"));
		System.out.println("myList.add(2, \"60\") = " + myList.add(2, "60"));
		System.out.println("myList = " + myList);

		System.out.println("\n<<-- Testing remove at index -->>");
		System.out.println("myList.remove(3) = " + myList.remove(3));
		System.out.println("myList = " + myList);
		System.out.println("\n<<-- Testing contains -->>");
		System.out.println("myList.contains(\"30\") = " + myList.contains("30"));
		System.out.println("myList = " + myList);

		System.out.println("\n<<-- Testing getEntry at index -->>");
		System.out.println("myList.getEntry(3) = " + myList.getEntry(3));
		System.out.println("myList = " + myList);
		System.out.println("\n<<-- Testing getIndex -->>");
		System.out.println("myList.getIndex(\"30\") = " + myList.getIndex("30"));
		System.out.println("myList = " + myList);
		System.out.println("\n<<-- Testing remove -->>");
		System.out.println("myList.remove(\"30\") = " + myList.remove("30"));
		System.out.println("myList = " + myList);
		System.out.println("\n<<-- Testing replace at index -->>");
		System.out.println("myList.replace(1, \"70\") = " + myList.replace(1, "70"));
		System.out.println("myList = " + myList);

		System.out.println("\n<<-- Testing equals -->>");
		MyLinkedList yourList = new MyLinkedList();
		System.out.println("yourList.add(\"50\") = " + yourList.add("50"));
		System.out.println("yourList.add(\"70\") = " + yourList.add("70"));
		System.out.println("yourList.add(\"60\") = " + yourList.add("60"));
		System.out.println("yourList.add(\"40\") = " + yourList.add("40"));
		System.out.println("yourList = " + yourList);
		System.out.println("myList.equals(yourList) = " + myList.equals(yourList));
		System.out.println("\nyourList.replace(2, \"80\") = " + yourList.replace(2, "80"));
		System.out.println("yourList = " + yourList);
		System.out.println("myList.equals(yourList) = " + myList.equals(yourList));

	} // end testStringList
} // end TestListSoln

/* OUTPUT
<<-- Testing isEmpty() -->>
myList.isEmpty() = true

<<-- Testing add to end -->>
myList.add("10") = true
myList.add("20") = true
myList.add("30") = true
myList.add("40") = true
myList = 10 20 30 40

<<-- Testing add at index -->>
myList.add(0, "50") = true
myList.add(2, "60") = true
myList = 50 10 60 20 30 40

<<-- Testing remove at index -->>
myList.remove(3) = 20
myList = 50 10 60 30 40

<<-- Testing contains -->>
myList.contains("30") = true
myList = 50 10 60 30 40

<<-- Testing getEntry at index -->>
myList.getEntry(3) = 30
myList = 50 10 60 30 40

<<-- Testing getIndex -->>
myList.getIndex("30") = 3
myList = 50 10 60 30 40

<<-- Testing remove -->>
myList.remove("30") = 30
myList = 50 10 60 40

<<-- Testing replace at index -->>
myList.replace(1, "70") = true
myList = 50 70 60 40

<<-- Testing equals -->>
yourList.add("50") = true
yourList.add("70") = true
yourList.add("60") = true
yourList.add("40") = true
yourList = 50 70 60 40
myList.equals(yourList) = true
yourList.replace(2, "80") = true
yourList = 50 70 80 40
myList.equals(yourList) = false
*/