# Two Pointers

## 1. Pair in an array with a specific sum
```
public static int[] search(int[] arr, int targetSum) 
{
    int left = 0, right = arr.length - 1;
    while (left < right) {
      int currSum = arr[left] + arr[right];
      if (currSum == targetSum)
        return new int[] { left, right }; // found the pair

      if (targetSum > currSum)
        left++; // we need a pair with a bigger sum
      else
        right--; // we need a pair with a smaller sum
    }
    return new int[] { -1, -1 };
}
```
Time complexity : O(N). <br />
Space complexity : O(1).


Alternative method using HashMap. Two steps: 
1. Search for ‘Y’ (which is equivalent to Sum - X”) in the HashTable. If it is there, we got the pair. 
2. Otherwise, add “X” in the HashTable, so that we can search it later.
```
public static int[] search(int[] arr, int targetSum)
{
    HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
    for (int i = 0; i < arr.length; i++) {
      if (nums.containsKey(targetSum - arr[i]))
        return new int[] { nums.get(targetSum - arr[i]), i };
      else
        nums.put(arr[i], i); // put the number and its index in the map
    }
    return new int[] { -1, -1 }; // pair not found
}
```
Time complexity : O(N). <br />
Space complexity : O(N).

## 2. Remove Duplicates
```
public static int remove(int[] arr)
{
    int next = 1; // index of the next non-duplicate element
    for (int i = 1; i < arr.length; i++) {
      if (arr[next - 1] != arr[i]) {
        arr[next] = arr[i];
        next++;
      }
    }

    return next;
}
```
Time complexity : O(N). <br />
Space complexity : O(1).

## 3. Squaring a sorted array
```
public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int[] squares = new int[n];
    int highestSquareIdx = n - 1;
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];
      if (leftSquare > rightSquare) {
        squares[highestSquareIdx--] = leftSquare;
        left++;
      } else {
        squares[highestSquareIdx--] = rightSquare;
        right--;
      }
    }
    return squares;
}
```
Time complexity : O(N). <br />
Space complexity : O(N).