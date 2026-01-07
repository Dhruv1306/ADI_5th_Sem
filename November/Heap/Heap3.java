// Date: 21 Dec 2025
// MinHeap

import java.util.Scanner;
class Heap3{
    public static void main(String[] args) {
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<7; i++){       // inserting elements in the arr
            int value = sc.nextInt();
            arr[i] = value;
        }

        for(int i=0; i<7; i++){ System.out.print(arr[i] + " ");}     // Printing arr elements
        System.out.println();

        convertMinHeap(arr);
        System.out.print("Array after heapifying: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(arr[i] + " ");
        }
    
        sc.close();
    }

    public static void convertMinHeap(int[] arr){
        int n = arr.length;
        for(int i = n/2-1; i>=0; i++){ heapify(arr, n, i); }
    }
    public static void heapify(int[] arr, int n, int i){

        // ABSOLUTE SAFETY GUARD
        if (i < 0 || i >= n) return;

        int smallest = i;
        int leftChild = 2*i+1;
        int rightChild = leftChild + 1;

        if(leftChild < n && arr[leftChild] < arr[smallest]) smallest = leftChild;
        if(rightChild < n && arr[rightChild] < arr[smallest]) smallest = rightChild;
        if(smallest != i){
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            heapify(arr, n, smallest);
        }
    } 
}