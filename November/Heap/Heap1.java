// Date: 15 Dec 2025
// "Heap1" is about creating Heap using In-built methods. Using "PriorityQueue".

import java.util.*;

public class Heap1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();     // By default a PriorityQueue is a "minHeap". 
        minHeap.addAll(Arrays.asList(10, 4, 7, 1, 3)); // "addAll" expects a "Collection". Therefore, we use "asList" method from "Arrays" class.
        System.out.print("MinHeap: " + minHeap);

        System.out.println(); 

        // Creating a maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   
        maxHeap.addAll(minHeap);
        System.out.println("MaxHeap: " + maxHeap);
        System.out.println();
        while(!maxHeap.isEmpty()) System.out.print(maxHeap.poll() + " ");
    }
}

/* NOTE:
        - "System.out.println(maxHeap)" : prints the internal array representation of the heap (level-order traversal of the tree structure).
        - "maxHeap.poll()" -  extracts elements in sorted order (largest to smallest for maxHeap).
        - PriorityQueue always maintains heap structure, not insertion order.
*/