# Table of  Contents
- [Bubble Sort](#bubble-sort)
- [Selection Sort](#selection-sort)
- [Insertion Sort](#insertion-sort)
- [Shell Sort](#shell-sort)
- [Merge Sort](#merge-sort)
- [Quick Sort](#quick-sort)
- [Heap Sort](#heap-sort)

<br>

# Bubble Sort
```
void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
```

# Selection Sort
```
void selectionSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
```

# Insertion Sort
```
void insertionSort(int arr[], int n) 
{ 
    int i, key, j; 
    for (i = 1; i < n; i++)
    { 
        key = arr[i]; 
        j = i - 1; 
 
        /* Move elements of arr[0..i-1], that are 
        greater than key, to one position ahead 
        of their current position */
        while (j >= 0 && arr[j] > key)
        { 
            arr[j + 1] = arr[j]; 
            j = j - 1; 
        } 
        arr[j + 1] = key; 
    } 
} 
```

# Shell Sort
```
int shellSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap 
                // sorted save a[i] in temp and make a hole at 
                // position i 
                int temp = arr[i]; 
  
                // shift earlier gap-sorted elements up until 
                // the correct location for a[i] is found 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
                // put temp (the original a[i]) in its correct 
                // location 
                arr[j] = temp; 
            } 
        } 
        return 0; 
    } 
```

# Merge Sort 
When to use Merge Sort:
1. Merge sort is used when the data structure doesn’t support random access, since it works with pure sequential access (forward iterators, rather than random access iterators). It’s also widely used for external sorting, where random access can be very, very expensive compared to sequential access.
For example, When sorting a file which doesn’t fit into memory, you might break it into chunks which fit into memory, sort these using independently, writing each out to a file, then merge sort the generated files.

2. Also, you can use merge sort when you need a stable sort. It’s very important feature of merge sort.

3. Merge sort is quicker when dealing with linked lists. This is because pointers can easily be changed when merging lists. It only requires one pass (O(n)) through the list.

4. If there is a lot of parallelization occurs then parallelizing Merge sort is simpler than other sort algorithms.

    ![https://github.com/donamj/Interview-Prep/blob/4b7d4f1092aec5e14ae0da17070440d5f590e712/Images/MergeSort.png](https://github.com/donamj/Interview-Prep/blob/4b7d4f1092aec5e14ae0da17070440d5f590e712/Images/MergeSort.png)

# Quick Sort
Following are the steps involved in quick sort algorithm:
1. After selecting an element as pivot, which is the last index of the array in our case, we divide the array for the first time.

2. In quick sort, we call this partitioning. It is not simple breaking down of array into 2 subarrays, but in case of partitioning, the array elements are so positioned that all the elements smaller than the pivot will be on the left side of the pivot and all the elements greater than the pivot will be on the right side of it.

3. And the pivot element will be at its final sorted position.

4. The elements to the left and right, may not be sorted.

5. Then we pick subarrays, elements on the left of pivot and elements on the right of pivot, and we perform partitioning on them by choosing a pivot in the subarrays.

    ![https://github.com/donamj/Interview-Prep/blob/4b7d4f1092aec5e14ae0da17070440d5f590e712/Images/QuickSort.png](https://github.com/donamj/Interview-Prep/blob/4b7d4f1092aec5e14ae0da17070440d5f590e712/Images/QuickSort.png)


**With middle element as pivot**
```
public static void quickSort(Integer[] arr, intlow, inthigh)
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }
        if (low >= high){
            return;
        }
        //Get the pivot element from the middle of the list
        intmiddle = low + (high - low) / 2;
        intpivot = arr[middle];
 
        // make left < pivot and right > pivot
        inti = low, j = high;
        while (i <= j)
        {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot)
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot)
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
            if (i <= j)
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }
```

**With first element as pivot**
```
void quickSort(int arr[], int low, int high) {
if(low < high) {
in tpart = part(arr,low,high);
quickSort(arr, low , part-1);
quickSort(arr, part+1, high);
}
}
    static int partition ( int A[ ],int start ,int end) {
    int i = start + 1;
    int piv = A[start] ; //make the first element as pivot element. 
    for(int j=start + 1; j <= end ; j++ )  {
    /*rearrange the array by putting elements which are less than pivot
      on one side and which are greater that on other. */
          if ( A[j] < piv) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i += 1;
          }
  }
  int temp = A[start];
          A[start] = A[i-1];
          A[i-1] = temp;
          i += 1;//put the pivot element in its proper place.
  return i-1;                      //return the position of the pivot
}
```

# Heap Sort
Heap sort algorithm is divided into two basic parts:
- Creating a Heap of the unsorted list/array.
- Then a sorted array is created by repeatedly removing the largest/smallest element from the heap, and inserting it into the array. The heap is reconstructed after each removal.



