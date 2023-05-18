# Hash Tables
* https://www.techinterviewhandbook.org/algorithms/hash-table/

## HashMap vs HashSet
Both are implemented in Java using the Hash Table class.

|   HashMap     |       HashSet     |
|-----------------|---------------------|
| Implemented by using Map interface.   |   Implemented in Java using Set interface |
|A HashMap stores key-value pairs.  | HashSet is a class which implements the Set interface and this interface only stores values, not a key-value pair. |
| HashMap cannot contain duplicate keys. It can, however, have duplicate values. HashMap also allows multiple null values and only one null key. | HashSet restricts storing multiple null values and only allows one null value in the whole table. |
|  This mechanism does not support synchronous operations and is not thread-safe.   | Just like HashMap, HashSet also does not support synchronous operations |

<br>
<b>Note: </b> <br>
HashSet stores values in an unordered way, using hashing.  On the backend, the HashSet class is implemented using the HashMap class. The value that we add to the HashSet is then added to the HashMap as a key, corresponding to a dummy value Object. The retrieval remains O(1)
<br/> <br/>

## Hashmap vs Hashtable
1. HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
2. HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
3. HashMap is generally preferred over HashTable if thread synchronization is not needed

### Why HashTable doesn’t allow null and HashMap does?
To successfully store and retrieve objects from a HashTable, the objects used as keys must implement the hashCode method and the equals method. Since null is not an object, it can’t implement these methods. HashMap is an advanced version and improvement on the Hashtable. HashMap was created later.