package com.he.链表.q141环形链表;

import com.he.common.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        //listNode4.setNext(listNode2);
        boolean b = hasCycle(listNode1);
        System.out.println(b);
    }

    // 快慢指针
    private static boolean hasCycle(ListNode head) {
        ListNode slow =head,fast = head;
        while (slow!=null && fast !=null && fast.getNext()!=null){
            // 慢指针 每次走一步
            slow = slow.getNext();
            // 快指针 走两步
            fast = fast.getNext().getNext();
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
