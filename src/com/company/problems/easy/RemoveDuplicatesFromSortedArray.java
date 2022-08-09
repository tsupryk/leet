package com.company.problems.easy;

import com.company.problems.Test;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <br>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <br>
 * Return k after placing the final result in the first k slots of nums.
 * <br>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <br>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * <br>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * <br>
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">problem</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        int[] array1 = {1,1,2};
        int[] array1Expected = {1,2};
        verifyResult(array1, solution.removeDuplicates(array1), array1Expected);

        int[] array2 = {0,0,1,1,1,2,2,3,3,4};
        int[] array2Expected = {0,1,2,3,4};
        verifyResult(array2, solution.removeDuplicates(array2), array2Expected);
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    private static void verifyResult(int[] result, int resultCount, int[] expectedNums) {
        Test.equals(resultCount, expectedNums.length);
        for (int i = 0; i < resultCount; i++) {
            Test.equals(result[i], expectedNums[i]);
        }
    }
}
