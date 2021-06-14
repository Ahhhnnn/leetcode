package zijie;



public class leet206反转链表 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet206反转链表().new Solution();
        ListNode head = new ListNode(1);
        ListNode noede1 = new ListNode(2);
        ListNode noede2 = new ListNode(3);
        ListNode noede3 = new ListNode(4);
        ListNode noede4 = new ListNode(5);
        head.next = noede1;
        noede1.next = noede2;
        noede2.next = noede3;
        noede3.next = noede4;

        ListNode listNode = solution.reverseList(head);
        System.out.println(listNode);
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * 206. 反转链表
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
