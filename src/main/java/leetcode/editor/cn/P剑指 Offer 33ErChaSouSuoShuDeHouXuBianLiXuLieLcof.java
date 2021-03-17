//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 214 👎 0


package leetcode.editor.cn;
class 二叉搜索树的后序遍历序列{
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树的后序遍历序列().new Solution();
        // TO TEST
        int postorder[] = {1,6,3,2,5};
        boolean b = solution.verifyPostorder(postorder);
        System.out.println(b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return reduer(postorder, 0 ,postorder.length - 1);
    }
    public boolean reduer(int[] postorder, int i, int j){
        if(i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        // 刚好大于根节点的值的下标，[i,mid - 1] 都是左子树，[mid,j-1] 都是右子树
        int mid = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && reduer(postorder,i,mid-1) && reduer(postorder,mid,j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}