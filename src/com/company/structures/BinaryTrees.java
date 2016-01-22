package com.company.structures;

/**
 * Created by fertkir on 23.01.16.
 */
public class BinaryTrees {

    public static void main(String[] args) {
        BinaryNode tree = new BinaryNode(
                new BinaryNode(
                        new BinaryNode(null, null),
                        null
                ),
                new BinaryNode(null, null)
        );
        System.out.println(getMaxDepth(tree));
    }

    static class BinaryNode {
        private BinaryNode left;
        private BinaryNode right;

        BinaryNode(BinaryNode left, BinaryNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static int getMaxDepth(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
