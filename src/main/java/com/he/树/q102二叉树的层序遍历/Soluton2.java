package com.he.树.q102二叉树的层序遍历;

import com.he.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Soluton2 {
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
    private static List<List<Integer>> levelOrder(TreeNode root) {
        //按层遍历即可
        //1.返回结果
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        //2.队列，存放下一层元素
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> list = new ArrayList<Integer>();
            // size 表示当前层有多少个节点
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.poll();
                if(remove!=null) {
                    list.add(remove.getVal());
                    if (remove.getLeft() != null) {
                        nodes.add(remove.getLeft());
                    }
                    if (remove.getRight() != null) {
                        nodes.add(remove.getRight());
                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
