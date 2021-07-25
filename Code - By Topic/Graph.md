## Table of Contents
- [Topological sort](#topological-sort)

<br>

## Topological sort
- All vertices of indegree 0 are placed on queue. 
- While the queue is not empty, a vertex v is removed, and all edges adjacent to v have their indegrees decremented. 
- A vertex is put on the queue as soon as its indegree falls to 0. The topological ordering is the order in which the vertices DeQueue.