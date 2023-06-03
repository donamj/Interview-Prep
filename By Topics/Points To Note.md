
## Table of Contents
- [Time Complexities](#time-complexities)
- [What is serialization?](#what-is-serialization-)
- [Tips and Tricks](#tips-and-tricks)

<br>

## Time Complexities
1. O(1): Time complexity of a function (or set of statements) is considered as O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function.

2. O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount.

3. O(nc): Time complexity of nested loops is equal to the number of times the innermost statement is executed. 

4. O(Log n) Time Complexity of a loop is considered as O(Log n) if the loop variables is divided / multiplied by a constant amount.

5. O(Log Log n) Time Complexity of a loop is considered as O(Log Log n) if the loop variables is reduced / increased exponentially by a constant amount.

Here are some common time complexities:

* Constant Time: O(1) <br/> 
The algorithm takes a constant amount of time, regardless of the input size. Example: accessing an element in an array by index.

* Logarithmic Time: O(log n) <br/>
  The running time grows logarithmically with the input size. Examples: binary search, certain tree-based operations.

* Linear Time: O(n) <br/>
  The running time grows linearly with the input size. Example: iterating through an array or list.

* Linearithmic Time: O(n log n) <br/>
  The running time grows in a combination of linear and logarithmic growth. Example: efficient sorting algorithms like Merge Sort and Heap Sort.

* Quadratic Time: O(n^2) <br/>
  The running time grows quadratically with the input size. Example: nested loops that iterate over the input.

* Cubic Time: O(n^3) <br/>
  The running time grows cubically with the input size. Example: triple nested loops.

* Exponential Time: O(2^n) <br/>
  The running time grows exponentially with the input size. Example: brute-force solutions that check all possible combinations.


## What is serialization?
Serialization is the process of making the object's state persistent. That means the state of the object is converted into a stream of bytes and stored in a file. In the same way, we can use the deserialization to bring back the object's state from bytes. This is one of the important concepts in Java programming because serialization is mostly used in networking programming. The objects that need to be transmitted through the network have to be converted into bytes. For that purpose, every class or interface must implement the Serializable interface. It is a marker interface without any methods.

<br>**Now what is the transient keyword and its purpose?**<br>
By default, all of object's variables get converted into a persistent state. In some cases, you may want to avoid persisting some variables because you don't have the need to persist those variables. So you can declare those variables as transient. If the variable is declared as transient, then it will not be persisted. That is the main purpose of the transient keyword.

## Tips and Tricks
- **To find pivot element:** leftSum == sum - leftSum - nums[i]

- **Convert char to number:** char - '0'

- **Convert number to char:** char + '0'

- **Row Offset in a 2d array:** <br>
  // Explore neighbor cells in around-clock directions: up, right, down, left <br>
  int[] rowOffset = {-1, 0, 1, 0}; <br>
  int[] colOffset = {0, 1, 0, -1};

- **Permutations and combinations:** <br>Whenever you have a problem where you need to generate all combinations/permutations of some group of letters/numbers, the first thought you should have is backtracking. Backtracking algorithms can often keep the space complexity linear with the input size.

- **Interpolation search formula:**  Mid = (data – low) / (high – low)

- Searching can be optimized by using Hashing techniques

- **BFS:**  Use queue

- **Shortest distance:** BFS – Use queue

- Use String.valueOf() to convert array to string

- Use Arrays.sort(arrayName)

- String concat method has O(n^2) complexity

- When comparing a constant and a string variable using equalsIgnoreCase( ), use constant.equalsIgnoreCase(variable). If we invoke on the variable, if the variable is null, it throws an exception as method can't be invoked on null.

- One of the best ways I find for approximating the complexity of the recursive algorithm is drawing the recursion tree. Once you have the recursive tree:<br>
  Complexity of recursion = length of tree from root node to leaf node * number of leaf nodes
    1. If there are k nested loops, the time complexity is O(n^k).
    2. If all the nodes in the tree is processed once - O(nlog n)

- **Is arithmetic shift:** (n >> 1 == n / 2 for positive and negative numbers),
- **Is logical shift:** (adding 0 to the highest bits). 
