package com.he.树.q235二叉搜索树的最近公共祖先;

import com.he.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 输入p = 2 q = 8
 * 返回 6
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right = new TreeNode(9);
        root.right.right.left = null;
        root.right.right.right =null;
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.left.left.left  =null;
        root.left.left.right  =null;
        //TreeNode treeNode = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        TreeNode treeNode = lowestCommonAncestor2(root, new TreeNode(2), new TreeNode(8));
        System.out.println(treeNode.val);
    }


    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode ancestor = root;
        while (true){
            if(ancestor.val > p.val && ancestor.val > q.val){
                ancestor = ancestor.left;
            }else if(ancestor.val < p.val && ancestor.val < q.val){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }

        return ancestor;
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp = getPath(root, p);
        List<TreeNode> pathq = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
            if(pathp.get(i).val == pathq.get(i).val){
                ancestor = pathp.get(i);
            }else{
                break;
            }
        }
        return ancestor;
    }

    // 两次遍历
    public static List<TreeNode> getPath(TreeNode root,TreeNode target){
        List<TreeNode> result = new ArrayList<>();

        while (root.val != target.val){
            result.add(root);
            if(target.val < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        result.add(root);
        return result;
    }
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
