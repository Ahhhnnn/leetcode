package zijie;


import java.util.LinkedList;
import java.util.Queue;

public class leet112路径总和 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet112路径总和().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // 递归法,DFS 达到子节点，每次sum - 节点的value，判断子节点的value是否等于sum
            /*if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return targetSum == root.val;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);*/

            // 迭代法
            if (root == null) {
                return false;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> valQueue = new LinkedList<>();
            nodeQueue.offer(root);
            valQueue.offer(root.val);
            while (!nodeQueue.isEmpty()) {
                TreeNode nowNode = nodeQueue.poll();
                Integer tempValue = valQueue.poll();
                if (nowNode.left == null && nowNode.right == null) {
                    if (tempValue == targetSum) {
                        return true;
                    }
                    continue;
                }
                if (nowNode.left != null) {
                    nodeQueue.offer(nowNode.left);
                    valQueue.offer(nowNode.left.val + tempValue);
                }
                if (nowNode.right != null) {
                    nodeQueue.offer(nowNode.right);
                    valQueue.offer(nowNode.right.val + tempValue);
                }
            }
            return false;
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
