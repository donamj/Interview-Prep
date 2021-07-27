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

