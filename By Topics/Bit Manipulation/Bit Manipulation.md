# Bit Manipulation


Here are some common bit manipulation operations:

* **Bitwise AND (&)**: Compares two bits and produces a result where the output bit is set if both input bits are set.

* **Bitwise OR (|)**: Compares two bits and produces a result where the output bit is set if either of the input bits is set.

* **Bitwise XOR (^)**: Compares two bits and produces a result where the output bit is set if the input bits are different.

* **Bitwise NOT (~)**: Flips the bits, converting 0 to 1 and 1 to 0.

* **Left shift (<<)**: Shifts the bits of a number to the left by a specified number of positions. This operation effectively multiplies the number by 2 for each shift.

* **Right shift (>>)**: Shifts the bits of a number to the right by a specified number of positions. This operation effectively divides the number by 2 for each shift.

<br/>

## BitSet
BitSet is a class in Java that represents a resizable array of bits, where each bit can be either 0 or 1. It is part of the java.util package and is commonly used for efficient manipulation of sets of flags or boolean values. The BitSet array can increase in size as needed.


```
BitSet bits = new BitSet(16);

// set some bits
for(int i = 0; i < 16; i++) {
    if((i % 2) == 0) bits.set(i);
}

System.out.println(bits);
```

Output: `{0, 2, 4, 6, 8, 10, 12, 14}`


<br/>

## Useful Links
* https://www.techinterviewhandbook.org/algorithms/binary/
* https://www.educative.io/blog/bit-manipulation-in-java
* https://www.educative.io/blog/top-java-coding-interview-questions
* https://www.educative.io/blog/top-50-java-data-structure-interview-questions
* https://www.educative.io/blog/ace-top-15-java-algorithm-questions#dp