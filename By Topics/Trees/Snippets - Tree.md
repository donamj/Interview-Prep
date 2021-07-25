## Table of Contents
- [Find number of islands](#find-number-of-islands)
- [Invert a binary tree](#invert-a-binary-tree)
- [Check if Two Binary Trees are Identical](#check-if-two-binary-trees-are-identical)
- [Serialize Tree](#serialize-tree)
- [Deserialize Tree](#deserialize-tree)
- [Check if tree is complete](#check-if-tree-is-complete)
- [Check if a BST is valid](#check-if-a-bst-is-valid)
- [Sub tree of another tree](#sub-tree-of-another-tree)

<br>

## Find number of islands
- Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search. 
- During DFS, every visited node should be set as '0' to mark as visited node.
- Count the number of root nodes that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies an island.
    ```
    public int numIslands(char[][] grid) {
            
            if(grid == null || grid.length == 0)
                return 0;
            
            int rowLen = grid.length;
            int colLen = grid[0].length;
            
            int count = 0;
            
            
            for(int row = 0; row < rowLen; row ++)
            {
                for(int col = 0; col <colLen; col++)
                {
                    if(grid[row][col] == '1')
                    {
                        count++;
                        traverse(grid, row, col);
                    }
                }
            }
            
            return count;
            
        }
        
        void traverse(char grid[][], int row, int col)
        {
            int rowLen = grid.length;
            int colLen = grid[0].length;
            
            if(row < 0 || col < 0 || row >= rowLen || col >= colLen || grid[row][col] == '0')
                return;
            
            grid[row][col] = '0';
            
            traverse(grid, row - 1, col);
            traverse(grid, row + 1, col);
            traverse(grid, row, col - 1);
            traverse(grid, row, col + 1);

        }
    ```

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
    public boolean isCompleteTree(TreeNode root) {
        
        if(root == null)
            return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        boolean isComplete = false;
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            
            if(node.left != null)
            {
                if(isComplete)
                    return false;
                
                q.add(node.left);
            }
            else
                isComplete = true;
            
            if(node.right != null)
            {
                if(isComplete)
                    return false;
                
                q.add(node.right);
            }
            else
                isComplete = true;
        }
        
        return true;
    }
```

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