public class tempMax {
    static int[] h = new int[100];
    static int hSize = -1;

    static void Insert(int element){
        hSize++;
        int index = hSize;
        while(index > 0){
            int parentIndex = (index-1)/2;
            if(element <= h[parentIndex]) break;
            h[index] = h[parentIndex];
            index = parentIndex;
        }
        h[index] = element;
    }

    static void displayHeap(){
        System.out.print("Max Heap: ");
        for(int i=0; i<=hSize; i++){
            System.out.print(h[i] + " ");
        }
        System.out.println();     // Just for an extra line in the terminal
    }

    static void Delete(){
        int count = hSize;      //  We need cause hSize is keep decreasing inside which will affect the loop. 
        System.out.print("Deleting order: ");
        for(int i=0; i<=count; i++){
            int max = h[0];
            int last = h[hSize];
            hSize--;
            int root = 0;
            if(hSize >= 0){
                while(true){
                    int leftChildIndex = 2*root + 1;
                    if(leftChildIndex > hSize) break;
                    int rightChildIndex = leftChildIndex + 1;
                    int child = (rightChildIndex <= hSize && h[rightChildIndex] > h[leftChildIndex]) ? rightChildIndex : leftChildIndex;
                    if(h[child] <= last) break;
                    h[root] = h[child];
                    root = child;
                }
                h[root] = last;
            }
            System.out.print(max + " ");
        }
    }
    public static void main(String[] args) {
        Insert(10);
        Insert(40);
        Insert(15);
        Insert(30);
        Insert(25);
        Insert(35);
        displayHeap();
        Delete();
    }
}