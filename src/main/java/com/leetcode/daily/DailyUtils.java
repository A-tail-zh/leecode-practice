package com.leetcode.daily;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 每日一题工具类
 * 
 * 提供日期相关的辅助方法，帮助生成正确的目录和文件名
 */
public class DailyUtils {
    
    /**
     * 获取当前年月（用于创建目录）
     * @return 格式：yyyy-MM，例如：2026-03
     */
    public static String getCurrentYearMonth() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        return today.format(formatter);
    }
    
    /**
     * 获取今天是本月的第几天（两位数格式）
     * @return 格式：DayXX，例如：Day08
     */
    public static String getDayOfMonth() {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        return String.format("Day%02d", day);
    }
    
    /**
     * 生成完整的文件前缀（包含日期信息）
     * @param problemName 题目的驼峰命名
     * @return 完整文件名，例如：Day08_TwoSum.java
     */
    public static String generateFileName(String problemName) {
        return getDayOfMonth() + "_" + problemName + ".java";
    }
    
    /**
     * 生成完整的文件路径前缀
     * @return 相对路径，例如：daily/2026-03/
     */
    public static String getDirectoryPath() {
        return "src/main/java/com/leetcode/daily/" + getCurrentYearMonth() + "/";
    }
    
    public static void main(String[] args) {
        System.out.println("当前年月：" + getCurrentYearMonth());
        System.out.println("今天是本月第几天：" + getDayOfMonth());
        System.out.println("示例文件名：" + generateFileName("TwoSum"));
        System.out.println("完整目录路径：" + getDirectoryPath());
    }
}
