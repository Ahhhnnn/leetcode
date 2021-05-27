package zijie;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet102二叉树层次遍历 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet102二叉树层次遍历().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = null;
        node1.right = null;
        node2.left = node3;
        node2.right = node4;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int time = queue.size();
                for (int i = 0; i < time; i++) {
                    TreeNode poll = queue.poll();
                    if (poll != null) {
                        level.add(poll.val);
                        queue.offer(poll.left);
                        queue.offer(poll.right);
                    }
                }
                if (level.size() > 0) {
                    result.add(level);
                }
            }
            return  result;
        }
    }



    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}
