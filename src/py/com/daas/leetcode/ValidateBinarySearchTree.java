package py.com.daas.leetcode;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree exercise = new ValidateBinarySearchTree();
        BinaryTreeUtil.TreeNode root = BinaryTreeUtil.build("[2,2,2]");
        System.out.println(exercise.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode cNode, long leftValue, long rightValue) {
        if (cNode == null) return true;
        if (cNode.val <= leftValue || cNode.val >= rightValue) return false;

        boolean isValidLeftNode = isValidNode(cNode.left, leftValue, cNode.val);
        boolean isValidRightNode = isValidNode(cNode.right, cNode.val, rightValue);

        return isValidLeftNode && isValidRightNode;
    }

}
