## Table of Contents
- [All Permutations of a string](#all-permutations-of-a-string)
- [Find all sub strings of a string](#find-all-sub-strings-of-a-string)
- [Add binary strings](#add-binary-strings)
- [Sort an array of strings according to alphabetical order defined by another string](#sort-an-array-of-strings-according-to-alphabetical-order-defined-by-another-string)
- [Find all anagrams](#find-all-anagrams)


## All Permutations of a string
```
private static void permutation(String prefix, String str) 
{
    int n = str.length();
    if (n == 0) 
	{
		System.out.println(prefix);
	}
	else
	{
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}
```

OR

Invoking: `solve(str.toCharArray(), 0);`

```
public static void swap(char[] arr, int idx, int idx2) {
    char temp = arr[idx];
    arr[idx] = arr[idx2];
    arr[idx2] = temp;
}

public static void solve(char[] arr, int idx) {
    if (idx == arr.length - 1) { //Base condition of recursion
        System.out.print(String.valueOf(arr) + " ");
    }

    for (int i = idx; i < arr.length; i++) {
        swap(arr, idx, i);
        solve(arr, idx + 1);
        swap(arr, idx, i);
        //Backtracking: reverting all the elements to their original places
    }
}

```

## Find all sub strings of a string 
```
static void findSubst(String str)
{
    for(int i=0; i<str.length(); i++)
    {
        for(int j=i+1; j<=str.length(); j++)
        {
            System.out.println(str.substring(i,j));
        } 
    }
}

```

## Add binary strings
```
static String addBinary(String a, String b) 
{ 
    // Initialize result 
    String result = "";  
          
    // Initialize digit sum 
    int s = 0;          
  
    // Traverse both strings starting from last characters 
    int i = a.length() - 1, j = b.length() - 1; 
    while (i >= 0 || j >= 0 || s == 1) 
    {
        // Compute sum of last digits and carry 
        s += ((i >= 0)? a.charAt(i) - '0': 0); 
        s += ((j >= 0)? b.charAt(j) - '0': 0); 
  
        // If current digit sum is 1 or 3, add 1 to result 
        result = (char)(s % 2 + '0') + result; 
  
        // Compute carry 
        s /= 2; 
  
        // Move to next digits 
        i--;
        j--; 
    } 
    return result; 
} 
```

## Sort an array of strings according to alphabetical order defined by another string

```
private static void sort(String[] strArr, String str)
{
    Comparator<String> myComp = new Comparator<String>()
    {
        @Override
        public int compare(String a, String b)
        {
            for(int i = 0; i < Math.min(a.length(), b.length()); i++)
            {
                if (str.indexOf(a.charAt(i)) == str.indexOf(b.charAt(i)))
                {
                    continue;
                }
                else if(str.indexOf(a.charAt(i)) > str.indexOf(b.charAt(i)))
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            return 0;
        }
    };
    Arrays.sort(strArr, myComp);
}
```

<br>

## Find all anagrams
The idea is to move sliding window along the string s, recompute the second hashmap sCount in a constant time and compare it with the first hashmap pCount. If sCount == pCount, then the string in the sliding window is a permutation of string p, and one could add its start position in the output list.

**Algorithm:**
- Build reference counter pCount for string p.
- Move sliding window along the string s:
    - Recompute sliding window counter sCount at each step by adding one letter on the right and removing one letter on the left.
    - If sCount == pCount, update the output list.

- Return output list.

**Time complexity:** <br>
O(N_s + N_p), since it's one pass along both strings.

**Space complexity:** <br>
O(1), because pCount and sCount contain not more than 26 elements.