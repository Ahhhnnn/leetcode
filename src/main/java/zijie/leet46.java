package zijie;


import java.util.ArrayList;
import java.util.List;

public class leet46 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new leet46().new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.permute(nums));
    }


    /**
     * 全排列 回溯法
     */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int length = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            if (length == 0) {
                return result;
            }
            List<Integer> path = new ArrayList<>();
            boolean[] used = new boolean[length];
            dfs(length,  0, path, used, result, nums);
            return result;
        }

        public void dfs(int length, int depth,
                        List<Integer> path, boolean[] used,
                        List<List<Integer>> result, int[] nums) {
            // 递归终止条件
            if (length == depth) {
                result.add(new ArrayList<>(path));
                return;
            }
            // 从非叶子节点中，选择一个未使用的数字
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(length, depth + 1, path, used, result, nums);
                    // 回溯
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

}
