// Date: 15 Dec 2025
// "Heap2" is about creating Heap Manually.
// For more explanation, check ques.11 of "Heap" module from ADI.

public class Heap2 {
    public static void main(String[] args) {

        int[] arr1 = { 1, 7, 15, 77, 99, 51, 9, 6 };
        int[] arr2 = arr1.clone();    // Using clone so that MaxHeap & MinHeap don't interfere

        int n = arr1.length;

        convertMaxHeap(arr1, n);
        System.out.print("MaxHeap: ");
        printArray(arr1);

        System.out.println();

        convertMinHeap(arr2, n);
        System.out.print("MinHeap: ");
        printArray(arr2);
    }

    public static void convertMaxHeap(int[] arr, int n){
        // We are just gonna access the parent elements & check whether they are following the respective heap property or not.
        for(int i=n/2-1; i>=0; i++){      // Starts from the last parent element
            maxHeapify(arr, n, i);
        }
    }

    public static void convertMinHeap(int[] arr, int n){
        for(int i=n/2-1; i>=0; i++){
            minHeapify(arr, n, i);
        }
    }

    public static void maxHeapify(int[] arr, int n, int i){     // i = parent node
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;

        if(leftChild < n && arr[leftChild] > arr[largest]) largest = leftChild;
        if(rightChild < n && arr[rightChild] > arr[largest]) largest = rightChild;
        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            maxHeapify(arr, n, largest);
        }
    }

    public static void minHeapify(int[] arr, int n, int i){
        int smallest = i;
        int leftChild = 2*i+1;
        int rightChild = leftChild + 1;

        if(leftChild < n && arr[leftChild] < arr[smallest]) smallest = leftChild;
        if(rightChild < n && arr[rightChild] < arr[smallest]) smallest  = rightChild;
        if(smallest != i){
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            minHeapify(arr, n, smallest);
        }
    }

    public static void printArray(int[] arr){
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}

/* NOTE & Key Takeaways:
    - "length" — property of arrays. Fixed at creation.
    - "size()" — method of Collections (List, Set, Queue, etc.). Changes dynamically.
    - After "n/2-1", all the elements are leaf nodes.
    
    - ❌ Never heapify Max → Min on same array
    - ✅ Always clone or use fresh array
    - 🔁 Heapify uses recursion → unsafe if structure is already heap
    - ⚠️ Integer overflow leads to -2147483648. 
*/