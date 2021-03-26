//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 95 👎 0


package leetcode.editor.cn;
class 打印从1到最大的n位数{
    public static void main(String[] args) {
        Solution solution = new 打印从1到最大的n位数().new Solution();
        // TO TEST
        int[] ints = solution.printNumbers(3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10,n)-1;
        int[] result = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = i +1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}