package com.company.problems;

public class First {

    public static void main(String[] args) {
        System.out.println((trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) == 6) + " (" + 6 + ")");
        System.out.println((trap(new int[]{0,1,0,2,1,0,1,3,2,1,0,1}) == 6) + " (" + 6 + ")");
        System.out.println((trap(new int[]{0,1,2,2,1,0,1,3,2,1,0,1}) == 5) + " (" + 5 + ")");
        System.out.println((trap(new int[]{0,1,0,2,1,0,1,3,0,0,1,1}) == 7) + " (" + 7 + ")");
        System.out.println((trap(new int[]{5,2,1,2,1,5}) == 14) + " (" + 14 + ")");
    }

    public static int trap(int[] pool) {
        int result = 0;
        int start = 0;
        int finish = 0;
        boolean goingUp = false;
        boolean goingDown = false;
        if (pool.length < 2) {
            return 0;
        }

        int maxIndex = pool.length - 1;

        final int highestIndex = findMaxIndex(pool, 0, maxIndex);

        int leftHighestIndex = findMaxIndex(pool, 0, highestIndex - 1);
        int rightHighestIndex = findMaxIndex(pool, highestIndex + 1, maxIndex);

        int currentHighestIndex = highestIndex;

        while (true) {
            result += calculateWater(leftHighestIndex, currentHighestIndex, pool);
            if (leftHighestIndex == 0) {
                break;
            }
            currentHighestIndex = leftHighestIndex;
            leftHighestIndex = findMaxIndex(pool, 0, currentHighestIndex - 1);
        }

        currentHighestIndex = highestIndex;

        while (true) {
            result += calculateWater(currentHighestIndex, rightHighestIndex, pool);
            if (rightHighestIndex == maxIndex) {
                break;
            }
            currentHighestIndex = rightHighestIndex;
            rightHighestIndex = findMaxIndex(pool, currentHighestIndex + 1, maxIndex);
        }

        System.out.print(result + " ");
        return result;
    }

    private static int findMaxIndex(int[] pool, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return startIndex;
        }
        int maxIndex = startIndex;
        int max = pool[startIndex];
        for (int i = startIndex; i <= endIndex; i++) {
            if (pool[i] > max) {
                max = pool[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    private static int calculateWater(int start, int finish, int[] pool) {
//        System.out.println("" + start + " " + finish);
        int res = 0;
        int lowerIndex = pool[start] < pool[finish] ? start : finish;
        for (int i = start + 1; i < finish; i++) {
            int diff = pool[lowerIndex] - pool[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
