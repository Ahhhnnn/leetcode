package zijie;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet101对称二叉树 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet101对称二叉树().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left= node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        boolean b= solution.isSymmetric(root);
        System.out.println(b);
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
        public boolean isSymmetric(TreeNode root) {
            // 递归
            /*if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);*/

            //迭代
            return check(root, root);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
        }

        public boolean check(TreeNode left, TreeNode right) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(left);
            queue.offer(right);
            while (!queue.isEmpty()) {
                left = queue.poll();
                right = queue.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null || left.val != right.val) {
                    return false;
                }

                // 镜像入队
                queue.offer(left.left);
                queue.offer(right.right);

                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
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
