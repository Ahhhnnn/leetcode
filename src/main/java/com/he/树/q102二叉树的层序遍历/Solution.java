package com.he.树.q102二叉树的层序遍历;

import com.he.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



 示例：
 二叉树：[3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode3.setRight(treeNode5);
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists);
    }

    // 双队列 将根节点放入队列一，取出队列一的元素，将所有子节点放入队列二，那么队列二中的元素一定是下一层的元素
    // 当队列一为空时，将队列二复制到队列一，清空队列二，重复操作，直到都为空
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }
        queue1.offer(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> leave = new ArrayList<Integer>();
            while (!queue1.isEmpty()){
                TreeNode poll = queue1.poll();
                leave.add(poll.getVal());
                if(poll.getLeft()!=null){
                    queue2.offer(poll.getLeft());
                }
                if(poll.getRight()!=null){
                    queue2.offer(poll.getRight());
                }
            }
            queue1.addAll(queue2);
            queue2.clear();
            result.add(leave);

        }
        return result;
    }

}
