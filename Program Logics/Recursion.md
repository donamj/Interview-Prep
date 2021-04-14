## Table of Contents
- [Tower of Hanoi](#tower-of-hanoi)

<br>

## Tower of Hanoi
1. Move the top n-1 disks from source to auxiliary tower.

2. Move the nth disk from source to destination tower.

3. Move the n-1 disks from auxiliary tower to destination tower.

4. Now, transferring the top n-1 disks from source to auxiliary tower can be thought as a fresh problem and can be solved in the same manner using recursion.

5. Once we solve Towers Of Hanoi with three disks, we can solve it with any number of disks with the same algorithm.

```
    public void solveTowersOfHanoi(int n, String source, String aux, String dest)
	{
		// If only 1 disk, make the move and return.
		if(n==1)
		{
			System.out.println(source+" --> "+dest);
			return;
		}
		
		// Move top n-1 disks from A to B using C as auxiliary.
		solveTowersOfHanoi(n-1, source, dest, aux);
		
		//Move remaining disks from A to C
		System.out.println(source+" --> "+dest);
		
		// Move n-1 disks from B to C using A as auxiliary
		solveTowersOfHanoi(n-1, aux, source, dest);
		
	}
```