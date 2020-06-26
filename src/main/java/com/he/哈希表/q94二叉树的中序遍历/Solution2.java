package com.he.哈希表.q94二叉树的中序遍历;


import com.he.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    public static void main(String[] args) {
        //构建二叉树
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.setLeft(null);
        treeNode1.setRight(treeNode2);
        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode4);
        //treeNode2.setRight(null);
        treeNode3.setLeft(null);
        treeNode3.setRight(null);
        //List<Integer> result = inorderTraversal(treeNode1);
        //List<Integer> result = beforeInorderTraversal(treeNode1);
        List<Integer> result = afterInorderTraversal(treeNode1);
        System.out.println(result);
    }

    /*
    采用栈的方式中序遍历
     */
    private static List< Integer > inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !treeNodeStack.empty()){
            //一直遍历，直到没有左子树
            while (current != null){
                treeNodeStack.push(current);
                current = current.getLeft();
            }
            //没有左子树时，弹出栈中第一个元素，为最左的叶子节点
            current = treeNodeStack.pop();
            result.add(current.getVal());
            //这个时候这个节点已经没有左子树，如果有右子树，继续上面的逻辑，找到这个右子树的所有左子树压入栈中
            current = current.getRight();
        }
        return result;
    }

    /*
    采用栈的方式前序遍历
     */
    private static List< Integer > beforeInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current!=null || !treeNodeStack.empty()){
            while (current!=null){
                result.add(current.getVal());
                treeNodeStack.push(current.getRight());
                current = current.getLeft();
            }
            current = treeNodeStack.pop();
        }
        return result;
    }

    /*
    采用栈的方式后序遍历
    后续遍历可以跟前序相对称，然后取逆序（根-左-右）对称后（根-右-左）逆序后为（左-右-根）
     */
    private static List< Integer > afterInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current!=null || !treeNodeStack.empty()){
            while (current!=null){
                result.add(current.getVal());
                treeNodeStack.push(current.getLeft());
                current = current.getRight();
            }
            current = treeNodeStack.pop();
        }
        //逆序返回
        Collections.reverse(result);
        return result;
    }

}
