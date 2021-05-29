package zijie;


import java.util.*;

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
            // 优先级队列
            //return getNodeByPriorityQueue(lists);

            // 合并两个链表，两两合并
            ListNode ans = null;
            for (ListNode list : lists) {
                ans = mergeTwoLists(ans, list);
            }
            return ans;
        }

        /**
         * 合并两个链表
         * @param a 链表a
         * @param b 链表b
         * @return 合并后
         */
        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a == null ? b : a;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aptr =a, bptr = b;
            while (aptr != null && bptr!= null) {
                if (aptr.val < bptr.val) {
                    tail.next = aptr;
                    aptr = aptr.next;
                } else {
                    tail.next = bptr;
                    bptr = bptr.next;
                }
                tail = tail.next;
            }
            // 合并剩余的
            tail.next = aptr == null ? bptr : aptr;
            return head.next;
        }

        /**
         * 优先级队列
         * @param lists 链表数组
         * @return 合并后
         */
        private ListNode getNodeByPriorityQueue(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
            //PriorityQueue<ListNode> queue1 = new PriorityQueue<>((x,y) -> x.val - y.val);
            PriorityQueue<ListNode> queue1 = new PriorityQueue<>((x,y) -> {
                return x.val - y.val;
            });

            for (ListNode list : lists) {
                if (list != null) {
                    queue.offer(list);
                }
            }
            // 哨兵节点
            ListNode head = new ListNode(0);
            // 指向头结点
            ListNode tail = head;
            // 取出最小的节点
            while (!queue.isEmpty()) {
                tail.next = queue.poll();
                tail = tail.next;
                if (tail.next != null) {
                    queue.offer(tail.next);
                }
            }
            return head.next;
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
