package com.he.树.q98验证二叉搜索树;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(isValidBST(root));
    }
    private static boolean isValidBST(TreeNode root) {
        //return helper(root,null,null);
        return helper(root);
    }

    // 迭代
    private static boolean helper(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // Double.MIN_VALUE 是大于0 的？？？？
        double prev = -Double.MAX_VALUE;
        while (!stack.empty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            int value = root.val;
            if(prev >= value){
                return false;
            }
            prev = value;
            root = root.right;
        }
        return true;
    }

    // 递归
    private static boolean helper(TreeNode root,Integer low,Integer upper){
        if(root == null){
            return true;
        }
        if(low != null && root.val <= low){
            return false;
        }
        if(upper != null && root.val >= upper){
            return false;
        }
        if(!helper(root.left,null,root.val)){
            return false;
        }
        if (!helper(root.right, root.val, null)) {
            return false;
        }
        return true;
    }
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


