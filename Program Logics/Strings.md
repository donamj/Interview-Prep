## Table of Contents
- [All Permutations of a string](#all-permutations-of-a-string)
- [Find all sub strings of a string](#find-all-sub-strings-of-a-string)
- [Add binary strings](#add-binary-strings)
- [Sort an array of strings according to alphabetical order defined by another string](#sort-an-array-of-strings-according-to-alphabetical-order-defined-by-another-string)

<br>

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
            for(int i = 0;
                    i < Math.min(a.length(),
                                 b.length()); i++)
            {
                if (str.indexOf(a.charAt(i)) ==
                    str.indexOf(b.charAt(i)))
                {
                    continue;
                }
                else if(str.indexOf(a.charAt(i)) >
                        str.indexOf(b.charAt(i)))
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


