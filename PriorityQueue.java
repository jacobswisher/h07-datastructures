
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 


	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1]:
		numElements = 1;
	}

	public void insert(Interval k) 
    {
      if (numElements == size)
      {    
         size *= 2;
         Interval[] temp = new Interval[size];
         System.arraycopy(heap, 0, temp, 0, size);
         heap = temp;
      }
      heap[numElements] = k;
      siftup(numElements);
      numElements++;
	}
	private void siftup(int que)
	{
	    if (que > 1 && 0 > heap[que].compareTo(heap[que-1]))
	    {
	        swap(que, que-1);
	        siftup(que-1);
	    }
	}
	private void swap(int first, int second)
	{
	    Interval node;
        node = heap[first];
	    heap[first] = heap[second];
	    heap[second] = node;
	}
	public Interval remove_max()
     {
	    if (numElements == 1) return null;
        Interval t = heap[1];
        for (int i = 2; i < numElements + 1; i++)
        {
            heap[i - 1] = heap[i];
        }
        numElements--;
        return t;
	}
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
}
