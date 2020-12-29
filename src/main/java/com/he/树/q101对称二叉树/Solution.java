package com.he.树.q101对称二叉树;

import com.he.common.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode  treeNode = new TreeNode(1);
        TreeNode  treeNode2 = new TreeNode(2);
        TreeNode  treeNode3 = new TreeNode(2);
        TreeNode  treeNode4 = new TreeNode(3);
        TreeNode  treeNode5 = new TreeNode(4);
        TreeNode  treeNode6 = new TreeNode(4);
        TreeNode  treeNode7 = new TreeNode(3);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        treeNode3.setLeft(treeNode6);
        treeNode3.setRight(treeNode7);
        boolean symmetric = isSymmetric(treeNode);
        System.out.println(symmetric);

    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.getLeft(),root.getRight());
    }


    //     1
    //   /  \
    //  2    2
    // / \  / \
    // 3  4 4  3
    private static boolean check(TreeNode left,TreeNode right){
        if(left == null && right ==null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        // 根节点的值是一致的
        // 一个树的左子树 跟另一个树的右子树镜像对称  所以判断时 需要判断 一棵树的左子树的值 是否等于另一棵树右子树的值（递归）
        return left.getVal() == right.getVal() &&
                check(left.getLeft(),right.getRight()) &&
                check(left.getRight(),right.getLeft());
    }
}
