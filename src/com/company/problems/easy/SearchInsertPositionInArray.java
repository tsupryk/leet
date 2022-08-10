package com.company.problems.easy;

import com.company.problems.Test;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <br>
 * You must write an algorithm with O(log n) runtime complexity.<br>
 * Input: nums = [1,3,5,6], target = 5 Output: 2 <br>
 * Input: nums = [1,3,5,6], target = 2 Output: 1 <br>
 * Input: nums = [1,3,5,6], target = 7 Output: 4 <br>
 * <a href="https://leetcode.com/problems/search-insert-position">problem</a>
 */
public class SearchInsertPositionInArray {

    public static void main(String[] args) {
        var case1 = new int[]{1,3,5,6};
        int target1 = 5;

        var case2 = new int[]{1,3,5,6,7};
        int target2 = 2;

        var case3 = new int[]{1,3,5,6};
        int target3 = 7;

        var case4 = new int[]{};
        int target4 = 7;

        SearchInsertPositionInArray solution = new SearchInsertPositionInArray();

        Test.equals(solution.searchInsert(case1, target1), 2);
        Test.equals(solution.searchInsert(case2, target2), 1);
        Test.equals(solution.searchInsert(case3, target3), 4);
        Test.equals(solution.searchInsert(case4, target4), 0);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) { return 0; }
        return findIndex(nums, 0, nums.length, target);
    }

    private int findIndex(int[] nums, int start, int end, int target) {
        if (end - start == 1) {
            return target > nums[start] ? end : start;
        }
        int half = (end - start) / 2 + start;
        return target > nums[half] ? findIndex(nums, half, end, target) : findIndex(nums, start, half, target);
    }

}
