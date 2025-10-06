## Tree

- Binary Tree
- Types
- Traversals


- BST
  - Insertion
  - Deletion
  - Traversal

| Physical    | Logical        |
| ----------- | -------------- |
| Arrays & LL | Stack & Queue  |
| Linear      | Non-Linear     |
| Sequential  | Non-Sequential |


- Root node :- Special type of node with no parent
- Leaf Node :- Nodes with no children
- Intermeddiate / Non-leaf node :- nodes which have both children & parent.
- edge :- Connection between nodes   (Also, In java, they are Reference,    In c++, they are Address. )
- Tree : Height = 3 & depth = 3
- Root : Height = 3 & Depth = 0.


### Binary Tree

**Condition** : Atmost 2 children for each node.


**Types of binary tree** :  GFG Article. 

A. On the basis of  `no. of children`

    1. Strict / Full Binary Tree  :  either 0 or 2
2. Degenerated Tree : Single child

- Left Skewed
- Right Skewed

B. On the basis of `Completion of levels`

1. Complete BT  : Intermediate levels are full. The last level, i.e, leaf node, will `first` fill the `Left side node` than the right side node  that too from the left side.

***Heap is a Complete Binary Tree***

2. Perfect BT : All the levels should be completely full.     ( Formula  :  2^n  -  1)
3. Balanced BT  :  Every node should be balanced.      (Left Height  -  Right Height)  >= 1

***AVL is based on Balanced BT***

C. On the basis of `Value of Node`	

1. BST     :  In this the Left side node's value should be smaller than right side node's value.
2. AVL
3. RED Black


## Tree Traversal

NOTE : We need to fix the preference of the nodes.


| BST                                 | DFT                             |
| ----------------------------------- | ------------------------------- |
| We travers the siblings first       | We traverse the children first  |
| Level order Traversal               | Pre-Order Traversal :- Root L R |
| It traverses from `Left to Right` | In Order :-  L Root R         |
|                                     | Post-Order :- L R Root          |


### DFT Question

Pre-Order :- 1, 7, 12, 8, 4, 19, 9       |        Root, X, A, B, P, Q, Y, D, C, R, T, S

In-Order :- 8, 12, 4, 7, 19, 1, 9         |        A, X, P, B, Q, Root, D, Y, T, R, C, S

Post-Order :- 8, 4 ,12, 19, 7, 9, 1     |       A, P, Q, B, X, D, T, R, S, C, Y, Root


Let's do the reverse of the same question.
