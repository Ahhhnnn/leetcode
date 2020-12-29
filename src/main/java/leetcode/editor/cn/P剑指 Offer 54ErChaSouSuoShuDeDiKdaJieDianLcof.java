//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 104 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class 二叉搜索树的第k大节点{
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树的第k大节点().new Solution();
        // TO TEST
        // TO TEST
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        treeNode.right =  new TreeNode(4);
        System.out.println(solution.kthLargest(treeNode,2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        midleOrder(result,root);
        System.out.println(result);
        return result.get(result.size() - k);
    }

    public void midleOrder(List<Integer> list, TreeNode root){
        if(root == null) return;
        midleOrder(list,root.left);
        list.add(root.val);
        midleOrder(list,root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}