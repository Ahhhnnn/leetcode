package zijie;


import java.util.*;

public class leet103二叉树锯齿形遍历 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet103二叉树锯齿形遍历().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth =0;
            while (!queue.isEmpty()) {
                int times = queue.size();
                List<Integer> leavl = new ArrayList<>();
                for (int i = 0; i < times; i++) {
                    TreeNode temp = queue.poll();
                    leavl.add(temp.val);
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
                if (depth % 2 != 0) {
                    Collections.reverse(leavl);
                }
                result.add(leavl);
                depth ++;
            }
            return result;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    

}
