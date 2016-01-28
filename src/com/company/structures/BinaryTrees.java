package com.company.structures;

import java.util.*;
import java.util.LinkedList;

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
        BinaryNode minimalBST = makeMinimalBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(Arrays.toString(treeLines(minimalBST).toArray()));
        System.out.println(getNextByOrder(minimalBST).value);
    }

    static class BinaryNode {
        private int value;
        private BinaryNode left;
        private BinaryNode right;
        private BinaryNode parent;

        BinaryNode(int value) {
            this.value = value;
        }

        BinaryNode(int value, BinaryNode left, BinaryNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
            if (left != null) {
                left.parent = this;
            }
            if (right != null) {
                right.parent = this;
            }
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

    /**
     * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
     */
    public static BinaryNode makeMinimalBST(int[] arr) {
        return makeMinimalBST(arr, 0, arr.length - 1);
    }

    private static BinaryNode makeMinimalBST(int[] arr, int from, int to) {
        if (to < from) {
            return null;
        }
        int mid = (from + to) / 2;
        BinaryNode node = new BinaryNode(arr[mid]);
        node.left = makeMinimalBST(arr, from, mid - 1);
        node.right = makeMinimalBST(arr, mid + 1, to);
        return node;
    }

    /**
     * Given a binary search tree, design an algorithm which creates a linked list of all the
     * nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
     */
    public static List<List<Integer>> treeLines(BinaryNode root) {
        List<List<Integer>> lines = new ArrayList<>();
        treeLines(root, 0, lines);
        return lines;
    }

    private static void treeLines(BinaryNode node, int level, List<List<Integer>> lines) {
        if (node == null) {
            return;
        }
        if (lines.size() == level) {
            lines.add(new LinkedList<>());
        }
        lines.get(level).add(node.value);
        treeLines(node.left, level + 1, lines);
        treeLines(node.right, level + 1, lines);
    }

    /**
     * Write an algorithm to find the ‘next’ node (e.g., in-order successor)
     * of a given node in a binary search tree where each node has a link to its parent.
     */
    public static BinaryNode getNextByOrder(BinaryNode node) {
        if (node == null) {
            return null;
        }
        BinaryNode next = null;
        if (node.right != null) {
            next = node.right;
            while (next.left != null) {
                next = next.left;
            }
        } else {
            next = node.parent;
            while (next != null && next.left != node) {
                node = next;
                next = next.parent;
            }
        }
        return next;
    }
}
