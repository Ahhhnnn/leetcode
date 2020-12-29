package com.he.树.J55II平衡二叉树;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        // 解法一
        //return recur(root) != -1;

        // 解法二
        if(root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2  && isBalanced(root.left) && isBalanced(root.right);
    }

    // 后续遍历加剪枝
    // 如果左右子树深度>1 则剪枝
    private int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) +1 : -1;
    }

    // 解法二
    // 先序遍历，判断每一个子树的深度，所有的子树如果都是平衡二叉树，那么返回true
    private int depth(TreeNode root){
        if (root == null)  return 0;
        return Math.max(depth(root.left),depth(root.right)) +1;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
