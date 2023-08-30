package py.com.daas.leetcode;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        PathSum minimumDepthOfBinaryTree = new PathSum();
        TreeNode root = BinaryTreeUtil.build("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(minimumDepthOfBinaryTree.hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return sumTreeNode(root, 0, targetSum);
    }

    private boolean sumTreeNode(TreeNode cNode, int sum, int targetSum) {
        sum += cNode.val;
        // leaf node
        if (cNode.left == null && cNode.right == null) {
            return sum == targetSum;
        }
        boolean left = false;
        boolean right = false;
        if (cNode.left != null) {
            left = sumTreeNode(cNode.left, sum, targetSum);
        }
        if (cNode.right != null) {
            right = sumTreeNode(cNode.right, sum, targetSum);
        }

        return left || right;
    }
}
