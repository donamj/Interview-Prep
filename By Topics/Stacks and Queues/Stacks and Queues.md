## Priority Queue
```agsl
PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(),(a,b)->Integer.compare(a.end,b.end));
```