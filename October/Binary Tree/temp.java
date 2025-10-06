class Node {
    int data;
    Node leftChild;
    Node rightChild;

    Node(int data){
        this.data = data;
        leftChild = rightChild = null;
    }
}

class BinaryUtil {
    // Height calculation
    public static int height(Node root){
        if(root == null) return -1;
        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // Diameter calculation
    public static int diameter(Node root){
        if(root == null) return 0;
        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);

        int leftDiameter = diameter(root.leftChild);
        int rightDiameter = diameter(root.rightChild);
        int overallDiameter = leftHeight + rightHeight + 2;
        
        return Math.max(overallDiameter, Math.max(leftDiameter, rightDiameter));
    }
    
    // Visual representation - Traditional tree format
    public static void printTree(Node root) {
        if (root == null) return;
        printTreeHelper(root, 0);
    }
    
    private static void printTreeHelper(Node root, int level) {
        if (root == null) return;
        
        // Print right subtree first (top)
        printTreeHelper(root.rightChild, level + 1);
        
        // Print current node with proper indentation
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(root.data);
        
        // Print left subtree (bottom)
        printTreeHelper(root.leftChild, level + 1);
    }
    
    // Alternative: ASCII art style tree
    public static void printTreeAscii(Node root) {
        System.out.println("       " + root.data);
        System.out.println("      / \\");
        System.out.println("     " + root.leftChild.data + "   " + root.rightChild.data);
        System.out.println("    / \\");
        System.out.println("   " + root.leftChild.leftChild.data + "   " + root.leftChild.rightChild.data);
        System.out.println("      / \\");
        System.out.println("     " + root.leftChild.rightChild.leftChild.data + "   " + root.leftChild.rightChild.rightChild.data);
    }
}

public class temp {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.leftChild.rightChild.leftChild = new Node(6);
        root.leftChild.rightChild.rightChild = new Node(7);

        System.out.println("Tree Structure (Rotated 90° view):");
        BinaryUtil.printTree(root);
        
        System.out.println("\nTree Structure (ASCII Art):");
        BinaryUtil.printTreeAscii(root);
        
        System.out.println("\nHeight: " + BinaryUtil.height(root));
        System.out.println("Diameter: " + BinaryUtil.diameter(root));
    }
}



/*
 // Visual representation
    public static void printTree(Node root, String prefix, boolean isLast) {
        if (root != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + root.data);
            if (root.leftChild != null || root.rightChild != null) {
                if (root.leftChild != null) {
                    printTree(root.leftChild, prefix + (isLast ? "    " : "│   "), root.rightChild == null);
                }
                if (root.rightChild != null) {
                    printTree(root.rightChild, prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }
 */