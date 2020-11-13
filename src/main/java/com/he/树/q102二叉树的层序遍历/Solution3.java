package com.he.树.q102二叉树的层序遍历;

import com.he.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

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
        List<List<Integer>> lists = levelOrderDFS(treeNode);
        System.out.println(lists);
    }
    private static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists,root,0);
        return lists;
    }

    private static void dfs( List<List<Integer>> lists,TreeNode node,Integer level){
        if(node == null)
            return;
        // 如果当前层没有初始化，那么初始化一个链表用于存储
        if(lists.size() < level +1)
            lists.add(new ArrayList<>());
        if(lists.get(level) == null){
            List<Integer> list = new ArrayList<>();
            list.add(node.getVal());
            lists.get(level).addAll(list);
        }else{
            lists.get(level).add(node.getVal());
        }
        dfs(lists,node.getLeft(),level+1);
        dfs(lists,node.getRight(),level+1);
    }
}
