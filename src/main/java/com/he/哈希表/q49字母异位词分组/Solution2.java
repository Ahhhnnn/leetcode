package com.he.哈希表.q49字母异位词分组;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);
        char ch = 98;
        System.out.println(ch - 'a');
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        // 每个下标对应不同的字母，0 -> a 1-> b 2 -> c 用于记录每个字母出现的次数
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            // c- 'a' 代表每个字母对应的下标 a = 97 b = 98 c = 99 d = 100
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


}
