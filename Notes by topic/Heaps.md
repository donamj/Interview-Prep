# Heaps

A Min Heap Binary Tree is commonly represented as an array, which is indexed according to the below format: 

| Node          |Position       |
|----------------|--------------|
| Current Node | arr[i]       |
| Parent Node  | arr[(i-1)/2] |
| Left Child   | arr[2*i + 1] |
| Right Child  | arr[2*i + 2] |
<br />


Time complexities of various min heap operations:

|   Function    |	Time Complexity |
|----------------|--------------|
|   get_min()	|   O(1)            |
|   insert_minheap()	|	O(logN)    |
|   delete_minimum()	|	Same as insert – O(logN)    |
|   heapify()	|	O(logN)    |
|   delete_element()	|	O(logN)    |

<br />

### Reference 
https://www.journaldev.com/36805/min-heap-binary-tree
https://www.codespeedy.com/building-heap-from-an-array-in-java/
https://www.techiedelight.com/convert-min-heap-to-max-heap-linear-time/