## Table of Contents
- [Find next permutation](#find-next-permutation)
- [Spiral Matrix](#spiral-matrix)
- [Find max sum sub array](#find-max-sum-sub-array)
- [Merge intervals](#merge-intervals)
- [Longest Arithmetics Sequence](#longest-arithmetics-sequence)
- [Max product of sub array](#max-product-of-sub-array)
- [Largest number possible from an array](#largest-number-possible-from-an-array)
- [Minimum sum sub array of size k](#minimum-sum-sub-array-of-size-k)
- [Maximum profit earned by buying or selling shares](#maximum-profit-earned-by-buying-or-selling-shares)
- [Power set of a set](#power-set-of-a-set)
- [Max sum sub array of](#max-sum-sub-array)
- [Sub array whose sum is k](#sub-array-whose-sum-is-k)
- [Longest consecutive sequence](#longest-consecutive-sequence)
- [Number of possible triangles](#number-of-possible-triangles)
- [Find all pairs in an array with a given sum](#find-all-pairs-in-an-array-with-a-given-sum)
- [Diagonal Matrix](#diagonal-matrix)
- [Find whether an array is a subset of another array](#find-whether-an-array-is-a-subset-of-another-array)
- [Rotate an array](#rotate-an-array)
- [Product of array except self](#product-of-array-except-self)

<br>

## Find next permutation
- Find largest index i such that array[i − 1] < array[i].
- If no such i exists, then this is already the last permutation.
- Find largest index j such that j ≥ i and array[j] > array[i − 1].
- Swap array[j] and array[i − 1].
- Reverse the suffix starting at array[i].

<br>

## Spiral Matrix
- Path should turn clockwise whenever it would go out of bounds or into a cell that was previously visited

<br>

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

<br>

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

## Longest Arithmetics Sequence
```
	public int longestArithSeqLength(int[] A) {
        if (A.length <= 1) return A.length;
       
        int longest = 0;
        
        // Declare a dp array that is an array of hashmaps.
        // The map for each index maintains an element of the form-
        //   (difference, length of max chain ending at that index with that difference).        
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        
        for (int i = 0; i < A.length; ++i) {
            dp[i] = new HashMap<Integer, Integer>();
        }
        
        for (int i = 1; i < A.length; ++i) {
            int x = A[i];
            
            for (int j = 0; j < i; ++j) {
                int y = A[j];
                int d = x - y;
                
                // We at least have a minimum chain length of 2 now, given that (A[j], A[i]) with the difference d, by default forms a chain of length 2.
                int len = 2;  
                
                if (dp[j].containsKey(d)) {
                    // At index j, if we had already seen a difference d, then potentially, we can add A[i] to the same chain and extend it by length 1.
                    len = dp[j].get(d) + 1;
                }
                
                // Obtain the maximum chain length already seen so far at index i for the given differene d;
                int curr = dp[i].getOrDefault(d, 0);
                
                // Update the max chain length for difference d at index i.
                dp[i].put(d, Math.max(curr, len));
                
                // Update the global max.
                longest = Math.max(longest, dp[i].get(d));
            }
        }
        
        return longest;
    }
```

<br>

## Max product of sub array
Maximum product of subarray - O(n)
```
   public static int maxProduct( int[] A) {
      if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
```

<br>

## Largest number possible from an array
```
publicstatic String largestNumberFromArray(ArrayList<String> arr)
    {
        Collections.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				String ab = a+b;
				String ba = b+a;
				return ab.compareTo(ba)>0 ? -1:1;
			}
        }); 
        StringBuilder ans = new StringBuilder();
        for(String s : arr) {
             ans.append(s);
        }
        return ans.toString();
    }
```

<br>

## Minimum sum sub array of size k
- O(n) time complexity
- Uses sliding window
```
void findSubarray(int arr[], int n, int k)
{
    // stores sum of element in current window
    int window_sum = 0;
    // stores sum of minimum sum sub-array found so far
    int min_window = INT_MAX;
    // stores ending index of minimum sum sub-array found so far
    int last = 0;
    for (int i = 0; i < n; i++)
    {
        // add current element to the window
        window_sum += arr[i];
        // if window size is more than equal to k
        if (i + 1 >= k)
        {
            // update minimum sum window
            if (min_window > window_sum)
            {
                min_window = window_sum;
                last = i;
            }
            // remove leftmost element from the window
            window_sum -= arr[i + 1 - k];
        }
}
```

<br>

## Maximum profit earned by buying or selling shares
Find the increasing sub sequences, Buy on the start of the sequence and sell at the end.

```
// Function to find maximum profit that can be earned by buying and selling shares any number of times    
public int maxProfit(int[] prices) {

	int profit = 0;
	int minPrice = prices[0];
	for(int i =0; i< prices.length; i++) {
		minPrice = Math.min(minPrice, prices[i]);
		profit = Math.max(profit, prices[i]-minPrice);
	}

	return profit;
	
}
```

## Power set of a set
```
private static Set<Set<Object>> getSubsetUsingBitMap(List<Object> list) 
{
	Set<Set<Object>> result = new HashSet<Set<Object>>();
	int numOfSubsets = 1 << list.size(); // OR Math.pow(2, list.size())
	
	// For i from 0 to 7 in case of [a, b, c], we will pick 0(0,0,0) and check each bits to see any bit is set,
	
	// If set then element at corresponding position in a given Set need to be included in a subset.
	for (int i = 0; i < numOfSubsets; i++) 
	{
		Set<Object> subset = new HashSet<Object>();
		int mask = 1; // we will use this mask to check any bit is set in binary representation of value i.
		for (int k = 0; k < list.size(); k++) 
		{
			if ((mask & i) != 0) 
			{ 
				// If result is !=0 (or >0) then bit is set.
				subset.add(list.get(k)); // include the corresponding element from a given set in a subset.
			}
			// check next bit in i.
			mask = mask << 1;
		}
		// add all subsets in final result.
		result.add(subset);
	}
	return result;
}
```

OR
```
public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
    Set<Set<T>> sets = new HashSet<Set<T>>();
    if (originalSet.isEmpty()) {
        sets.add(new HashSet<T>());
        return sets;
    }
    List<T> list = new ArrayList<T>(originalSet);
    T head = list.get(0);
    Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
    for (Set<T> set : powerSet(rest)) {
        Set<T> newSet = new HashSet<T>();
        newSet.add(head);
        newSet.addAll(set);
        sets.add(newSet);
        sets.add(set);
    }      
    return sets;
}  
```

OR

```
static void powerSet(String str, int index, String curr) 
{ 
    int n = str.length(); 
  
    // base case 
    if (index == n)
    { 
        System.out.println(curr);
        return; 
    } 
  
    // Two cases for every character 
    // (i) We consider the character as part of current subset 
    // (ii) We do not consider current character as part of current subset
    powerSet(str, index + 1, curr + str.charAt(index)); 
    powerSet(str, index + 1, curr);
  
} 
```

## Max sum sub array
https://medium.com/@codingfreak/huge-collection-of-array-interview-questions-e87ac7c34e62

Time complexity - O(n)
```
public int maxSubArray(int[] nums) {
        
        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            int n = nums[i];
            currSum = Math.max(n, currSum + n);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
```

## Find the maximum length of a subarray that sums to k <br>
Time Complexity: O(n) <br>
Auxiliary Space: O(n)

**Algorithm**
1. Initialize sum = 0 and maxLen = 0.

2. Create a hash table having (sum, index) tuples.

3. For i = 0 to n-1, perform the following steps:
	1. Accumulate arr[i] to sum.
	2. If sum == k, update maxLen = i+1.
	3. Check whether sum is present in the hash table or not. If not present, then add it to the hash table as (sum, i) pair.
	4. Check if (sum-k) is present in the hash table or not. If present, then obtain index of (sum-k) from the hash table as index. Now check if maxLen < (i-index), then update maxLen = (i-index).
4. Return maxLen.

```
public int maxSubArrayLen(int[] nums, int k){
    HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
    int max =0;
    int sum=0;
    for(int i=0; i<nums.length; i++){
        sum += nums[i];
        if(sum==k){
            max = i+1;
        } 
        if(!map.containsKey(sum)){
            map.put(sum, i);
        }
        int diff = sum-k;
        if(map.containsKey(diff)){
            max =Math.max(max, i-map.get(diff));
        }
        
    }
    return max;
}
```

<br>

## Sub array whose sum is k
```
public void findSubArraySum(int[] arr, int num){
  int sum = arr[0];
  int start = 0;
  if(arr[0] == num){
   System.out.println("Continuous Sub Array : " + arr[0]);
  }
  for(int i=1; i<arr.length; i++){
   sum = sum + arr[i];
   while(sum > num){
    sum = sum - arr[start];
    start++;
   }
   if(sum == num){
    System.out.print("Continuous Sub Array : ");
    for(int j=start; j<=i; j++){
     System.out.print(arr[j] + " ");
    }
    System.out.println();
   }
  }
 }
 public static void main(String[] args){
  int[] arr = {25,5,10,0,15,20,18,25};
  int num = 25;
  SubArraySum subA = new SubArraySum();
  subA.findSubArraySum(arr, num);
 }
```

<br>

## Longest consecutive sequence
Complexity- O(n)
```
static int findLongestConseqSubseq(int arr[])
    {
    int n = arr.length;
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
 
        for (int i=0; i<n; ++i)
            S.add(arr[i]);
 
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting element of a sequence
            if (!S.contains(arr[i]-1))
            {
                // Then check for next elements in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;
 
                // update  optimal length if this length is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
        return ans;
    } 
```

<br>

## Number of possible triangles
Complexity - O(n^2)
```
static int findNumberOfTriangles(intarr[])
    {
        intn = arr.length;
        Arrays.sort(arr);
        intcount = 0;
 
        // Fix the first element. We need to run till n-3 as
        // the other two elements are selected from arr[i+1...n-1]
        for (int i = 0; i < n-2; ++i)
        {
            // Initialize index of the rightmost third element
            int k = i + 2;
 
            for (int j = i+1; j < n; ++j)
            {
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;
                if(k>j)
                count += k - j - 1;
            }
        }
        return count;
    } 
```

<br>

## Find all pairs in an array with a given sum
Complexity - O(n)
1) Initialize an empty hash table s.
2) Do following for each element A[i] in A[]
   - If s[x - A[i]] is set then print the pair (A[i], x - A[i])
   - Insert A[i] into s.

```
void printpairs(int arr[],int sum)
    {       
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];
            if (temp>=0 && s.contains(temp))
            System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", "+temp+")");
            s.add(arr[i]);
        }
    } 
```

<br>

## Diagonal Matrix
![https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/DiagonalMatrix.png](https://github.com/donamj/Interview-Prep/blob/4d1f8b75605817ba01c6273be5402c565fc0d580/Assets/DiagonalMatrix.png)
```
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        
        
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row*col;
        int[] result = new int[total];
        
        int k=0;
        int i=0;
        int j=0;
        boolean up=true;
        while(k<total) {
            result[k] = matrix[i][j];
            
            
            if(up) {
                if(i==0 && j<col-1) {
                   j++;
                   up=!up;
                } else if(j== col-1) {
                    i++;
                    up= !up;
                } else {
                    i--;
                    j++;
                }
            } else { //down
                if(i<row-1 && j==0) {
                    i++;
                    up=!up;
                } else if(i == row -1) {
                    j++;
                    up = !up;
                } else {
                    i++;
                    j--;
                }
            }
            
            k++;
        }
        return result;
        
    }
}
```

<br>

## Find whether an array is a subset of another array
```
static boolean isSubset(int arr1[], int arr2[]) {
    HashSet<Integer> set= new HashSet<>(); 
    
    for(int i = 0; i < arr1.length; i++) { 
      set.add(arr1[i]); 
    } 

    for(int i = 0; i < arr2.length; i++) { 
      if(!set.contains(arr2[i])) 
        return false; 
    } 
    return true; 
  }
```
Time complexity is O(m+n).
<br/>

## Rotate an array
Using Array Reversal:
1. Reverse the array elements from 0 to k-1.
2. Reverse the array elements from k to array.length-1.
3. Reverse the whole array.

<br/>
Example: 1 2 3 4 5 <br/>
k = 3<br/><br/>
Step 1. Reverse the array elements from 0 to 2: 3 2 1 4 5<br/>
Step 2. Reverse the array elements from 3 to 4: 3 2 1 5 4<br/>
Step 3. Reverse the whole array: 4 5 1 2 3<br/>
<br/>
Time Complexity: O(n)<br/>
Space Complexity: O(1)
<br/><br/>

```
 static void rotateArray(List<Integer> arr, int n) {

    int len = arr.size();
    // Let's normalize rotations
    // if n > array size or n is negative.
    n = n % len;
    if (n < 0) {
      // calculate the positive rotations needed.
      n = n + len;
    }

    reverseArray(arr, 0, len-1);
    reverseArray(arr, 0, n-1);
    reverseArray(arr, n, len-1);
  }
```

## Stock buy sell to maximize profit
Uses Kadane's alogrithm

Time complexity : O(n)

Space complexity : O(1)
```
public static Tuple findBuySellStockPrices(int[] array) {
    if(array == null || array.length < 2) {
        return null;
      }

    int current_buy = array[0];
    int global_sell = array[1];
    int global_profit = global_sell - current_buy;

    int current_profit = Integer.MIN_VALUE;
  
    for(int i=1; i<array.length; i++) {
      current_profit = array[i] - current_buy;
  
      if(current_profit > global_profit) {
        global_profit = current_profit;
        global_sell = array[i];
      }

      if(current_buy > array[i]) {
        current_buy = array[i];
      }
    }

    Tuple<Integer, Integer> result = 
      new Tuple<Integer, Integer>(global_sell - global_profit, global_sell);

    return result;
  }
```

## Product of array except self
- Approach: Using prefix and postfix
- Idea: Just find prefix and postfix product and keep them in the ans array
```
public int[] productExceptSelf(int[] nums) {
	int len = nums.length;
	int result[] = new int[len];

	int prefix = 1; 
	int postfix = 1;

	for(int i = 0; i < len; i++) {
		result[i] = prefix;
		prefix *= nums[i];
	}

	for (int i = len-1; i >= 0; i--) {
		result[i] *= postfix;
		postfix *= nums[i];
	}

	return result;
}
```