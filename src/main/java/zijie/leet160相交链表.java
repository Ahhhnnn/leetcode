package zijie;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet160相交链表 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet160相交链表().new Solution();
        ListNode headA = new ListNode(0);
        ListNode headA1 = new ListNode(9);
        ListNode headA2 = new ListNode(1);
        ListNode headA3 = new ListNode(2);
        ListNode headA4 = new ListNode(4);
        ListNode headB = new ListNode(3);
        ListNode headB1 = new ListNode(2);
        ListNode headB2 = new ListNode(4);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headB.next = headB1;
        headB1.next = headB2;
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }


    /**
     * 3. 无重复字符的最长子串
     */
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // Hash表法
            /*Set<ListNode> hashSet = new HashSet<>();

            ListNode curNode = headA;
            while (curNode != null) {
                hashSet.add(curNode);
                curNode = curNode.next;
            }
            curNode = headB;
            while (curNode != null) {
                if(hashSet.contains(curNode)){
                    return curNode;
                }
                curNode = curNode.next;
            }
            return null;*/

            // 双指针法(要点：到达当前链表的尾部后，重定向到另一条链表的头部)
            if (headA == null || headB == null) {
                return null;
            }
            // 双指针
            // ListNode 没有重写equal 和 hashcode方法，会导致结果不正确
            ListNode head1 = headA;
            ListNode head2 = headB;
            while (head1 != head2) {
                if (head1 != null) {
                    head1 = head1.next;
                } else {
                    head1 = headB;
                }

                if (head2 != null) {
                    head2 = head2.next;
                } else {
                    head2 = headA;
                }
            }
            return head1;
        }
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }

}
