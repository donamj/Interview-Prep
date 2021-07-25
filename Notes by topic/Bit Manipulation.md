1. The binary representation of-K (negative K) as a N-bit number is concat ( 1, 2^(N-1) -K). Another way to look at this is that we invert the bits in the positive representation and then add 1. 3 is 011 in binary. Flip the bits to get 100, add 1 to get 101, then prepend the sign bit (1) to get 1101.

2. In a logical right shift, we shift the bits and put a 0 in the most significant bit. It is indicated with a >>> operator.

3. In an arithmetic right shift, we shift values to the right but fill in the new bits with the value of the sign bit. This has the effect of(roughly) dividing by two. It is indicated by a  >> operator.

**Get Bit** <br>
This method shifts 1 over by i bits, creating a value that looks like 00010000. By performing an AND with num, we clear all bits other than the bit at bit i. Finally, we compare that to 0. If that new value is not zero, then bit i must have a 1. Otherwise, bit i is a 0.

**Set Bit** <br>
Set Bit shifts 1 over byi bits, creating a value like 00010000. By performing an OR with num, only the value at bit i will change. All other bits of the mask are zero and will not affect num.
