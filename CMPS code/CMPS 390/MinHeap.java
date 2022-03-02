// CMPS390
// MinHeap.java
// Complete 4 methods: getMin, add, removeMin, reheap
public class MinHeap {
	private Comparable [] heap; // array of heap entries
	private static final int DEFAULT_MAX_SIZE = 100;
	private int lastIndex; // index of last entry
 
	public MinHeap() {
		heap = new Comparable[DEFAULT_MAX_SIZE];
		lastIndex = 0;
	} // end default constructor
 
	public MinHeap(int maxSize) {
		heap = new Comparable[maxSize];
		lastIndex = 0;
	} // end constructor
 
	public MinHeap(Comparable[] entries) {
		lastIndex = entries.length;
		heap = new Comparable[lastIndex + 1];
		// copy given array to data field
		for (int index = 0; index < entries.length; index++) {
			heap[index+1] = entries[index];
		}
		// create heap
		for (int index = heap.length/2; index > 0; index--) {
			reheap(index);
		}
	} // end constructor
 
	public Comparable getMin() {
		Comparable root = null;
		// ADD YOUR CODE HERE
		if (!isEmpty())
			root = heap[1];
		return root;
	} // end getMin
 
	public boolean isEmpty() {
		return lastIndex < 1;
	} // end isEmpty
 
	public int getSize() {
		return lastIndex;
	} // end getSize
 
	public void clear() {
		for (; lastIndex > -1; lastIndex--) {
			heap[lastIndex] = null;
		}
		lastIndex = 0;
	} // end clear
	
	 private void swap(int fpos, int spos) 
	    { 
	        Comparable tmp; 
	        tmp = heap[fpos]; 
	        heap[fpos] = heap[spos]; 
	        heap[spos] = tmp; 
	    } 
 
	public void add(Comparable newEntry) {
		// ADD YOUR CODE HERE

		
		int newIndex = ++lastIndex;
		int parentIndex = newIndex / 2;
		while ((newIndex > 1) && newEntry.compareTo(heap[parentIndex]) < 0)	{
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		} // end while		
		heap[newIndex] = newEntry;
		
	} // end add
 
	public Comparable removeMin() {
		Comparable root = null;
		// ADD YOUR CODE HERE
		if (!isEmpty()) {
			root = heap[1]; // return value
			heap[1] = heap[lastIndex ]; // form a semiheap
			lastIndex--; // decrease size
			reheap(1); // transform to a heap
		} // end if		
		return root;
	} // end removeMin
	
	private void reheap(int rootIndex) {
		// ADD YOUR CODE HERE
		boolean done = false;
		Comparable orphan = heap[rootIndex];
		int largerChildIndex = 2 * rootIndex;  // index of left child, if any
		while (!done && (largerChildIndex <= lastIndex) )	{
			int rightChildIndex = largerChildIndex + 1;
			if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) < 0)
				largerChildIndex = rightChildIndex;
			if (orphan.compareTo(heap[largerChildIndex]) > 0) {
				heap[rootIndex] = heap[largerChildIndex];	
				rootIndex = largerChildIndex;
				largerChildIndex = 2 * rootIndex; // index of next left child
			}
			else
				done = true;
		} // end while		
		heap[rootIndex] = orphan;
	} // end reheap
 
	public void display() {
		int size = getSize();
		System.out.println("\nThe Min Heap has " + size + " items");
		for (int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " " );
		}
		System.out.println();
	} // end display
} // end MinHeap