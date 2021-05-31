package zijie;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet199二叉树右视图 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet199二叉树右视图().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            // BFS 记录每层最后一个节点
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    if (i == size - 1) {
                        result.add(poll.val);
                    }
                }
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
