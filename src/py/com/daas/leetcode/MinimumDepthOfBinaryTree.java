package py.com.daas.leetcode;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        BinaryTreeUtil.TreeNode root = BinaryTreeUtil.build("[3,9,20,null,null,15,7]");
        BinaryTreeUtil.TreeNode root2 = BinaryTreeUtil.build("[2,null,3,null,4,null,5,null,6]");
        System.out.println(minimumDepthOfBinaryTree.minDepth(root));
        System.out.println(minimumDepthOfBinaryTree.minDepth(root2));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);

        if (root.left == null) {
            return rDepth + 1;
        }
        if (root.right == null) {
            return lDepth + 1;
        }

        return Math.min(lDepth, rDepth) + 1;
    }
}
