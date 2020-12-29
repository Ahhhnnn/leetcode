//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 113 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 二叉树中和为某一值的路径{
    public static void main(String[] args) {
        Solution solution = new 二叉树中和为某一值的路径().new Solution();
        // TO TEST
        //      5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right= new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = solution.pathSum(root, 22);
        System.out.println(lists);
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
    LinkedList<Integer> path  = new LinkedList<>();
    LinkedList<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 前序遍历 + 回溯法
        beforeOrder(root,sum);
        return result;
    }

    public void beforeOrder(TreeNode root, int sum){
        if(root == null) return;
        sum = sum - root.val;
        path.add(root.val);
        if(sum == 0 && root.left == null && root.right == null){
            // 满足的结果直接放到result中，然后将之前的path在进行回溯
            result.add(new LinkedList<>(path));
        }
        beforeOrder(root.left,sum);
        beforeOrder(root.right,sum);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
}