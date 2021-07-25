/*
    1. Create the graph using the given number of edges and vertices.
    2. Create a recursive function that initializes the current index or vertex, visited, and recursion stack.
    3. Mark the current node as visited and also mark the index in recursion stack.
    4. Find all the vertices which are not visited and are adjacent to the current node. 
       Recursively call the function for those vertices, If the recursive function returns true, return true.
    5. If the adjacent vertices are already marked in the recursion stack then return true.
    6. Create a wrapper class, that calls the recursive function for all the vertices and if any function returns true 
       return true. Else if for all vertices the function returns false return false.

    Time Complexity: O(V+E). 
    Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).

    Space Complexity: O(V). 
    To store the visited and recursion stack O(V) space is needed.

*/
public class DetectCycleInDirectedGraph {

    private boolean isCyclic()
    {
         
        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
         
         
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
 
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
    {         
        // Mark the current node as visited and part of recursion stack
        if (recStack[i])
            return true;
 
        if (visited[i])
            return false;
             
        visited[i] = true;
        recStack[i] = true;
        
        List<Integer> children = adj.get(i);
         
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;
                 
        recStack[i] = false;
 
        return false;
    }
    
}
