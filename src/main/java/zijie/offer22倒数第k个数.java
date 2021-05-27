package zijie;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer22倒数第k个数 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new offer22倒数第k个数().new Solution();
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode kthFromEnd = solution.getKthFromEnd(head, 2);
        System.out.println(kthFromEnd);
    }


    /**
     * 获取倒数第k个数
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            // 遍历一次拿到长度，然后再走 length - K 步
            /*int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length ++;
                temp = temp.next;
            }
            int times = length - k;
            for (int i = 0; i < times; i++) {
                head = head.next;
            }
            return head;*/

            // 双指针法
            // 快指针先走k步，当快指针走到null时，因为快指针 领先 满指针k步，所以此时满指针正好在尾部倒数第k个节点
            ListNode fast = head, slow = head;
            int t = 0;
            while (fast != null) {
                if (t >= k) {
                    slow = slow.next;
                }
                fast = fast.next;
                t ++;
            }
            return slow;
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
