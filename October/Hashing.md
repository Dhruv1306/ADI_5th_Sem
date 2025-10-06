## Hashing

- Keys :- Values are to be stored
- Hash Function :- Mathematicalfn. O(1)
- Hash Table

---

- Optimize Searching O(1)
- Collision  (like avoidance )
- Collision Resolution Techniques

---

### Keys    ( Ex. where no collision happen )

21

17

9

3

81

12

19

49

51

33


---



### Hash Function

K Mod N

Key % Size of Hash Table


---



### Hash Table

Size N = 11


| col1 | col2     |
| ---- | -------- |
| 0    | 33       |
| 1    | 12       |
| 2    | K        |
| 3    | 3        |
| 4    | 81       |
| 5    | 49       |
| 6    | 17       |
| 7    | 51       |
| 8    | 19       |
| 9    | 9        |
| 10   | 21<br /> |


---

### Searching

Let's say we wnt to search "3", "81"

3  ->  HF [O(1)]  -> INDEX     :-        3 % 11  => 3

81 % 11  =>  4

---

### Hash Functions

1. Division Method
   1. k  Mod 10
   2. K Mod N
2. Multiplication Method
   1. floor(n * ( K * A mod 1))

      where;  0 < A < 1
      n = 10
      A = 0.6
      K =1234
      K = 5678
3. Mid square Method
   1. Key Square
   2. Mid Value
4. Folding Method
   1. Divide No. into group
   2. Sum
   3. Sum % N

---



1. Linear Probing
2. Quadratic Probing
3. Separate Chaining
4. Double Hashing


- (Key ++) % M
  Advantage : -  No extera space used
  Disadvantage :- Formation of cluster which increase complexity of searching.
  size of cluster  ~~ size of table
  O(n)

Therefore, we use Quadratic Probing
