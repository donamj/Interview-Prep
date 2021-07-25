/*
    The runtime complexity of this solution is linear, O(n).

    The memory complexity of this solution is O(h)

    The recursive solution has O(h) memory complexity as it will consume memory on the stack up to the height of binary tree h.
    It will be O(log n) for a balanced tree and, in the worst case, can be O(n).


*/

class IdenticalTree {
    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
          return true;
        }
    
        if (root1 != null && root2 != null) {
          return ((root1.data == root2.data) &&
                  areIdentical(root1.left, root2.left) &&
                  areIdentical(root1.right, root2.right));
        }
    
        return false;
      }
}
