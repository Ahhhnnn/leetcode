package com.he.树.q101对称二叉树;

import com.he.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
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

    // 队列实现迭代
    private static boolean check(TreeNode left,TreeNode right){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()){
           left = queue.poll();
           right = queue.poll();

           if(left == null && right ==null){
               return true;
           }

           if(left == null || right ==null){
               return false;
           }
           if(left.getVal() != right.getVal()) {
               return false;
           }
           //  一个树的左子树 跟另一个树的右子树镜像对称  所以判断时 需要判断 一棵树的左子树的值 是否等于另一棵树右子树的值
            // 所以这里 成对的入队列  保持对应关系
           queue.offer(left.getLeft());
           queue.offer(right.getRight());

           queue.offer(left.getRight());
           queue.offer(right.getLeft());
        }
        return  true;
    }
}
