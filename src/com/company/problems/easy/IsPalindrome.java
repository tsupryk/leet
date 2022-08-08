package com.company.problems.easy;

import com.company.problems.Test;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 * <a href="https://leetcode.com/problems/palindrome-number/">problem</a>
 */
class IsPalindrome {
    public static void main(String[] args) {

        IsPalindrome solution = new IsPalindrome();

        Test.isTrue(solution.isPalindrome(8));
        Test.isTrue(solution.isPalindrome(88));
        Test.isTrue(solution.isPalindrome(121));
        Test.isTrue(solution.isPalindrome(222));
        Test.isTrue(solution.isPalindrome(323));
        Test.isTrue(solution.isPalindrome(3223));
        Test.isTrue(solution.isPalindrome(1221));
        Test.isTrue(solution.isPalindrome(1124211));
        Test.isTrue(solution.isPalindrome(112211));
        Test.isTrue(solution.isPalindrome(123321));

        Test.isFalse(solution.isPalindrome(122));
        Test.isFalse(solution.isPalindrome(122111));
        Test.isFalse(solution.isPalindrome(-22));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int[] digits = new int[22];
        int i = 0;

        int currentX = x;
        while (currentX > 9) {
            int digit = currentX % 10;
            currentX = currentX / 10;
            digits[i++] = digit;
        }
        digits[i++] = currentX;

        boolean skippingMiddle = i % 2 != 0;

        int counter = 0;
        int half = i / 2;
        if (skippingMiddle) {
            half++;
        }
        i--;
        int[] arr = new int[half];
        while (i >= half) {
            arr[counter++] = digits[i--];
        }

        if (skippingMiddle) {
            i--;
        }

        while (i >= 0) {
            if (digits[i--] != arr[--counter]) {
                return false;
            }
        }
        return true;
    }

}