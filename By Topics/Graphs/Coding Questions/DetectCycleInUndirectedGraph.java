/*
    Algorithm: 
        1. Create the graph using the given number of edges and vertices.
        2. Create a recursive function that have current index or vertex, visited array and parent node.
        3. Mark the current node as visited .
        4. Find all the vertices which are not visited and are adjacent to the current node.
           Recursively call the function for those vertices, If the recursive function returns true return true.
        5. If the adjacent node is not parent and already visited then return true.
        6. Create a wrapper class, that calls the recursive function for all the vertices and if any function returns true, return true.
           Else if for all vertices the function returns false return false.

    Time Complexity: O(V+E). 
        The program does a simple DFS Traversal of the graph which is represented using adjacency list.
        So the time complexity is O(V+E).

    Space Complexity: O(V). 
        To store the visited array O(V) space is required.
*/

public class DetectCycleInUndirectedGraph {
    
    // Returns true if the graph contains a cycle, else false.
    Boolean isCyclic()
    {
         
        // Mark all the vertices as not visited and not part of recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < V; u++)
        { 
         
            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        }
 
        return false;
    }

    // A recursive function that uses visited[] and parent to detect cycle in subgraph reachable from vertex v.
    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext())
        {
            i = it.next();
 
            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }
}
