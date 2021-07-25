# Sliding Window

Referred from educative.io

Sliding window pattern is used in problems dealing with an array (or a LinkedList), where we are asked to find or calculate something among all the contiguous subarrays (or sublists) of a given size. Using this method we can reduce the time complexity from O(kn) to O(n) in most cases. 

Some of the questions using this pattern are:

## 1. Maximum Sum Subarray of Size K

```
public static int findMaxSum(int k, int[] arr) 
    {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
        windowSum = 0;
        for (int j = i; j < i + k; j++) {
            windowSum += arr[j];
        }
        maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
```

Time complexity : O(N). <br />
Space complexity : O(1).

## 2. Smallest Subarray with a given sum
```
public static int findMinSubArray(int S, int[] arr)
{
    int windowSum = 0, minLen = Integer.MAX_VALUE;
    int start = 0;
    for (int end = 0; end < arr.length; end++) {
    windowSum += arr[end]; 
    // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
    while (windowSum >= S) {
        minLen = Math.min(minLen, end - start + 1);
        windowSum -= arr[start]; // subtract the element going out
        start++; // slide the window ahead
    }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```
Time complexity : O(N)
<br />
Space complexity : O(1)

## 3. Longest Substring with K Distinct Characters
```
public static int findLength(String str, int k) {
    if (str == null || str.length() == 0 || str.length() < k)
      throw new IllegalArgumentException();

    int start = 0, maxLen = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    // in the following loop we'll try to extend the range [start, end]
    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (freqMap.size() > k) {
        char leftChar = str.charAt(start);
        freqMap.put(leftChar, freqMap.get(leftChar) - 1);
        if (freqMap.get(leftChar) == 0) {
          freqMap.remove(leftChar);
        }
        start++; // shrink the window
      }
      maxLen = Math.max(maxLen, end - start + 1); // remember the maximum length so far
    }

    return maxLen;
}
```
Time complexity : O(N)
<br />
Space complexity : The algorithm’s space complexity is O(K), as we will be storing a maximum of K+1 characters in the HashMap.

## 4. Fruits into Baskets
Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both baskets.

```
public static int findLength(char[] arr) 
{
    int start = 0, maxLength = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    // try to extend the range [start, end]
    for (int end = 0; end < arr.length; end++) {
      freqMap.put(arr[end], freqMap.getOrDefault(arr[end], 0) + 1);
      // shrink the sliding window, until we are left with '2' fruits in the frequency map
      while (freqMap.size() > 2) {
        freqMap.put(arr[start], freqMap.get(arr[start]) - 1);
        if (freqMap.get(arr[start]) == 0) {
          freqMap.remove(arr[start]);
        }
        start++; // shrink the window
      }
      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
}
```
Time complexity : O(N)
<br />
Space complexity : O(1)

## 5. Longest substring without repeating character
```
public static int findLength(String str) 
{
    int start = 0, maxLength = 0;
    Map<Character, Integer> idxMap = new HashMap<>();
    // try to extend the range [start, end]
    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      // if the map already contains the 'rightChar', shrink the window from the beginning so that
      // we have only one occurrence of 'rightChar'
      if (idxMap.containsKey(rightChar)) {
        // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
        // and if 'start' is already ahead of the last index of 'rightChar', we'll keep 'start'
        start = Math.max(start, idxMap.get(rightChar) + 1);
      }
      idxMap.put(rightChar, end); // insert the 'rightChar' into the map
      maxLength = Math.max(maxLength, end - start + 1); // remember the maximum length so far
    }

    return maxLength;
}
```
Time complexity : O(N)
<br />
Space complexity : O(K), where K is the number of distinct characters in the input string. 

## 6. Longest Substring with Same Letters after Replacement
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
```
public static int findLength(String str, int k) {
    int start = 0, maxLength = 0, maxCount = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    // try to extend the range [start, end]
    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
      maxCount = Math.max(maxCount, freqMap.get(rightChar));

      // current window size is from start to end, overall we have a letter which is
      // repeating 'maxCount' times, this means we can have a window which has one letter 
      // repeating 'maxCount' times and the remaining letters we should replace.
      // if the remaining letters are more than 'k', it is the time to shrink the window as we
      // are not allowed to replace more than 'k' letters
      if (end - start + 1 - maxCount > k) {
        char leftChar = str.charAt(start);
        freqMap.put(leftChar, freqMap.get(leftChar) - 1);
        start++;
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
}
```

## 7. Permutations in a string
```
public static boolean findPermutation(String str, String pattern) {
    int start = 0, matched = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      freqMap.put(chr, freqMap.getOrDefault(chr, 0) + 1);

    // our goal is to match all the characters from the 'freqMap' with the current window
    // try to extend the range [start, end]
    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      if (freqMap.containsKey(rightChar)) {
        // decrement the frequency of the matched character
        freqMap.put(rightChar, freqMap.get(rightChar) - 1);
        if (freqMap.get(rightChar) == 0) // character is completely matched
          matched++;
      }

      if (matched == freqMap.size())
        return true;

      if (end >= pattern.length() - 1) { // shrink the window by one character
        char leftChar = str.charAt(start++);
        if (freqMap.containsKey(leftChar)) {
          if (freqMap.get(leftChar) == 0)
            matched--; // before putting the character back, decrement the matched count
          // put the character back for matching
          freqMap.put(leftChar, freqMap.get(leftChar) + 1);
        }
      }
    }

    return false;
}
```
Time complexity : O(M + N), where M and N are the length of string and pattern.
<br />
Space complexity : O(M), since, in the worst case, the whole pattern can have distinct characters that will go into the HashMap.

## 8. String anagrams
```
public static List<Integer> findStringAnagrams(String str, String pattern) {
    int start = 0, matched = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      freqMap.put(chr, freqMap.getOrDefault(chr, 0) + 1);

    List<Integer> result = new ArrayList<Integer>();
    // our goal is to match all the characters from the map with the current window
    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      // decrement the frequency of the matched character
      if (freqMap.containsKey(rightChar)) {
        freqMap.put(rightChar, freqMap.get(rightChar) - 1);
        if (freqMap.get(rightChar) == 0)
          matched++;
      }

      if (matched == freqMap.size()) // have we found an anagram?
        result.add(start);

      if (end >= pattern.length() - 1) { // shrink the window
        char leftChar = str.charAt(start++);
        if (freqMap.containsKey(leftChar)) {
          if (freqMap.get(leftChar) == 0)
            matched--; // before putting the character back, decrement the matched count
          // put the character back
          freqMap.put(leftChar, freqMap.get(leftChar) + 1);
        }
      }
    }

    return result;
}
```

## 9. Smallest Window containing Substring
```
public static String findSubstring(String str, String pattern)
{
    int start = 0, matched = 0, minLen = str.length() + 1, subStringStart = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      freqMap.put(chr, freqMap.getOrDefault(chr, 0) + 1);

    // try to extend the range [start, end]
    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      if (freqMap.containsKey(rightChar)) {
        freqMap.put(rightChar, freqMap.get(rightChar) - 1);
        if (freqMap.get(rightChar) >= 0) // count every matching of a character
          matched++;
      }

      // shrink the window if we can, finish as soon as we remove a matched character
      while (matched == pattern.length()) {
        if (minLen > end - start + 1) {
          minLen = end - start + 1;
          subStringStart = start;
        }

        char leftChar = str.charAt(start++);
        if (freqMap.containsKey(leftChar)) {
          // note that we could have redundant matching characters, therefore we'll decrement the
          // matched count only when a useful occurrence of a matched character is going out of the window
          if (freqMap.get(leftChar) == 0)
            matched--;
          freqMap.put(leftChar, freqMap.get(leftChar) + 1);
        }
      }
    }

    return minLen > str.length() ? "" : str.substring(subStringStart, subStringStart + minLen);
}
```
