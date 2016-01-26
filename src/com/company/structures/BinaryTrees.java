package com.company.structures;

/**
 * Created by fertkir on 23.01.16.
 */
public class BinaryTrees {

    public static void main(String[] args) {
        BinaryNode tree =
                new BinaryNode(5,
                        new BinaryNode(4,
                                new BinaryNode(1,
                                        null,
                                        null),
                                null),
                        new BinaryNode(7,
                                new BinaryNode(6,
                                        null,
                                        null),
                                null)
        );
        System.out.println(getMaxDepth(tree));
        System.out.println(isSearchTree(tree));
        System.out.println(isBalanced(tree));
    }

    static class BinaryNode {
        private int value;
        private BinaryNode left;
        private BinaryNode right;

        BinaryNode(int value) {
            this.value = value;
        }

        BinaryNode(int value, BinaryNode left, BinaryNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Get the depth of a binary tree
     */
    public static int getMaxDepth(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    /**
     * Verify whether a binary tree is a binary search tree
     */
    public static boolean isSearchTree(BinaryNode root) {
        return isSearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSearchTree(BinaryNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value <= min || root.value >= max) {
            return false;
        }
        return isSearchTree(root.left, min, root.value) &&
                isSearchTree(root.right, root.value, max);
    }

    /**
     * Check whether binary tree is balanced
     */
    public static boolean isBalanced(BinaryNode root) {
        return isBalanced(root, new int[1]);
    }

    private static boolean isBalanced(BinaryNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return true;
        }
        boolean leftBalanced = isBalanced(root.left, height);
        int leftHeight = height[0];
        boolean rightBalanced = isBalanced(root.right, height);
        int rightHeight = height[0];
        int difference;
        if (leftHeight > rightHeight) {
            height[0] = 1 + leftHeight;
            difference = leftHeight - rightHeight;
        } else {
            height[0] = 1 + rightHeight;
            difference = rightHeight - leftHeight;
        }
        return leftBalanced && rightBalanced && difference <= 1;
    }
}
