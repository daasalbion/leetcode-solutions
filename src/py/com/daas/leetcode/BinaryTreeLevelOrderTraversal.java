package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal exercise = new BinaryTreeLevelOrderTraversal();
        BinaryTreeUtil.TreeNode root = BinaryTreeUtil.build("[3,9,20,null,null,15,7]");
        System.out.println(exercise.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int cLevelSize = deque.size();
            List<Integer> cLevel = new ArrayList<>(cLevelSize);
            for (int i = 0; i < cLevelSize; i++) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode != null) {
                    if (treeNode.left != null) {
                        deque.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.add(treeNode.right);
                    }

                    cLevel.add(treeNode.val);
                }
            }

            result.add(cLevel);
        }

        return result;
    }
}
