package zijie;


public class leet110平衡二叉树 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet110平衡二叉树().new Solution();

    }


    /**
     * 描述：平衡二叉树
     */
    class Solution {
        // 每一棵子树都是平衡二叉树 (递归)
        // 每棵树的左右子树深度不超过1
        // 计算每棵树的深度（递归）
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
            }
        }

        public int depth(TreeNode root) {
            return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
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
