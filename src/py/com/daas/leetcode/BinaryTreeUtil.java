package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BinaryTreeUtil {

    private BinaryTreeUtil() {
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode build(String strArray) {
        List<String> values = Arrays
                .stream(strArray.trim().replace("[", "").replace("]", "").split(","))
                .collect(Collectors.toList());
        Deque<String> dequeValues = new ArrayDeque<>(values);
        if (dequeValues.isEmpty()) return null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(dequeValues.pollFirst()));
        deque.add(root);

        while (!dequeValues.isEmpty() && !deque.isEmpty()) {
            TreeNode cNode = deque.pollFirst();
            Optional<String> leftV = Optional.ofNullable(dequeValues.pollFirst());
            Optional<String> rightV = Optional.ofNullable(dequeValues.pollFirst());
            if (leftV.isPresent() && !leftV.get().equals("null")) {
                cNode.left = new TreeNode(Integer.parseInt(leftV.get()));
                deque.add(cNode.left);
            }
            if (rightV.isPresent() && !rightV.get().equals("null")) {
                cNode.right = new TreeNode(Integer.parseInt(rightV.get()));
                deque.add(cNode.right);
            }
        }

        return root;
    }
}
