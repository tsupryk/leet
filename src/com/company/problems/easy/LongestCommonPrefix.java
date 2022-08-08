package com.company.problems.easy;

import com.company.problems.Test;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "". <br>
 * Example 1: <br>
 * Input: strs = ["flower","flow","flight"] Output: "fl"
 * <a href="https://leetcode.com/problems/longest-common-prefix/">problem</a>
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        Test.equals(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl");
        Test.equals(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}), "");
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (allMatch(strs, index)) {
            sb.append(strs[0].charAt(index++));
        }
        return sb.toString();
    }

    private boolean allMatch(String[] strs, int index) {
        if (index >= strs[0].length()) {
            return false;
        }
        char currChar = strs[0].charAt(index);
        for (String str : strs) {
            if (index >= str.length() || str.charAt(index) != currChar) {
                return false;
            }
        }
        return true;
    }
}
