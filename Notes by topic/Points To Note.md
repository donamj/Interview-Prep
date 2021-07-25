## Table of Contents
- [Comparison b/w QuickSort and MergeSort](#comparison-b-w-quicksort-and-mergesort)
- [Time Complexities](#time-complexities)
- [What is serialization?](#what-is-serialization-)
- [Hashmap vs Hashtable](#hashmap-vs-hashtable)
- [Compare DFS and BFS](#compare-dfs-and-bfs)
- [DFS algorithm works in the following way](#dfs-algorithm-works-in-the-following-way)
- [BFS algorithm works in the following way](#bfs-algorithm-works-in-the-following-way)
- [Topological Sort](#topological-sort)

<br>

## Comparison b/w QuickSort and MergeSort
- Although both Quicksort and Mergesort have an average time complexity of O(n log n), Quicksort is the preferred algorithm, as it has an O(log(n)) space complexity. Mergesort, on the other hand, requires O(n) extra storage, which makes it quite expensive for arrays. <br>

- Quicksort requires to access different indices for its operations, but this access is not directly possible in linked lists, as there are no continuous blocks; therefore to access an element we have to iterate through each node from the beginning of the linked list. Also, Mergesort is implemented without extra space for LinkedLists.

## Time Complexities
1. O(1): Time complexity of a function (or set of statements) is considered as O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function.

2. O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount. For example following functions have O(n) time complexity.

3. O(nc): Time complexity of nested loops is equal to the number of times the innermost statement is executed. For example the following sample loops have O(n2) time complexity

4. O(Logn) Time Complexity of a loop is considered as O(Logn) if the loop variables is divided / multiplied by a constant amount.

5. O(LogLogn) Time Complexity of a loop is considered as O(LogLogn) if the loop variables is reduced / increased exponentially by a constant amount.

## What is serialization?
Serialization is the process of making the object's state persistent. That means the state of the object is converted into a stream of bytes and stored in a file. In the same way, we can use the deserialization to bring back the object's state from bytes. This is one of the important concepts in Java programming because serialization is mostly used in networking programming. The objects that need to be transmitted through the network have to be converted into bytes. For that purpose, every class or interface must implement the Serializable interface. It is a marker interface without any methods.

<br>**Now what is the transient keyword and its purpose?**<br>
By default, all of object's variables get converted into a persistent state. In some cases, you may want to avoid persisting some variables because you don't have the need to persist those variables. So you can declare those variables as transient. If the variable is declared as transient, then it will not be persisted. That is the main purpose of the transient keyword.

## Hashmap vs Hashtable
1. HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.

2. HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.

3.  HashMap is generally preferred over HashTable if thread synchronization is not needed

**Why HashTable doesn’t allow null and HashMap does?** <br>
To successfully store and retrieve objects from a HashTable, the objects used as keys must implement the hashCode method and the equals method. Since null is not an object, it can’t implement these methods. HashMap is an advanced version and improvement on the Hashtable. HashMap was created later.

## Compare DFS and BFS
- BFS considers all neighbors first and therefore not suitable for decision making trees used in games or puzzles.
- DFS is more suitable for game or puzzle problems. We make a decision, then explore all paths through this decision. And if this decision leads to win situation, we stop.
	
	
## DFS algorithm works in the following way
Most of the concepts in computer science can be visualized and represented in terms of graph data structure. DFS is one such useful algorithm for analysing these problems easily.
- Solving maze-like puzzles with only one solution: DFS can be used to find all solutions to a maze problem by only considering nodes on the current path in the visited set.

- Topological Sorting:
	- This is mainly used for scheduling jobs from the given dependencies among jobs. DFS is highly preferred approach while finding solutions to the following type of problems using Topological Sort:
		- instruction/job scheduling
		- ordering of formula cell evaluation when recomputing formula values in spreadsheets
		- determining the order of compilation tasks to perform in makefiles
		- data serialization
		- resolving symbol dependencies in linkers
	- Mapping Routes and Network Analysis
	- Path Finding: DFS is used for finding path between two given nodes - source and destination - in a graph.
	- Cycle detection in graphs

## BFS algorithm works in the following way
Most of the concepts in computer science and real world can be visualized and represented in terms of graph data structure. BFS is one such useful algorithm for solving these problems easily. The architecture of BFS is simple, accurate and robust. It is very seamless as it is guaranteed that the algorithm won’t get caught in an infinite loop.
- **Shortest Path:** In an unweighted graph, the shortest path is the path with least number of edges. With BFS, we always reach a node from given source in shortest possible path. Example: Dijkstra’s Algorithm.

- **GPS Navigation Systems:** BFS is used to find the neighboring locations from a given source location.

- **Finding Path:** We can use BFS to find whether a path exists between two nodes.

- **Finding nodes within a connected component:** BFS can be used to find all nodes reachable from a given node.
	
- **Social Networking Websites:** We can find number of people within a given distance ‘k’ from a person using BFS.

- **P2P Networks:** In P2P (Peer to Peer) Networks like BitTorrent, BFS is used to find all neighbor nodes from a given node.

- **Search Engine Crawlers:** The main idea behind crawlers is to start from source page and follow all links from that source to other pages and keep repeating the same. DFS can also be used here, but Breadth First Traversal has the advantage in limiting the depth or levels traversed.


## Topological Sort
All pairs of consecutive vertices in the sorted order are connected by edges; then these edges form a directed Hamiltonian path [refer to Problems Section] in the DAG. If a Hamiltonian path exists, the topological sort order is unique. If a topological sort does not form a Hamiltonian path, DAG can have two or more topological orderings.



