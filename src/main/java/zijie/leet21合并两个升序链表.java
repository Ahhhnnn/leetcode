package zijie;


public class leet21合并两个升序链表 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet21合并两个升序链表().new Solution();

    }


    /**
     * 描述：合并两个升序链表
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode preHead = new ListNode(-1);
            ListNode prev = preHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                }else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 == null ? l2 : l1;
            return preHead.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
