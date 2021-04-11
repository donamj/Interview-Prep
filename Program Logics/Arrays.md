## Find next permutation
- Find largest index i such that array[i − 1] < array[i].
- If no such i exists, then this is already the last permutation.
- Find largest index j such that j ≥ i and array[j] > array[i − 1].
- Swap array[j] and array[i − 1].
- Reverse the suffix starting at array[i].

## Spiral Matrix
- Path should turn clockwise whenever it would go out of bounds or into a cell that was previously visited

## Find max sum sub array
```
static int findMaxSumSubArray(int[] A) {
    if (A.length < 1) {
      return 0;
    }

    int currMax = A[0];
    int globalMax = A[0];
    for (int i = 1; i < A.length; ++i) {

      if (currMax < 0) {
        currMax = A[i];
      } else {
        currMax += A[i];
      }

      if (globalMax < currMax) {
        globalMax = currMax;
      }
    }

    return globalMax;
  }
```

## Merge intervals
```
 public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
```