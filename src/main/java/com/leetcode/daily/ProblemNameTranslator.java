package com.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 中文题目名到英文的映射工具
 * 
 * 包含常见 LeetCode 题目的中英文对照
 */
public class ProblemNameTranslator {
    
    private static final Map<String, String> CHINESE_TO_ENGLISH = new HashMap<>();
    
    static {
        // 数组相关
        put("两数之和", "TwoSum");
        put("三数之和", "ThreeSum");
        put("四数之和", "FourSum");
        put("盛最多水的容器", "ContainerWithMostWater");
        put("接雨水", "TrappingRainWater");
        put("合并两个有序数组", "MergeSortedArray");
        put("删除排序数组中的重复项", "RemoveDuplicatesFromSortedArray");
        put("移动零", "MoveZeroes");
        put("移除元素", "RemoveElement");
        put("寻找两个正序数组的中位数", "MedianOfTwoSortedArrays");
        
        // 链表相关
        put("反转链表", "ReverseLinkedList");
        put("合并两个有序链表", "MergeTwoSortedLists");
        put("回文链表", "PalindromeLinkedList");
        put("环形链表", "LinkedListCycle");
        put("合并 K 个升序链表", "MergeKSortedLists");
        put("LRU 缓存", "LRUCache");
        
        // 树相关
        put("二叉树的最大深度", "MaximumDepthOfBinaryTree");
        put("验证二叉搜索树", "ValidateBinarySearchTree");
        put("对称二叉树", "SymmetricTree");
        put("二叉树的层序遍历", "BinaryTreeLevelOrderTraversal");
        put("将有序数组转换为二叉搜索树", "ConvertSortedArrayToBinarySearchTree");
        put("平衡二叉树", "BalancedBinaryTree");
        put("二叉树的最小深度", "MinimumDepthOfBinaryTree");
        
        // 字符串相关
        put("最长回文子串", "LongestPalindromicSubstring");
        put("无重复字符的最长子串", "LongestSubstringWithoutRepeatingCharacters");
        put("有效的括号", "ValidParentheses");
        put("最小覆盖子串", "MinimumWindowSubstring");
        put("字母异位词分组", "GroupAnagrams");
        put("最长公共前缀", "LongestCommonPrefix");
        put("字符串相乘", "MultiplyStrings");
        
        // 动态规划
        put("爬楼梯", "ClimbingStairs");
        put("打家劫舍", "HouseRobber");
        put("完全平方数", "PerfectSquares");
        put("不同路径", "UniquePaths");
        put("最长递增子序列", "LongestIncreasingSubsequence");
        put("单词拆分", "WordBreak");
        put("零钱兑换", "CoinChange");
        
        // 其他
        put("两数相加", "AddTwoNumbers");
        put("整数反转", "ReverseInteger");
        put("回文数", "PalindromeNumber");
        put("罗马数字转整数", "RomanToInteger");
        put("最长公共子序列", "LongestCommonSubsequence");
        put("编辑距离", "EditDistance");
        put("岛屿数量", "NumberOfIslands");
        put("课程表", "CourseSchedule");
    }
    
    private static void put(String chinese, String english) {
        CHINESE_TO_ENGLISH.put(chinese, english);
    }
    
    /**
     * 翻译中文题目名为英文
     * @param chineseName 中文题目名
     * @return 英文题目名，如果找不到则返回 null
     */
    public static String translate(String chineseName) {
        // 先精确匹配
        String result = CHINESE_TO_ENGLISH.get(chineseName);
        if (result != null) {
            return result;
        }
        
        // 再尝试模糊匹配（去除空格和标点）
        String cleaned = chineseName.replaceAll("[\\s\\p{Punct}]", "");
        result = CHINESE_TO_ENGLISH.get(cleaned);
        
        return result;
    }
    
    /**
     * 检查是否包含中文字符
     */
    public static boolean isChinese(String text) {
        return text.matches(".*[\\u4e00-\\u9fa5]+.*");
    }
    
    /**
     * 获取所有已知的中文题目名
     */
    public static String[] getAllChineseNames() {
        return CHINESE_TO_ENGLISH.keySet().toArray(new String[0]);
    }
    
    public static void main(String[] args) {
        // 测试
        System.out.println("已知题目数量：" + CHINESE_TO_ENGLISH.size());
        System.out.println();
        
        // 示例
        String[] testCases = {"两数之和", "反转链表", "最长回文子串", "爬楼梯"};
        for (String test : testCases) {
            String translated = translate(test);
            System.out.println(test + " -> " + translated);
        }
    }
}
