//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 87 👎 0


package leetcode.editor.cn;

import java.util.*;

class 二叉树的镜像{
    public static void main(String[] args) {
        Solution solution = new 二叉树的镜像().new Solution();
        // TO TEST
        // 4
        // / \
        // 2 7
        // / \ / \
        //1 3 6 9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = solution.mirrorTree(root);
        System.out.println(treeNode);
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
    public TreeNode mirrorTree(TreeNode root) {
        // DFS 使用栈进行深度优先遍历，交换每一个节点的左右子树即可
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(pop.left != null) stack.push(pop.left);
            if(pop.right != null) stack.push(pop.right);
            TreeNode tmp = pop.left;
            pop.left  = pop.right;
            pop.right = tmp;
        }
        return root;
    }
    // 层次遍历，条件反转输出镜像树的层次遍历，然后根据结果构建镜像树
    /*public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder vals = new StringBuilder();
        queue.offer(root);
        int leave = 0;
        while (!queue.isEmpty()) {
            List<String > list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll != null) {
                    list.add(String.valueOf(poll.val));
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }else {
                    list.add("null");
                }
            }
            if(leave != 0){
                Collections.reverse(list);
            }
            leave ++;
            for (String s : list) {
                vals.append(s).append(",");
            }
        }
        // 镜像的字符串
        vals = vals.deleteCharAt(vals.length() -1);
        System.out.println(vals);
        // 构建镜像树
        String[] arr = vals.toString().split(",");
        TreeNode result = new TreeNode(Integer.parseInt(arr[0]));
        int i =1;
        Queue<TreeNode> mirrQueue = new LinkedList<>();
        mirrQueue.offer(result);
        while (!mirrQueue.isEmpty()){
            TreeNode poll = mirrQueue.poll();
            if(!arr[i].equals("null")){
                poll.left = new TreeNode(Integer.parseInt(arr[i]));
                mirrQueue.offer(poll.left);
            }
            i++;
            if(!arr[i].equals("null")){
                poll.right = new TreeNode(Integer.parseInt(arr[i]));
                mirrQueue.offer(poll.right);
            }
            i++;
        }
        return  result;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}