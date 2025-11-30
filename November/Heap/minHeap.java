/*
In a Heap, we have 2 major applications called "MinHeap" & "MaxHeap".
And According to the conditions of the question the "Insertion" & "Deletion" differs. 

Basically, in a heap:
1. The new element is initially placed at the end (like an array).
2. Then it must adjusted to its correct position by comparing with its parentIndex and swapping if necessary.
3. This upward movement continues until the heap property, i.e, "MinHeap" or "MaxHeap", is satisfied.

Insertion & Deletion in heap takes, O(log n) times.
Because the element may need to traverse up the height of the tree (which is log n levels).
*/

class minHeap {
    static int[] h = new int[100]; // h : heap
    static int hSize = -1; // we start it from -1 cause during "Insertion" we don't use a for loop as we do in Arrays. That's why every time during insertion we'll increase the index.

    static void Insert(int element) {
        hSize++;
        if (hSize >= h.length) { // optional guard. If heap is Overflow
            throw new RuntimeException("Heap overflow");
        }

        int index = hSize;
        while (index > 0) {    // We have put this condition cause during the 1st insertion we neither need to find the parent nor need to swap. 
            int parentIndex = (index - 1) / 2;
            if (element >= h[parentIndex]) break;
            h[index] = h[parentIndex];
            index = parentIndex; // we are updating our "index" to continue comparing our element with the next parent.
        }
        h[index] = element; // INSERT the element at the rightChildIndex position
    }

    static int DeleteMin() {
        // If heap is empty, underflow
        if (hSize < 0) {
            throw new RuntimeException("Heap underflow - no elements to delete");
        }

        int min = h[0]; // smallest element to return
        int last = h[hSize]; // take last element to reinsert
        hSize--; // reduce heap size

        if (hSize >= 0) { // if heap still has elements, percolate down
            int root = 0; // current index where we place 'last'

            while (true) { // "while (true)" creates an infinite loop that's controlled by explicit "break" statements inside.
                int leftChildIndex = 2 * root + 1;
                if (leftChildIndex > hSize){ break; } // condition : no children exist
                
                int rightChildIndex = leftChildIndex + 1;
                int child = (rightChildIndex <= hSize && h[rightChildIndex] < h[leftChildIndex]) ? rightChildIndex : leftChildIndex; // pick smaller child

                if (h[child] >= last){ break;} // if last is <= smaller child, correct spot found

                // move smaller child up
                h[root] = h[child];
                root = child;
            }
            h[root] = last; // place last element in its correct position
        }
        return min;
    }
    public static void main(String args[]) {
        int i;    // Taken "int i" here, just to avoid its repeated declarations in the for-loops. 
        Insert(10);
        Insert(40);
        Insert(15);
        System.out.println("Heap array after inserting 10, 40, 15 elements : ");
        for (i = 0; i < 3; i++)
            System.out.print(h[i] + " ");
        System.out.println();
        Insert(30);
        System.out.println("Heap array after inserting 10, 40, 15, 30 elements : ");
        for (i = 0; i < 4; i++)
            System.out.print(h[i] + " ");
        System.out.println();
        Insert(25);
        System.out.println("Heap array after inserting 10, 40, 15, 30, 25 elements : ");
        for (i = 0; i < 6; i++)
            System.out.print(h[i] + " ");
        System.out.println();
        Insert(35);
        System.out.println("Heap array after inserting 10, 40, 15, 30, 25, 35 elements : ");
        for (i = 0; i < 6; i++)
            System.out.print(h[i] + " ");
        System.out.println();
        System.out.println("Elements deleted from heap in following order : ");
        for (i = 0; i < 6; i++)
            System.out.print(DeleteMin() + " ");
        System.out.println();
    }
}