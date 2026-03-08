package com.leetcode.daily;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DailyFileGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== LeetCode 每日一题文件生成器 ===");

        System.out.print("请输入题目名称 (中/英): ");
        String rawInput = scanner.nextLine().trim();

        if (rawInput.isEmpty()) return;

        String translatedName;
        String chineseName = rawInput;

        // 1. 自动处理翻译与格式化
        if (ProblemNameTranslator.isChinese(rawInput)) {
            System.out.println("检测到中文，正在调用百度 API 翻译...");
            translatedName = ProblemNameTranslator.translate(rawInput);
        } else {
            translatedName = DailyUtils.toCamelCase(rawInput);
        }

        // 2. 构造包名与路径 (符合 Java Package 规范)
        LocalDate now = LocalDate.now();
        String yearPart = "y" + now.getYear();
        String monthPart = "m" + String.format("%02d", now.getMonthValue());
        String dayPrefix = String.format("Day%02d", now.getDayOfMonth());

        String packageName = "com.leetcode.daily." + yearPart + "." + monthPart;
        String className = dayPrefix + "_" + translatedName;

        // 物理路径: src/main/java/com/leetcode/daily/y2026/m03/
        Path dirPath = Paths.get("src", "main", "java", "com", "leetcode", "daily", yearPart, monthPart);
        Path filePath = dirPath.resolve(className + ".java");

        // 3. 生成并保存
        String content = generateTemplate(packageName, className, chineseName);

        System.out.println("\n拟创建文件: " + filePath);
        System.out.print("确认创建? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            try {
                Files.createDirectories(dirPath);
                Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));
                System.out.println("✅ 成功！文件已生成至: " + filePath.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("❌ 失败: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static String generateTemplate(String packageName, String className, String chineseName) {
        return String.format(
                "package %s;\n\n" +
                        "/**\n" +
                        " * 题目: %s\n" +
                        " * 日期: %s\n" +
                        " * 难度: TBD\n" +
                        " */\n" +
                        "public class %s {\n\n" +
                        "    public Object solve(Object input) {\n" +
                        "        return null;\n" +
                        "    }\n\n" +
                        "    public static void main(String[] args) {\n" +
                        "        %s solution = new %s();\n" +
                        "        System.out.println(\"测试开始...\");\n" +
                        "    }\n" +
                        "}\n",
                packageName, chineseName, LocalDate.now(), className, className, className
        );
    }
}