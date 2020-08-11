package com.he.剑指offer.q04二维数组中的查找;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix ={{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int target = 116;
        boolean numberIn2DArray = findNumberIn2DArray(matrix, target);
        System.out.println(numberIn2DArray);
    }
    // 线性查找
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix ==null || matrix.length ==0 ||matrix[0].length==0){
            return false;
        }
        int rows = matrix.length,colums = matrix[0].length;
        // 起始位置
        int row = 0,column = colums-1;
        while (row < rows && column >=0){
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] > target){
                column --;
            }else if(matrix[row][column] < target){
                row ++;
            }
        }
        return false;
    }
}
