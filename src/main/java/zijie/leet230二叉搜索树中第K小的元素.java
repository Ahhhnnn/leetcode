package zijie;


import java.util.List;
import java.util.Stack;

public class leet230二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet230二叉搜索树中第K小的元素().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        node1.left = null;
        node1.right = node3;
        root.right = node2;
        node2.left = null;
        node2.right = null;
        int i = solution.kthSmallest(root, 1);
        System.out.println(i);
    }


    /**
     * 描述：230. 二叉搜索树中第K小的元素
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            // 前序遍历二叉搜索树，第k个就是最小的
            /*List<Integer> res = new ArrayList<>();
            preorder(root, res);
            return res.get(k - 1);*/

            // 迭代法 栈
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                // 取k次，就是第 k 小
                if (--k == 0) {
                    return cur.val;
                }
                cur = cur.right;
            }
            return 0;
        }
        }

        // 前序遍历
        public void preorder (TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            preorder(root.left, res);
            res.add(root.val);
            preorder(root.right, res);
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


