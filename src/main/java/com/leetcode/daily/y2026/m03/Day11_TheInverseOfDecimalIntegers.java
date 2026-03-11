package com.leetcode.daily.y2026.m03;

/**
 * 题目: 十进制整数的反码
 * 日期: 2026-03-11
 * 难度: TBD
 */
public class Day11_TheInverseOfDecimalIntegers {

    public int bitwiseComplement(int n) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (n >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return n ^ mask;
    }

    public static void main(String[] args) {
        Day11_TheInverseOfDecimalIntegers solution = new Day11_TheInverseOfDecimalIntegers();
        System.out.println("测试开始...");
        System.out.println(solution.bitwiseComplement(5));
    }
}
