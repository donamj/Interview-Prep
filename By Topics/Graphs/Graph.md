## Table of Contents
- [Graph Representation](#graph-representation)
- [Compare DFS and BFS](#compare-dfs-and-bfs)
- [DFS algorithm works in the following way](#dfs-algorithm-works-in-the-following-way)
- [BFS algorithm works in the following way](#bfs-algorithm-works-in-the-following-way)
- [Topological sort](#topological-sort)
- [Useful Links](#useful-links)

## Graph Representation

There are 3 basic ways to represent a graph in memory (objects and pointers, matrix, and adjacency list); familiarize yourself with each representation and its pros & con.

- [https://stackabuse.com/graphs-in-java-representing-graphs-in-code/](https://stackabuse.com/graphs-in-java-representing-graphs-in-code/)
- [https://www.hackerearth.com/practice/algorithms/graphs/graph-representation/tutorial/](https://www.hackerearth.com/practice/algorithms/graphs/graph-representation/tutorial/)
- Advantages and disadvantages: [https://www.algolist.net/Data_structures/Graph/Internal_representation](https://www.algolist.net/Data_structures/Graph/Internal_representation)

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
All pairs of consecutive vertices in the sorted order are connected by edges; then these edges form a directed Hamiltonian path in the DAG. If a Hamiltonian path exists, the topological sort order is unique. If a topological sort does not form a Hamiltonian path, DAG can have two or more topological orderings.

- All vertices of indegree 0 are placed on queue. 
- While the queue is not empty, a vertex v is removed, and all edges adjacent to v have their indegrees decremented. 
- A vertex is put on the queue as soon as its indegree falls to 0. The topological ordering is the order in which the vertices DeQueue.

## Useful links
- [Graph data structures for beginners](https://adrianmejia.com/data-structures-for-beginners-graphs-time-complexity-tutorial/)
- https://www.techinterviewhandbook.org/algorithms/graph/
