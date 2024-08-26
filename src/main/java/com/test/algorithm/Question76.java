package com.test.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * s = "ADOBECODEBANC", t = "ABC"
 * 返回"BANC"，注意没有顺序要求，t中的字符可以重复
 */

public class Question76 {

    // 当前窗口内的计数
    Map<Character, Integer> curCount = new HashMap<>();
    // t字符串的字符统计
    Map<Character, Integer> tTotal = new HashMap<>();

    /**
     * 滑动窗口解法
     * @param s 字符串s
     * @param t 字符串t
     * @return 最小子串
     */
    public String minWindow2(String s, String t) {
        // t统计
        for (int i = 0; i < t.length(); i++) {
            tTotal.put(t.charAt(i), tTotal.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = -1;
        int maxLen = Integer.MAX_VALUE;
        int targetLeft = -1;
        int targetRight = -1;
        int length  = s.length();
        while (right < length) {
            right++;
            // 当前遍历窗口的计数
            if (right < length && tTotal.containsKey(s.charAt(right))) {
                curCount.put(s.charAt(right), curCount.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (checkWindow() && left <= right) {
                if (right - left + 1 < maxLen) {
                    // 满足条件并且小于最小窗口
                    maxLen = right - left + 1;
                    targetLeft = left;
                    targetRight = right;
                }
                if (tTotal.containsKey(s.charAt(left))) {
                    curCount.put(s.charAt(left), curCount.get(s.charAt(left)) - 1);
                }
                left ++;
            }
        }
        return targetLeft == -1 ? "" : s.substring(targetLeft, targetRight + 1);
    }

    private boolean checkWindow() {
        for (Character key : tTotal.keySet()) {
            if (curCount.getOrDefault(key, 0) < tTotal.get(key)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力解法，全部匹配遍历
     * @param s 字符串s
     * @param t 字符串t
     * @return 最小子串
     */
    public String minWindow(String s, String t) {
        // 思路:可以通过计数的方式来判断是否存在对应的子串
        // 存在时需要最短子串
        if (isContains(s, t)) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j <= s.length(); j++) {
                    if (isContains(s.substring(i, j), t)) {
                        if (result.equals("") || j-i < result.length()) {
                            result = s.substring(i, j);
                        }
                        break;
                    }
                }
            }
            return result;
        }
        return "";
    }

    /**
     * 判断是否满足子串条件
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否存在子串包含t所有字符
     */
    private boolean isContains(String s, String t) {
        if (s.length() < t.length()) {
            return false;
        }
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Character key : tCount.keySet()) {
            if (sCount.getOrDefault(key, 0) < tCount.get(key)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Question76 question76 = new Question76();
        System.out.println(question76.minWindow2("ab", "b"));
    }
}
