package zijie;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet23合并k个链表 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet23合并k个链表().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;
        ListNode[] listNodes = new ListNode[]{node1, node4, node7};
        ListNode node = solution.mergeKLists(listNodes);
        System.out.println(node);

    }


    /**
     * 23. 合并k个链表
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            //return getListNode(lists);
            return null;
        }

        /**
         * 自己想的暴力破解
         * @param lists 链表数组
         * @return 合并和
         */
        private ListNode getListNode(ListNode[] lists) {
            List<Integer> nums = new ArrayList<>();
            for (ListNode list : lists) {
                while (list != null) {
                    nums.add(list.val);
                    list = list.next;
                }
            }
            Collections.sort(nums);
            ListNode result = new ListNode(0);
            ListNode head = null;
            for (int i = 0; i < nums.size(); i++) {
                if (i == 0) {
                    head = new ListNode(nums.get(i));
                    result.next = head;
                } else {
                    head.next = new ListNode(nums.get(i));
                    head = head.next;
                }
            }
            return result.next;
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
