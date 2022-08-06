package com.company.problems.easy;

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

        assert solution.isPalindrome(8);
        assert solution.isPalindrome(88);
        assert solution.isPalindrome(121);
        assert solution.isPalindrome(222);
        assert solution.isPalindrome(323);
        assert solution.isPalindrome(3223);
        assert solution.isPalindrome(1221);
        assert solution.isPalindrome(1124211);
        assert solution.isPalindrome(112211);
        assert solution.isPalindrome(123321);
        assert !solution.isPalindrome(122);
        assert !solution.isPalindrome(122111);
        assert !solution.isPalindrome(-22);
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