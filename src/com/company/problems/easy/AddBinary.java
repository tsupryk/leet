package com.company.problems.easy;

import com.company.problems.Test;

/**
 * Given two binary strings a and b, return their sum as a binary string.<br>
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"<br>
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"<br>
 * <a href="https://leetcode.com/problems/add-binary/">problem</a>
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        Test.equals(solution.addBinary("11", "1"), "100");
        Test.equals(solution.addBinary("1010", "1011"), "10101");
        Test.equals(solution.addBinary("1111", "1111"), "11110");
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int stack = 0;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        for (int i=aa.length-1,j=bb.length-1; i>=0||j>=0; i--,j--) {
            boolean one = (i >= 0 ? aa[i] : '0') == '1';
            boolean two = (j >= 0 ? bb[j] : '0') == '1';

            if (one && two) {
                if (stack > 0) {
                    sb.insert(0, '1');
                } else {
                    stack++;
                    sb.insert(0, '0');
                }
            } else if (!one && !two) {
                if (stack > 0) {
                    sb.insert(0, '1');
                    stack--;
                } else {
                    sb.insert(0, '0');
                }
            } else {
                sb.insert(0, stack > 0 ? '0' : '1');
            }
        }
        while (stack > 0) {
            sb.insert(0, '1');
            stack--;
        }
        return sb.toString();
    }
}
