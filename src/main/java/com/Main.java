package com;

import java.time.LocalDate;

/**
 * LeetCode 算法练习项目主入口
 * * 项目结构说明：
 * - daily/     : 每日一题专用目录
 * 格式：daily/y2026/m03/DayXX_题目名.java
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   欢迎使用 LeetCode 算法练习项目！");
        System.out.println("========================================");
        System.out.println();
        System.out.println("📁 核心目录结构：");
        System.out.println("  • daily      - 每日一题（自动生成）");
        System.out.println("               路径规范：y年份.m月份.Day日期_题目.java");
        System.out.println("  • array/list  - 专项练习");
        System.out.println();

        // 1. 获取当前日期信息
        LocalDate now = LocalDate.now();
        String yearPart = "y" + now.getYear();
        String monthPart = "m" + String.format("%02d", now.getMonthValue());
        String dayPrefix = String.format("Day%02d", now.getDayOfMonth());

        // 2. 构造展示信息
        String packageName = "com.leetcode.daily." + yearPart + "." + monthPart;
        String folderPath = "src/main/java/com/leetcode/daily/" + yearPart + "/" + monthPart + "/";
        String exampleFile = dayPrefix + "_TwoSum.java";

        System.out.println("📅 今日状态：");
        System.out.println("  当前 Java 包名 ：" + packageName);
        System.out.println("  今日日期标识   ：" + dayPrefix);
        System.out.println("  示例文件名     ：" + exampleFile);
        System.out.println("  物理保存路径   ：" + folderPath);
        System.out.println();
        System.out.println("🚀 提示：执行 DailyFileGenerator 类即可自动创建今日模板！");
        System.out.println("========================================");
    }
}