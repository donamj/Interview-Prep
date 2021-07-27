## Table of Contents
- [Copy linked list with arbitrary pointer](#copy-linked-list-with-arbitrary-pointer)
- [Remove duplicate elements](#remove-duplicate-elements)
- [Return the kth last element](#return-the-kth-last-element)
- [Delete middle node](#delete-middle-node)
- [Palindrome Linked list](#palindrome-linked-list)
- [Find the intersection of 2 linked lists](#find-the-intersection-of-2-linked-lists)
- [Loop in a linked list](#loop-in-a-linked-list)

<br>

## Copy linked list with arbitrary pointer
- Add every node as the next node of existing node.
- In second iteration, establish the random pointer relationship
- Separate both the lists

    ```
    public Node copyRandomList(Node head) {
            
            if(head ==  null)
                return null;
            
            Node node = head;
            while(node != null)
            {
                Node temp = new Node(node.val);
                
                temp.next = node.next;
                node.next = temp;
                node = temp.next;
            }
            
            node = head;
            while(node != null)
            {
                node.next.random = node.random != null ? node.random.next : null;
                node = node.next.next;
            }
            
            Node oldList = head;
            Node newList = head.next;
            
            Node newHead = head.next;
            
            while(oldList != null)
            {
                oldList.next = oldList.next.next;
                newList.next = newList.next != null ? newList.next.next : null;
                oldList = oldList.next;
                newList = newList.next;
            }
            
            return newHead;
        }
    ```

## Remove duplicate elements   
- Add each element traversed to a set
- If there is no buffer allowed - Use 2 pointers, one to traverse each element and the other one to search in the rest of the list for duplicate

## Return the kth last element
- If the linked list size is known – look for (length-k) th element
- If the size is unknown <br>
Use 2 pointers. Traverse the first point to the kth element and then start the second pointer. The distance between both the pointers is now k. When the first pointer reaches the end, the second pointer will be at kth position from last.

## Delete middle node
- Have 2 pointers - fast and slow pointer.
- Have the fast pointer move twice for each iteration

## Palindrome Linked list          
- We have to check if the first half of the list is the reverse of second half. Use a stack. Keep adding elements till the middle (use fast and slow pointer) and then pop each element from the stack to see if it is same as the rest of the elements in the linked list.

## Find the intersection of 2 linked lists
- Find the lengths of the lists
- If the last elements are not the same, there is no intersection
- Find the difference in the list and then traverse the longer list to match the difference. Now we have same number of nodes to traverse in both the lists. Compare each element to see where the lists intersect
	
## Loop in a linked list
- Traverse until fast != null && fast.next != null
- Keep a slow pointer and fast pointer, faster pointer moving twice the slow pointer
- If slow = = fast , there exists a loop
- To find the beginning of the loop:
    - Slow = head and fast stays at the same point
	- Traverse until slow = = fast
	- Return the point where it meets and it will be the beginning of the loop

