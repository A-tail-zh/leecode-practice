package com.leetcode.daily;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 每日一题专用目录
 * 
 * 每天在此包下创建对应日期的题目，命名格式：YYYYMMDD_题目序号.java
 * 例如：20260308_TwoSum.java
 */
public class DailyChallenge {
    
    /**
     * 获取今天的日期格式化字符串
     * @return 日期格式：yyyyMMdd
     */
    public static String getTodayDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return today.format(formatter);
    }
    
    // 每日一题请在此包下创建，使用日期 + 题目名称的格式
}
