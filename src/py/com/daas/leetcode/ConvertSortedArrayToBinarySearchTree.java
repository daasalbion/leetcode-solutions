package py.com.daas.leetcode;

import py.com.daas.leetcode.BinaryTreeUtil.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree exercise = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = exercise.sortedArrayToBST(nums);
        System.out.println(root);
    }

    /*
    Input: nums = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: [0,-10,5,null,-3,null,9] is also accepted:
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // nums esta ordenado
        // los subarboles tienen 1 de deferencia de altura como maximo
        // 1) dividir nums en 2 para obtener la raiz
        // 2) expandir las iteraciones de a uno hasta agregar al menos un nodo hijo
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (end + start) / 2;
        TreeNode cRoot = new TreeNode(nums[mid]);
        cRoot.left = createBST(nums, start, mid - 1);
        cRoot.right = createBST(nums, mid + 1, end);

        return cRoot;
    }

}
