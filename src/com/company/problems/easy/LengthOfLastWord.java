package com.company.problems.easy;

import com.company.problems.Test;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string. <br>
 * A word is a maximal substring consisting of non-space characters only.<br>
 * <a href="https://leetcode.com/problems/length-of-last-word/">problem</a>
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();

        Test.equals(solution.lengthOfLastWord("Hello World"), 5);
        Test.equals(solution.lengthOfLastWord("luffy is still joyboy"), 6);
        Test.equals(solution.lengthOfLastWord("   fly me   to   the moon  "), 4);
    }

    public int lengthOfLastWord(String s) {
        int lastSpaceIndex = s.lastIndexOf(' ');
        return lastSpaceIndex == s.length() - 1
                ? lengthOfLastWord(s.substring(0, lastSpaceIndex))
                : s.length() - lastSpaceIndex - 1;
    }
}
