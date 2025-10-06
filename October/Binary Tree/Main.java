import java.util.*;
class Node{
    int data;

    Node leftChild;
    Node rightChild;

    Node(int data){
        this.data = data;
        leftChild = rightChild = null;
    }
}

class BinaryUtil{
    //PreOrder         // Root L R 
    public static void printPreOrder(Node root){
        if( root == null){   // Handling the last case. So that the leaf node's next will be "null". Till here is fine. BUT after that it'll try to go to the next of the "null", where we will get our error. 
            return;
        }
        System.out.println(root.data + " ");
        printPreOrder(root.leftChild);
        printPreOrder(root.rightChild);
    }

    // path.add(root.data);
    // if(root.left == null && root.right == null){                // don't know what's this????
    //     for(char xh :path){
    //         System.out.println(ch = " ");
    //         System.out.println(path.size());
    //         tp++;]
    //     } else {
    //         dfs(root.left, path);
    //         dfs(root.right, path);
    //     }
    // }
    // path.remove();

    public static void printInOrder(Node root){
        // InOrder     // L Root R
        if( root == null){   
            return;
        }
        printInOrder(root.leftChild);
        System.out.println(root.data + " ");
        printInOrder(root.rightChild);
    }

    public static void printPostOrder(Node root){
        // PostOrder    // L R Root
        if( root == null){   
            return;
        }
        printPostOrder(root.leftChild);
        printPostOrder(root.rightChild);
        System.out.println(root.data + " ");
    }

    // Level Order Traversal       // We cannot rely on Recursion for the Level Order Traversal. Cause it'll traverse the whole side first. 
        // We'll use "Queue" Data Structure    // In java we have Priority Queue. We can't create queue directly.
        // 1. Create an empty queue
        // 2. Enqueue "root"
        // 3. While q is not empty
            // 1. Dequeue q -> n       // Here, n = node
            // 2. Traverse n
            // 3. (if left exists)  Add leftChild 
            // 4. (if right exists) Add rightChild
    
    public static void printLevelOrder(Node root){
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node n = q.removeFirst();
            System.out.println(n.data + " ");

            if(n.leftChild != null){
                q.addLast(n.leftChild);
            }
            if(n.rightChild != null){
                q.addLast(n.rightChild);
            }
        }
    }

    // Level Wise Traversal   :  W'll introduce the for loop in the 3rd step.
    public static void printLevelWise(Node root){
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0; i < size; i++){       // For loop
                Node n = q.removeFirst();
                sum += n.data;
                System.out.println("Elements at this level :" + n.data);
    
                if(n.leftChild != null){
                    q.addLast(n.leftChild);
                }
                if(n.rightChild != null){
                    q.addLast(n.rightChild);
                }
            }
            System.out.println("Sum at this level : " + sum);
            System.out.println(); // Print new line after each level
        }
    }

    // Height of a Binary Tree
    public static int Height(Node root){
        if(root == null) return -1;
        int leftHeight = Height(root.leftChild);
        int rightHeight = Height(root.rightChild);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Diameter of a Binary Tree   :  Longest path between 2 leaf nodes. 
    public static int Diameter(Node root){
        if(root == null) return -1;
        int leftHeight = Height(root.leftChild);
        int rightHeight = Height(root.rightChild);

        int leftDiameter = Diameter(root.leftChild);
        int rightDiameter  = Diameter(root.rightChild);

        int newDiameter =  2 + leftHeight + rightHeight;
        return Math.max(newDiameter, Math.max(leftDiameter, rightDiameter));
    }
}


public class Main{
    public static void main(String[] args) {

// Easiest Way to create a Binary tree
        // Node n1 = new Node(1);
        // Node n2 = new Node(2);
        // Node n3 = new Node(3);
        // Node n4 = new Node(4);
        // Node n5 = new Node(5);

        // n1.leftChild = n2;
        // n1.rightChild = n3;

        // n2.leftChild = n4;
        // n2.rightChild = n5;

// Another way  : Just create a root node
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(6);
        root.leftChild.rightChild.leftChild = new Node(7);

        System.out.println("PreOrder");
        BinaryUtil.printPreOrder(root);
        System.out.println("Inorder");
        BinaryUtil.printInOrder(root);
        System.out.println("PostOrder");
        BinaryUtil.printPostOrder(root);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Level Order Traversal :");
        BinaryUtil.printLevelOrder(root);
        System.out.println("Level Wise Traversal :");
        BinaryUtil.printLevelWise(root);
        
        System.out.println("Height of Binary Tree : " + BinaryUtil.Height(root));
        System.out.println();
        System.out.println("Diameter of Binary Tree : " + BinaryUtil.Diameter(root));
    }
}   

/*
 * In BT, we don't have "Insertion" & "Deletion" method. We have it in, BST 
 */