
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
