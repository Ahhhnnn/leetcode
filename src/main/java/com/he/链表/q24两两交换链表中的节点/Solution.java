package com.he.链表.q24两两交换链表中的节点;

import com.he.common.ListNode;

import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode = swapPairs(listNode1);
        System.out.println(listNode);
    }

    private static ListNode swapPairs(ListNode head) {
        // 迭代法，创建哑结点指向head
        ListNode dummyNode = new ListNode(0);
        dummyNode.setNext(head);
        // temp 后的两个元素进行交换
        ListNode temp = dummyNode;
        // 如果后面只有一个了那么就不进行交换，退出循环
        while (temp.getNext()!=null && temp.getNext().getNext()!=null){
            // 第一个节点
            ListNode node1 = temp.getNext();
            // 第二个节点
            ListNode node2 = temp.getNext().getNext();
            // 交换指向  1-2-3-4
            // 第一次交换后 2-1-3-4
            temp.setNext(node2);
            node1.setNext(node2.getNext());
            node2.setNext(node1);
            temp = node1;
        }
        // dummyNode始终指向head
        return dummyNode.getNext();
    }
}
