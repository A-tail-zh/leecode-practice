package com;

import com.leetcode.daily.DailyChallenge;

/**
 * LeetCode 算法练习项目
 * 
 * 项目结构说明：
 * - daily/     : 每日一题专用目录（推荐）
 * - array/     : 数组相关题目
 * - list/      : 链表相关题目
 * - tree/      : 树相关题目
 * - dynamic/   : 动态规划相关题目
 * - graph/     : 图相关题目
 * - sort/      : 排序算法相关题目
 * - search/    : 搜索算法相关题目
 * - string/    : 字符串相关题目
 * - math/      : 数学相关题目
 * 
 * 使用建议：
 * 1. 每日一题优先放在 daily 包下，命名格式：yyyyMMdd_题目名称.java
 * 2. 专项练习按类型放在对应包下
 * 3. 每个类都包含完整的解题思路和注释
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("欢迎使用 LeetCode 算法练习项目！");
        System.out.println("========================================");
        System.out.println();
        System.out.println("📁 项目已创建以下分类包：");
        System.out.println("  • daily     - 每日一题（推荐）");
        System.out.println("  • array     - 数组相关");
        System.out.println("  • list      - 链表相关");
        System.out.println("  • tree      - 树相关");
        System.out.println("  • dynamic   - 动态规划");
        System.out.println("  • graph     - 图相关");
        System.out.println("  • sort      - 排序算法");
        System.out.println("  • search    - 搜索算法");
        System.out.println("  • string    - 字符串");
        System.out.println("  • math      - 数学相关");
        System.out.println();
        System.out.println("💡 今日日期：" + DailyChallenge.getTodayDate());
        System.out.println();
        System.out.println("🚀 开始你的算法之旅吧！");
        System.out.println("========================================");
    }
}