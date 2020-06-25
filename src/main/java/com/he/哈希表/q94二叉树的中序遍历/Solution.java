package com.he.哈希表.q94二叉树的中序遍历;

import com.he.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个二叉树，返回它的中序 遍历。
 * 中序遍历  左子树->根节点->右子树
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        //构建二叉树
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.setLeft(null);
        treeNode1.setRight(treeNode2);
        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(null);
        treeNode3.setLeft(null);
        treeNode3.setRight(null);
        List<Integer> result = inorderTraversal(treeNode1);
        System.out.println(result);
    }
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root,result);
        return result;
    }

    private static void helper(TreeNode root,List<Integer> list){
        if(root.getLeft() != null){
            helper(root.getLeft(),list);
        }
        //如果没有左子树，说明自己就是叶子节点，将自己的value加进去
        list.add(root.getVal());
        if(root.getRight()!=null){
            helper(root.getRight(),list);
        }
    }

}

