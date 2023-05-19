package py.com.daas.leetcode;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree exercise = new MaximumDepthOfBinaryTree();
        BinaryTreeUtil.TreeNode root = BinaryTreeUtil.build("[1,null,2]");
        BinaryTreeUtil.TreeNode root2 = BinaryTreeUtil.build("[3,9,20,null,null,15,7]");
        System.out.println(exercise.maxDepth(root));
        System.out.println(exercise.maxDepth(root2));
    }

    public int maxDepth(TreeNode root) {
        int sum = 0;
        return calculateDepth(root, sum);
    }

    private int calculateDepth(TreeNode cNode, int sum) {
        if (cNode == null) {
            return sum;
        }
        sum++;
        int leftSum = calculateDepth(cNode.left, sum);
        int rightSum = calculateDepth(cNode.right, sum);

        return Math.max(leftSum, rightSum);
    }
}
