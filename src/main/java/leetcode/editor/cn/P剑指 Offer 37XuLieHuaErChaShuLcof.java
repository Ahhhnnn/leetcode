//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 94 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class 序列化二叉树{
    public static void main(String[] args) {
        Codec solution = new 序列化二叉树().new Codec();
        // TO TEST
        //    1
        //   / \
        //  2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = solution.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println(deserialize);
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 层次遍历 左右子树如果为null 也需要打印出来
        StringBuilder result  = new StringBuilder();
        if (root == null) return "[]";
        result.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll != null){
                result.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }else{
                result.append("null").append(",");
            }
        }
        result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] val = data.substring(1,data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!val[i].equals("null")) {
                poll.left = new TreeNode(Integer.parseInt(val[i]));
                queue.offer(poll.left);
            }
            i++;
            if(!val[i].equals("null")) {
                poll.right = new TreeNode(Integer.parseInt(val[i]));
                queue.offer(poll.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
 public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}