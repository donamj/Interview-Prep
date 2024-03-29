## Table of Contents
- [Invert a binary tree](#invert-a-binary-tree)
- [Check if Two Binary Trees are Identical](#check-if-two-binary-trees-are-identical)
- [Serialize Tree](#serialize-tree)
- [Deserialize Tree](#deserialize-tree)
- [Check if tree is complete](#check-if-tree-is-complete)
- [Check if a BST is valid](#check-if-a-bst-is-valid)
- [Sub tree of another tree](#sub-tree-of-another-tree)
- [Count of smaller numbers after self](#count-of-smaller-numbers-after-self)
- [Height of a binary tree](#height-of-a-binary-tree)
- [Level order traversal](#level-order-traversal)
<br>


## Invert a binary tree
- Swap the left and right nodes
    ```
        public TreeNode invertTree(TreeNode root) {
                
            if(root == null)
                return null;
            
            TreeNode rightChild = invertTree(root.right);
            TreeNode leftChild = invertTree(root.left);
                
            root.left = rightChild;
            root.right = leftChild;
                
            return root;
                
        }
    ```

## Check if Two Binary Trees are Identical
- Compare left and right nodes
    ```
        public boolean isSameTree(TreeNode p, TreeNode q) {
            
            if(p == null && q == null)
                return true;
            
            if(q == null || p == null)
                return false;
            
            if(p.val != q.val )
                return false;
            
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
            
        }
    ```

## Serialize Tree
```
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        String str = "";
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNode n = q.poll();
            if(n == null)
                str = str + "null,";
            else
            {
                str = str + n.val + ", ";
                q.add(n.left);
                q.add(n.right);
            }
            
        }
        
        return str;
        
    }
```

## Deserialize Tree
```
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String str[] = data.split(",");
        
        TreeNode root = str[0].trim().equals("null") ? null : new TreeNode(Integer.valueOf(str[0].trim()));;
        
            
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        for(int i = 1; i < str.length; i++)
        {
            TreeNode curr = q.poll();
            
            String s1 = str[i].trim();
            String s2 = str[++i].trim();
    
            TreeNode left = s1.equals("null") ? null : new TreeNode(Integer.valueOf(s1));
            TreeNode right = s2.equals("null") ? null : new TreeNode(Integer.valueOf(s2));
            curr.left = left;
            curr.right = right;
            
            if(left != null)
                q.add(left);
            if(right != null)
                q.add(right);
        }
        
        return root;     
    }
```

## Check if tree is complete
```
    public static boolean isComplete(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return false;
        }
 
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node front;
 
        // flag to mark the end of full nodes
        boolean flag = false;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // dequeue front node
            front = queue.poll();
 
            // if we have encountered a non-full node before and the current node is not a leaf, a tree  cannot be complete
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
 
            // if the left child is empty and the right child exists, a tree cannot be complete
            if (front.left == null && front.right != null) {
                return false;
            }
 
            // if the left child exists, enqueue it
            if (front.left != null) {
                queue.add(front.left);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                flag = true;
            }
 
            // if the right child exists, enqueue it
            if (front.right != null) {
                queue.add(front.right);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                flag = true;
            }
        }
 
        return true;
    }
 
```
**Time complexity:** O(N) since we visit each node exactly once. <br>
**Space complexity:** O(N)

## Check if a BST is valid
```
    public boolean isValidBST(TreeNode root) 
    {
        return validate(root, null, null);
    }
    
     public boolean validate(TreeNode root, Integer low, Integer high) 
     {         
         if(root == null)
            return true;
         
         if((low != null && root.val <= low) || (high != null && root.val >= high))
             return false;
         
         return validate(root.right, root.val, high) && validate(root.left, low, root.val);        
    }
``` 
**Time complexity:** O(N) since we visit each node exactly once. <br>
**Space complexity:** O(N) since we keep up to the entire tree. 

<br>

## Inorder successor in BST
1. We start our traversal with the root node and continue the traversal until our current node reaches a null value i.e. there are no more nodes left to process.

2. At each step we compare the value of node p with that of node.
    - If p.val >= node.val that implies we can safely discard the left subtree since all the nodes there including the current node have values less than p.

    - However, if p.val < node.val, that implies that the successor must lie in the left subtree and that the current node is a potential candidate for inorder successor. Thus, we update our local variable for keeping track of the successor, successor, to node.

3. Return successor.

```
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {
        
        TreeNode successor = null;
        
        while (root != null) {
            
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        
        return successor;
    }
```

**Time Complexity:** O(N) since we might end up encountering a skewed tree and in that case, we will just be discarding one node at a time. 


## Sub tree of another tree
```
public class Solution 
{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}
```

**Time complexity:** O(m*n) <br>
**Space complexity:** O(n), the depth of the recursion tree can go upto n. n refers to the number of nodes in s.


## Count of smaller numbers after self
```
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
         
        BSTNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], i, result, 0);
        }
         
        return Arrays.asList(result);
    }
     
    private BSTNode insert(BSTNode root, int num, int i, Integer[] result, 
                           int preSum) {
        if (root == null) {
            root = new BSTNode(num, 0);
            result[i] = preSum;
            return root;
        } else if (root.val == num) {
            root.dup++;
            result[i] = preSum + root.numOfLeftNodes;
            return root;
        } else if (root.val > num) {
            root.numOfLeftNodes++;
            root.left = insert(root.left, num, i, result, preSum);
        } else {
            root.right = insert(root.right, num, i, result, 
                preSum + root.numOfLeftNodes + root.dup);
        }
         
        return root;
    }
     
    class BSTNode {
        int val;
        int dup = 1;
        int numOfLeftNodes;
        BSTNode left, right;
         
        BSTNode(int val, int numOfLeftNodes) {
            this.val = val;
            this.numOfLeftNodes = numOfLeftNodes;
        }
    }
}
```
<br/>

## Height of a binary tree
Time Complexity :- O(N)

Space Complexity :- O(N)
```
public int maxDepth(TreeNode root) 
{
    // Base Condition
    if(root == null) return 0;
    // Hypothesis
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    // Induction
    return Math.max(left, right) + 1;
}
```

## Lowest common ancestor of a node
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Time complexity: O(h), h is the height of the tree.

Space complexity: O(h), total h stack spaces in recursive calls.
```
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root.val > p.val && root.val > q.val){
        return lowestCommonAncestor(root.left,p,q);
    }
    
    if(root.val < p.val && root.val < q.val){
        return lowestCommonAncestor(root.right,p,q);
    }
    
    //  If above 2 conditions doesn't satisfy then 2 cases will arise. For them we simply return the current node.
    return root;
}
```

### Level order traversal
Time complexity: O(n)

Space complexity: O(n)

```
public List<List<Integer>> levelOrder(TreeNode root) {
        
    // Initialize an empty list to hold the result
    List<List<Integer>> result = new ArrayList<>();

    // If the root is null, return an empty list
    if (root == null) {
        return result;
    }

    // Initialize a queue to hold the nodes in the current level
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    // Traverse the tree level by level
    while (!queue.isEmpty()) {
        
        // Get the number of nodes in the current level
        int levelSize = queue.size();

        // Initialize a list to hold the nodes in the current level
        List<Integer> levelNodes = new ArrayList<>();

        // Traverse the nodes in the current level
        for (int i = 0; i < levelSize; i++) {
            // Get the first node in the queue
            TreeNode node = queue.remove();

            // Add the node's value to the list of nodes in the current level
            levelNodes.add(node.val);

            // Add the node's children to the queue for the next level
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        // Add the list of nodes in the current level to the result
        result.add(levelNodes);
    }
// Return the final result
return result;
}
```