package com.he.二分查找.q240搜索二维矩阵II;

public class Solution2 {

    public static void main(String[] args) {
        int [][] matrix = {{1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}

        };
        //int[][] matrix = {{1,1}};
        int target = 2;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }
    // 二分查找法
    private static boolean searchMatrix(int[][] matrix, int target) {
        //遍历行
        for (int i = 0; i < matrix.length; i++) {
            int[] matrix1 = matrix[i];
            int left = 0;
            int right = matrix1.length-1;
            while (left <= right){
                // 中间点
                int midle = (left + right)/2;
                if(matrix1[midle] == target){
                    return true;
                }else if(matrix1[midle] < target){
                    left = midle +1;
                }else if(matrix1[midle] > target){
                    // 缩小搜索区间
                    right = midle -1;
                }
            }
        }
        return false;
    }
}
