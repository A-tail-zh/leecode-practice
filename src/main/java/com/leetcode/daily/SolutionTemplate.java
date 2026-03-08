package com.leetcode.daily;

/**
 * LeetCode 每日一题示例模板
 * 
 * 题目编号：1
 * 题目名称：两数之和
 * 难度：简单
 * 
 * 解题思路：
 * 1. 使用 HashMap 存储已遍历过的数字及其索引
 * 2. 对于每个数字，检查 target - current 是否在 map 中
 * 3. 如果存在，返回两个索引；否则将当前数字加入 map
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class SolutionTemplate {
    
    /**
     * 两数之和
     * @param nums 整数数组
     * @param target 目标和
     * @return 两个数的索引
     */
    public int[] twoSum(int[] nums, int target) {
        // TODO: 实现解题逻辑
        return new int[]{};
    }
    
    /**
     * 测试方法
     */
    public static void main(String[] args) {
        SolutionTemplate solution = new SolutionTemplate();
        
        // 测试用例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        // 预期输出：[0, 1]
        
        // 测试用例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        // 预期输出：[1, 2]
        
        System.out.println("Solution template ready for implementation");
    }
}
