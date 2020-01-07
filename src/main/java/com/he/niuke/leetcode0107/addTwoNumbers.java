package com.he.niuke.leetcode0107;

public class addTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6);
        ListNode listNode6=new ListNode(4);

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);

        ListNode result=addTwoNumber(listNode1,listNode4);
        System.out.println(result);
    }
    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }

    private static ListNode add(ListNode l1, ListNode l2,int z){
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null){
            l1=new ListNode(0);
        }
        if(l2==null){
            l2=new ListNode(0);
        }
        int value = l1.val+l2.val +z;
        ListNode result = new ListNode(value%10);
        result.next=add(l1.next,l2.next,value/10);
        return result;
    }

}
