package com.he.niuke.leetcode0107;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class addTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(5);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6);
        ListNode listNode6=new ListNode(4);

        /*listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);*/

        ListNode result=addTwoNumber(listNode1,listNode4);
        System.out.println(result.getVal());
    }
    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }

    private static ListNode add(ListNode l1, ListNode l2,int z){
        //当两个链表都为null 并且 相加不进位时，直接返回null
        //如果有进位，需要指定next = 为进位的数字（1）
        if(l1==null && l2==null && z==0){
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
