package zijie;


public class leet2两数相加 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet2两数相加().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // head 指向头结点不动，每次指定tail.next 节点 然后移动tail节点
            ListNode head = null, tail = null;
            int add = 0;
            while (l1 != null || l2 != null || add != 0) {
                // 为 null 则补充 0
                int x = l1 != null ? l1.val : 0;
                int y = l2 != null ? l2.val : 0;
                int res = x + y + add;
                if (head == null) {
                    head = tail = new ListNode(res % 10);
                } else {
                    tail.next = new ListNode(res % 10);
                    tail = tail.next;
                }
                add = res / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            // 内外进位 都可以
            /*if (add > 0) {
                tail.next = new ListNode(1);
            }*/
            return head;
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
