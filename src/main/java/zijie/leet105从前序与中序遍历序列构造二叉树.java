package zijie;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leet105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


    /**
     * 105. 从前序与中序遍历序列构造二叉树
     */
    static class Solution {
        Map<Integer, Integer> indexMap = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
             // 递归法
//            int length = preorder.length;
//            for (int i = 0; i < length; i++) {
//                indexMap.put(inorder[i], i);
//            }
//            return buildTreeHelper(preorder, inorder, 0, length - 1, 0, length - 1);

            // 迭代法，使用栈实现
            if (preorder.length == 0) {
                return null;
            }
            Stack<TreeNode> roots = new Stack<TreeNode>();
            int pre = 0;
            int in = 0;
            //先序遍历第一个值作为根节点
            TreeNode curRoot = new TreeNode(preorder[pre]);
            TreeNode root = curRoot;
            roots.push(curRoot);
            pre++;
            //遍历前序遍历的数组
            while (pre < preorder.length) {
                //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
                if (curRoot.val == inorder[in]) {
                    //每次进行出栈，实现倒着遍历 （相等说明是上一个节点的右孩子）
                    while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                        curRoot = roots.peek();
                        roots.pop();
                        in++;
                    }
                    //设为当前的右孩子
                    curRoot.right = new TreeNode(preorder[pre]);
                    //更新 curRoot
                    curRoot = curRoot.right;
                } else {
                    //否则的话就一直作为左子树
                    curRoot.left = new TreeNode(preorder[pre]);
                    curRoot = curRoot.left;
                }
                roots.push(curRoot);
                pre++;
            }
            return root;
        }

        public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft > preRight) {
                return null;
            }
            // 根节点下标
            // 中序遍历 根节点下标
            int inRootIndex = indexMap.get(preorder[preLeft]);
            // 左子树节点个数
            int leftSize = inRootIndex - inLeft;
            // 根节点
            TreeNode root = new TreeNode(preorder[preLeft]);
            // 传入左子树的起始 终止下标 (左开右闭区间)
            root.left = buildTreeHelper(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRootIndex - 1);
            root.right = buildTreeHelper(preorder, inorder, preLeft + 1 + leftSize, preRight, inRootIndex + 1, inRight);
            return root;
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
