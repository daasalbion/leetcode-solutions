package py.com.daas.leetcode;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree exercise = new SymmetricTree();
        BinaryTreeUtil.TreeNode root = BinaryTreeUtil.build("[2,3,3,4,5,null,4]");
        BinaryTreeUtil.TreeNode root2 = BinaryTreeUtil.build("[1,2,2,3,4,4,3]");
        System.out.println(exercise.isSymmetric(root));
        System.out.println(exercise.isSymmetric(root2));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return compareNodes(root.left, root.right);
    }

    private boolean compareNodes(TreeNode cNodeLeft, TreeNode cNodeRight) {
        // we need to go to the leaf node in both branches
        if (cNodeLeft == null && cNodeRight == null) return true;
        // if one of then is null, branches are not comparables
        if (cNodeLeft == null ^ cNodeRight == null) return false;
        // we can continue evaluating
        if (cNodeLeft.val == cNodeRight.val) {
            boolean isValidExternalBranches = compareNodes(cNodeLeft.left, cNodeRight.right);
            boolean isValidInternalBranches = compareNodes(cNodeLeft.right, cNodeRight.left);
            return isValidExternalBranches && isValidInternalBranches;
        }

        return false;
    }

    // 0) [1]
    // 1) [2, 2]
    // 2) [3, 3], [4, 4]
}
