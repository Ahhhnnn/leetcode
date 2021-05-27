package zijie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leet165比较版本号 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet165比较版本号().new Solution();
        String version1 = "1.0.1";
        String version2 = "1";
        int i = solution.compareVersion(version1, version2);
        System.out.println(i);
    }


    /**
     * 3. 无重复字符的最长子串
     */
    class Solution {
        public int compareVersion(String version1, String version2) {
            List<String> version1List = new LinkedList<>(Arrays.asList(version1.split("\\.")));
            List<String> version2List = new LinkedList<>(Arrays.asList(version2.split("\\.")));
            if (version1List.size() > version2List.size()) {
                // 补充0
                int time = Math.abs(version1List.size() - version2List.size());
                for (int i = 0; i < time; i++) {
                    version2List.add("0");
                }
            } else if (version1List.size() < version2List.size()){
                // 补充0
                int time = Math.abs(version2List.size() - version1List.size());
                for (int i = 0; i < time; i++) {
                    version1List.add("0");
                }
            }
            for (int i = 0; i < version1List.size(); i++) {
                if (Integer.parseInt(version1List.get(i)) > Integer.parseInt(version2List.get(i))) {
                    return 1;
                } else if (Integer.parseInt(version1List.get(i)) < Integer.parseInt(version2List.get(i))){
                    return  -1;
                }
            }
            return 0;

            // 双指针
            // 指向字符的第一个字符
            // 比较第一个块后，移动到下一个块
            // 思路笔记重要
        }
    }

}
