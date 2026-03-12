package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//49. 字母异位词分组
//https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//
//
//示例 1:
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//解释：
//
//在 strs 中没有字符串可以通过重新排列来形成 "bat"。
//字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
//字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。

public class E49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null) return new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] curChars = str.toCharArray();
                Arrays.sort(curChars);
                String key = new String(curChars);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }

            return new ArrayList<List<String>>(map.values());
        }
    }


}
