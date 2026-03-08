package com.leetcode.daily;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 每日一题文件生成器
 * 
 * 通过命令行交互，自动创建每日一题的 Java 文件
 * 支持中文题目名转换为驼峰命名
 */
public class DailyFileGenerator {
    
    /**
     * 将中文题目名转换为驼峰命名
     * 优先使用预定义的映射表，如果没有则尝试自动转换
     */
    public static String convertToCamelCase(String chineseName) {
        // 先尝试使用翻译器
        String translated = ProblemNameTranslator.translate(chineseName);
        if (translated != null) {
            return translated;
        }
        
        // 如果没有预定义，尝试自动转换
        StringBuilder result = new StringBuilder();
        String[] words = chineseName.split("[\\s_-]");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                // 首字母大写
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
            }
        }
        
        return result.toString();
    }
    
    /**
     * 获取当前年月目录
     */
    public static String getCurrentYearMonthDir() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        return today.format(formatter);
    }
    
    /**
     * 获取今天是本月的第几天
     */
    public static String getDayOfMonthStr() {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        return String.format("Day%02d", day);
    }
    
    /**
     * 生成完整的文件路径
     */
    public static Path generateFilePath(String problemName) {
        String yearMonth = getCurrentYearMonthDir();
        String dayStr = getDayOfMonthStr();
        String fileName = dayStr + "_" + problemName + ".java";
        
        return Paths.get("src", "main", "java", "com", "leetcode", "daily", yearMonth, fileName);
    }
    
    /**
     * 生成模板内容
     */
    public static String generateTemplateContent(String className, String chineseName) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.leetcode.daily;\n\n");
        sb.append("/**\n");
        sb.append(" * ").append(chineseName).append("\n");
        sb.append(" * \n");
        sb.append(" * 日期：").append(LocalDate.now()).append("\n");
        sb.append(" * 难度：待填写\n");
        sb.append(" * \n");
        sb.append(" * 解题思路：\n");
        sb.append(" * 1. TODO: 填写解题思路\n");
        sb.append(" * \n");
        sb.append(" * 时间复杂度：O()\n");
        sb.append(" * 空间复杂度：O()\n");
        sb.append(" */\n");
        sb.append("public class ").append(className).append(" {\n\n");
        sb.append("    /**\n");
        sb.append("     * 解题方法\n");
        sb.append("     */\n");
        sb.append("    public Object solve(Object input) {\n");
        sb.append("        // TODO: 实现解题逻辑\n");
        sb.append("        return null;\n");
        sb.append("    }\n\n");
        sb.append("    /**\n");
        sb.append("     * 测试方法\n");
        sb.append("     */\n");
        sb.append("    public static void main(String[] args) {\n");
        sb.append("        ").append(className).append(" solution = new ").append(className).append("();\n");
        sb.append("        \n");
        sb.append("        // TODO: 添加测试用例\n");
        sb.append("        System.out.println(\"测试开始\");\n");
        sb.append("    }\n");
        sb.append("}\n");
        
        return sb.toString();
    }
    
    /**
     * 创建文件
     */
    public static boolean createFile(Path filePath, String content) {
        try {
            // 确保目录存在
            Files.createDirectories(filePath.getParent());
            
            // 写入文件
            Files.write(filePath, content.getBytes("UTF-8"));
            return true;
        } catch (IOException e) {
            System.err.println("创建文件失败：" + e.getMessage());
            return false;
        }
    }
    
    /**
     * 主函数 - 交互式生成
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   LeetCode 每日一题文件生成器");
        System.out.println("========================================");
        System.out.println();
        
        // 显示当前信息
        System.out.println("📅 当前月份：" + getCurrentYearMonthDir());
        System.out.println("📝 今天是本月第：" + getDayOfMonthStr() + "天");
        System.out.println();
        
        // 获取用户输入
        System.out.print("请输入题目名称（中文或英文）：");
        String problemName = scanner.nextLine().trim();
        
        if (problemName.isEmpty()) {
            System.out.println("❌ 题目名称不能为空！");
            return;
        }
        
        // 如果是中文，尝试转换
        String finalName = problemName;
        boolean isChinese = ProblemNameTranslator.isChinese(problemName);
        
        if (isChinese) {
            System.out.println();
            System.out.println("检测到中文题目名，正在查询映射表...");
            String translated = ProblemNameTranslator.translate(problemName);
            
            if (translated != null) {
                System.out.println("✅ 找到映射：" + problemName + " -> " + translated);
                finalName = translated;
            } else {
                System.out.println("⚠️  未找到预设映射，尝试自动转换...");
                translated = convertToCamelCase(problemName);
                System.out.println("🔄 转换结果：" + translated);
                finalName = translated;
            }
            
            System.out.println();
            System.out.print("是否使用此名称？(Y/N): ");
            String confirm = scanner.nextLine().trim();
            
            if (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("YES")) {
                System.out.print("请手动输入英文名称：");
                finalName = scanner.nextLine().trim();
            }
        }
        
        // 生成文件名和路径
        String dayStr = getDayOfMonthStr();
        String fullFileName = dayStr + "_" + finalName + ".java";
        Path filePath = generateFilePath(finalName);
        
        System.out.println();
        System.out.println("📁 文件信息：");
        System.out.println("  • 完整文件名：" + fullFileName);
        System.out.println("  • 保存路径：" + filePath);
        System.out.println();
        
        // 确认创建
        System.out.print("确认创建文件？(Y/N): ");
        String confirm = scanner.nextLine().trim();
        
        if (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("YES")) {
            System.out.println("❌ 已取消创建");
            return;
        }
        
        // 生成模板内容
        String templateContent = generateTemplateContent(finalName, problemName);
        
        // 创建文件
        if (createFile(filePath, templateContent)) {
            System.out.println();
            System.out.println("✅ 文件创建成功！");
            System.out.println("📂 位置：" + filePath.toAbsolutePath());
            System.out.println();
            System.out.println("💡 接下来请：");
            System.out.println("  1. 打开文件编辑解题思路");
            System.out.println("  2. 实现解题逻辑");
            System.out.println("  3. 添加测试用例");
            System.out.println("  4. 提交到Git");
        } else {
            System.out.println();
            System.out.println("❌ 文件创建失败！");
        }
        
        scanner.close();
    }
}
