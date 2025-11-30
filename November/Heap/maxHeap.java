public class maxHeap {
    static int[] h = new int[100];
    static int hSize = -1;        

    static void insertMax(int element){
        hSize++;       
        if(hSize >= h.length){ throw new RuntimeException("Heap Overflow"); }
        int index = hSize;      // "hSize" is like a permanent / Immutable variable changing it will affect the motive of the code. But we need to change it to put our element at the right index. Therefore "index" is created. It's like a temporary variable. This is similar to the "Head" & "current" variable we use in LinkedList.  
        while(index > 0){   // Except the 1st time, this loop runs for every next call. This condition ensures the loop stops when you reach the root of the heap.
            int parentIndex = (index-1)/2;
            if(element <= h[parentIndex]) break; 
            h[index] = h[parentIndex];
            index = parentIndex;
        }
        h[index] = element;
    }

    static int DeleteMax(){
        int max = h[0];
        int last = h[hSize];
        hSize--;
        int root = 0;

        if(hSize >= 0){
            while(true){
                int leftChildIndex = 2*root + 1;
                if(leftChildIndex > hSize) break;
    
                int rightChildIndex = leftChildIndex + 1;
                int child = (rightChildIndex <= hSize && h[rightChildIndex] > h[leftChildIndex]) ? rightChildIndex : leftChildIndex;  // pick larger one
    
                if(h[child] <= last) break;
                h[root] = h[child];
                root = child;
            }
            h[root] = last;
        }
        return max;
    }
    public static void main(String[] args) {
        insertMax(10);
        insertMax(40);
        insertMax(15);
        System.out.println("Heap array after inserting 10, 40, 15 elements : ");
        for(int i=0; i<=hSize; i++) System.out.print(h[i] + " ");
        System.out.println();
        System.out.println("Elements deleted from heap in following order : ");
        int count = hSize;                 // capture size before deletions so that deletions happens for all the elements. If you put "hSize + 1" in the for loop the last element will not get deleted.
        for(int i=0; i<=count; i++) System.out.print(DeleteMax() + " ");
    }
}