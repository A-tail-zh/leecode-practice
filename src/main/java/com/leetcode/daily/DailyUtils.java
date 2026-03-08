package com.leetcode.daily;

public class DailyUtils {

    /**
     * 将任意字符串转为大驼峰命名 (UpperCamelCase)
     */
    public static String toCamelCase(String input) {
        if (input == null || input.isEmpty()) return "Untitled";

        // 替换掉特殊字符，只保留字母数字和空格
        String cleanInput = input.replaceAll("[^a-zA-Z0-9\\s_-]", "");
        StringBuilder result = new StringBuilder();
        String[] words = cleanInput.split("[\\s_-]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
            }
        }
        return result.toString();
    }
}