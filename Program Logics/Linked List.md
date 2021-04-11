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