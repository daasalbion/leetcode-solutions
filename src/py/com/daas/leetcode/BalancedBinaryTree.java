package py.com.daas.leetcode;

public class BalancedBinaryTree {

  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    BalancedBinaryTree list = new BalancedBinaryTree();
    TreeNode root = getTree();
    System.out.println("isValid = " + list.isBalanced(root));
  }

  private static TreeNode getTree() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    return root;
  }


  public int getHeight(TreeNode node) {
    if (node == null) return 0;
    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);
    if (leftHeight == -1 || rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;

    return 1 + Math.max(leftHeight, rightHeight);
  }

  public boolean isBalanced(TreeNode root) {
    return getHeight(root) != -1;
  }

}
