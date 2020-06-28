package com.he.链表.q21合并两个有序链表;


import com.he.common.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(null);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(null);
        ListNode listNode = mergeTwoLists(listNode1, listNode4);
        while (listNode!=null){
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //哨兵节点 prehead.next 即为合并后的链表
        ListNode prehead = new ListNode(-1);

        //
        ListNode prev = prehead;
        while (l1 != null && l2 != null){
            if(l1.getVal() < l2.getVal()){
                prev.setNext(l1);
                l1 = l1.getNext();
            }else {
                prev.setNext(l2);
                l2 = l2.getNext();
            }
            prev = prev.getNext();
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.setNext(l1 == null ? l2 : l1);
        return prehead.getNext();
    }
}
