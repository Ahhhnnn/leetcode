package com.he.链表.q206反转链表;

import com.he.common.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(null);
        ListNode listNode = reverseList(listNode1);
        while (listNode != null){
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }

    /*
    迭代 假如当前 1->2->3->4->5 需要将指针进行反转指向前一个节点 5->4->3->2->1
     */
    private static ListNode reverseList(ListNode head) {
        //前一个节点
        ListNode prev = null;
        //当前节点
        ListNode curr = head;
        while (curr != null){
            // 保存当前节点指向的下一个接口
            ListNode temp = curr.getNext();
            // 将当前节点指向上一个节点
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
