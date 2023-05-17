# Table of Contents
- [Notes](#notes)
- [Depth First Search](#depth-first-search)
- [Breadth First Search](#breadth-first-search)
- [Minimum Spanning Tree](#minimum-spanning-tree)
  * [Kruskal's Algorithm](#kruskal-s-algorithm)
  * [Prim's Algorithm](#prim-s-algorithm)
- [Shorted Path - Dijkstra's](#shorted-path---dijkstras)
- [Knapsack Problem](#knapsack-problem)
- [Shorted path - Bellman Ford Algorithm](#shorted-path---bellman-ford-algorithm)
- [Topological Sort](#topological-sort)

<br>

# Notes
1. If we want to find the shortest path (or just any path) between two nodes, BFS is generally better.

2. DFS search uses recursive approach, while BFS uses iterative method using queue

3. Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs. Uses DFS.

4. Shortest Path and Minimum Spanning Tree for unweighted graph - In an unweighted graph, the shortest path is the path with least number of edges. With Breadth First, we always reach a vertex from given source using the minimum number of edges.

<br>

# Depth First Search
https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/

```
Set<String> DFS(MyGraph g) 
{
    Set<String> visited = new HashSet<String>();
    Stack<String> stack = new Stack<String>();
    stack.push((String) g.adj.keySet().toArray()[0]);
    while(!stack.isEmpty()) 
    {
          String vertex = stack.pop();
	    if(!visited.contains(vertex)) 
	    {
		    visited.add(vertex);
		    System.out.print(" " +vertex + " ");
		    for (String v : g.adj.get(vertex)) 
		    {             
                      stack.push(v);
		    }
		}
    }
    return visited;
}


void DFSRecursive(MyGraph g) 
{
	Set<String> visitedRecur = new LinkedHashSet<String>();
	recursiveDFS(g, (String) g.adj.keySet().toArray()[0], visitedRecur);
}

void recursiveDFS(MyGraph g, String vertex, Set<String> visitedRecur) 
{
	visitedRecur.add(vertex);
	System.out.print(vertex + " ");
	for(String v : g.adj.get(vertex)) {
	    if(!visitedRecur.contains(v)) {
	        recursiveDFS(g,v,visitedRecur);
	    }
	}
}
```
<br>

![https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/DFS_Util.png](https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/DFS_Util.png)

<br>

# Breadth First Search 
```
Set<String> BFS(MyGraph g) 
{
	Set<String> visited = new HashSet<String>();
	Queue<String> queue = new LinkedList<String>();
	queue.add((String) g.adj.keySet().toArray()[0]);
	visited.add((String) g.adj.keySet().toArray()[0]);
	
	while(!queue.isEmpty()) 
	{
		String vertex = queue.poll();
		System.out.print(" " + vertex + " ");
		for (String v : g.adj.get(vertex)) 
		{ 
		       if(!visited.contains(v)) 
			{
				visited.add(v);
				queue.add(v);
			}
		}
	}
	return visited;
}
```
<br>

![https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/BFS.png](https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/BFS.png)

<br>

# Minimum Spanning Tree
Minimum spanning tree has direct application in the design of networks. It is used in algorithms approximating the travelling salesman problem, multi-terminal minimum cut problem and minimum-cost weighted perfect matching. Other practical applications are:
1. Cluster Analysis
2. Handwriting recognition
3. Image segmentation


## Kruskal's Algorithm
Kruskal's algorithm follows greedy approach as in each iteration it finds an edge which has least weight and add it to the growing spanning tree.

**Algorithm Steps:**
- Sort the graph edges with respect to their weights.
- Start adding edges to the MST from the edge with the smallest weight until the edge of the largest weight.
- Only add edges which doesn't form a cycle , edges which connect only disconnected components.
	
**Time Complexity:** <br>
In Kruskal’s algorithm, most time consuming operation is sorting because the total complexity of the Disjoint-Set operations will be O(ElogV), which is the overall Time Complexity of the algorithm.


## Prim's Algorithm
Prim’s Algorithm also use Greedy approach to find the minimum spanning tree. In Prim’s Algorithm we grow the spanning tree from a starting position. Unlike an edge in Kruskal's, we add vertex to the growing spanning tree in Prim's.

**Algorithm Steps:**
- Maintain two disjoint sets of vertices. One containing vertices that are in the growing spanning tree and other that are not in the growing spanning tree.
- Select the cheapest vertex that is connected to the growing spanning tree and is not in the growing spanning tree and add it into the growing spanning tree. This can be done using Priority Queues. Insert the vertices, that are connected to growing spanning tree, into the Priority Queue.
- Check for cycles. To do that, mark the nodes which have been already selected and insert only those nodes in the Priority Queue that are not marked.

**Time Complexity:**
The time complexity of the Prim’s Algorithm is O((V+E)logV) because each vertex is inserted in the priority queue only once and insertion in priority queue take logarithmic time.

<br>

# Shorted Path - Dijkstras 

Reference : https://www.baeldung.com/java-dijkstra

<br>

**Structure**
```
private String name;
    
private List<Node> shortestPath = new LinkedList<>();
private Integer distance = Integer.MAX_VALUE;
    
Map<Node, Integer> adjacentNodes = new HashMap<>();
```

Here's a list of steps to follow in order to solve the SPP with Dijkstra: <br>
- Set distance to startNode to zero.
- Set all other distances to an infinite value.
- We add the startNode to the unsettled nodes set.
- Add neighbors that are not yet settled to the unsettled nodes set.
    ```
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) 
    {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry < Node, Integer> adjacencyPair: 
            currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
    ```
- While the unsettled nodes set is not empty we:
    - Choose an evaluation node from the unsettled nodes set, the evaluation node should be the one with the lowest distance from the source.
        ```
        private static Node getLowestDistanceNode(Set<Node> unsettledNodes) 
        {
            Node lowestDistanceNode = null;
            int lowestDistance = Integer.MAX_VALUE;
            for (Node node: unsettledNodes) {
                int nodeDistance = node.getDistance();
                if (nodeDistance < lowestDistance) {
                    lowestDistance = nodeDistance;
                    lowestDistanceNode = node;
                }
            }
            return lowestDistanceNode;
        }
        ```
    - Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation.
        ```
        private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode)
        {
            Integer sourceDistance = sourceNode.getDistance();
            if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {
                evaluationNode.setDistance(sourceDistance + edgeWeight);
                LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
                shortestPath.add(sourceNode);
                evaluationNode.setShortestPath(shortestPath);
            }
        }
        ```
<br>

# Knapsack Problem
**Reference :** https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf

```
for (int item = 1; item <= n; item++)
{
	for (int capacity = 1; capacity <= w; capacity++) 
	{
		int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
		int maxValWithCurr = 0; // We initialize this value to 0
		
		int weightOfCurr = wt[item - 1]; // We use item -1 to account for the extra row at the top
		if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
		maxValWithCurr = val[item - 1]; // If so, maxValWithCurr is at least the value of the current item
		
		int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
		maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
	}

         mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
}
```

<br>

# Shorted path - Bellman Ford Algorithm
```
Shortest path from source to dest (BellmanFord algorithm) - O(VE)
//The main function that finds shortest distances from src to all other vertices using Bellman-Ford algorithm.  
//The function also detects negative weight cycle
void BellmanFord(Graph graph,int src)
{
    int V = graph.V, E = graph.E;
    int dist[] = new int[V];
    
    // Step 1: Initialize distances from src to all other vertices as INFINITE
    for (int i=0; i<V; ++i)
        dist[i] = Integer.MAX_VALUE;
    dist[src] = 0;
    
    // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other vertex can have at-most |V| - 1 edges
    for (int i=1; i<V; ++i)
    {
        for (int j=0; j<E; ++j)
        {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v])
                dist[v]=dist[u]+weight;
        }
    }
    
    // Step 3: check for negative-weight cycles. The above step guarantees shortest distances if graph doesn't contain negative weight cycle. If we get a shorter path, then there is a cycle.
    for (int j=0; j<E; ++j)
    {
        int u = graph.edge[j].src;
        int v = graph.edge[j].dest;
        int weight = graph.edge[j].weight;
        if (dist[u] != Integer.MAX_VALUE && dist[u]+weight < dist[v])
          System.out.println("Graph contains negative weight cycle");
    }
    printArr(dist, V);
} 
```
<br>

# Topological Sort
The most common use for topological sort is ordering steps of a process where some the steps depend on each other.

![https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/TopologicalSort_1.png](https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/TopologicalSort_1.png)

![https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/TopologicalSort_2.png](https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/TopologicalSort_2.png)



