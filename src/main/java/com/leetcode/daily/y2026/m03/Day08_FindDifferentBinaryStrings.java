package com.leetcode.daily.y2026.m03;

import java.util.HashSet;

/**
 * 题目: 找出不同的二进制字符串
 * https://leetcode.cn/problems/find-unique-binary-string/solutions/1/go-jian-ji-xie-fa-by-endlesscheng-mcwc/?envType=daily-question&envId=2026-03-06
 * 日期: 2026-03-08
 * 难度: TBD
 */
public class Day08_FindDifferentBinaryStrings {
    //暴力枚举
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (String s:nums){
            set.add(Integer.parseInt(s,2));
        }
        int ans = 0;
        while(set.contains(ans)){
            ans++;
        }
        String bin = Integer.toBinaryString(ans);
        return "0".repeat(nums.length - bin.length()) + bin;
    }


    public static void main(String[] args) {
        Day08_FindDifferentBinaryStrings solution = new Day08_FindDifferentBinaryStrings();
        System.out.println("测试开始...");
        System.out.println(solution.findDifferentBinaryString(new String[]{"01", "10"}));
    }
}