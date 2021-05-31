package zijie;


import com.he.树.q104二叉树的最大深度.Solution;

public class leet124二叉树中的最大路径和 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet124二叉树中的最大路径和().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxSum(root);
            return max;
        }

        public int maxSum (TreeNode node) {
            if (node == null) {
                return 0;
            }
            // 获取左右子树的最大值
            int lefeMax = Math.max(maxSum(node.left), 0);
            int rightMax = Math.max(maxSum(node.right), 0);

            max = Math.max(max, node.val + lefeMax + rightMax);
            return node.val + Math.max(lefeMax, rightMax);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
