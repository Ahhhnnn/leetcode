package zijie;


import java.util.ArrayList;
import java.util.List;

public class leet143重建链表 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet143重建链表().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution.reorderList(node1);
        System.out.println(node1);
    }


    /**
     * 描述：143重建链表
     */
    class Solution {
        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head =head.next;
            }
            int left =0;
            int right = list.size() - 1;
            while (left < right) {
                list.get(left).next = list.get(right);
                left ++;
                if (left == right) {
                    break;
                }
                list.get(right).next = list.get(left);
                right --;
            }
            list.get(left).next = null;
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
