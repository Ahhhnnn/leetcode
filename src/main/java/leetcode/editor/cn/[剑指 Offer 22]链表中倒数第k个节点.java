//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 116 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

class LianBiaoZhongDaoShuDiKgeJieDianLcof{
     public static void main(String[] args) {  
         //测试代码  
         Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
         ListNode listNode1 = new ListNode(1);
         ListNode listNode2 = new ListNode(2);
         ListNode listNode3 = new ListNode(3);
         ListNode listNode4 = new ListNode(4);
         ListNode listNode5 = new ListNode(5);
         listNode1.next= listNode2;
         listNode2.next=listNode3;
         listNode3.next = listNode4;
         listNode4.next = listNode5;
         ListNode kthFromEnd = solution.getKthFromEnd(listNode1, 2);
         System.out.println(kthFromEnd);
     }
//力扣代码  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 顺序链表，时间复杂度O(n) 空间复杂度O(n)
        /*List<ListNode> list = new LinkedList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() - k);*/

        // 多定义一个链表 让第一个链表先走k步，之后两个链表同时走，当第一个链表为null时，说明第二个链表正好是倒数第k个
        ListNode formater = head,latter = head;
        for (int i = 0; i < k; i++) {
            formater = formater.next;
        }
        while (formater != null){
            formater = formater.next;
            latter = latter.next;
        }
        return latter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
 }
} 