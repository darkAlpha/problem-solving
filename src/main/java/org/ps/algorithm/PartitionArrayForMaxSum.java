package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PartitionArrayForMaxSum {

    /**
     *
     * window sliding + DP
     *
     * @param arr
     * @param k
     * @return
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            int sum = 0;
            int max = 0;

            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                sum = Math.max(sum, dp[ i - j] + max * j);
            }
            dp[i] = sum;

        }

        return dp[n];

//        int n = arr.length;
//        int[] dp = new int[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            int finalI = i;
//            int sum = Arrays.stream(arr).parallel().limit(i)
//                    .boxed()
//                    .reduce(0, Math::max);
//
//            int max = 0;
//
//            for (int j = 1; j <= k && finalI - j >= 0; j++) {
//                max = Math.max(max, arr[finalI - j]);
//                sum = Math.max(sum, dp[finalI - j] + max * j);
//            }
//            dp[i] = sum;
//        }
//
//        return dp[n];

    }

    @Test
    public void test() {

        Assert.assertEquals( 84,maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3) );

    }
    /**
     * Initialize a DP array: Initialize a DP array of length n+1 (n being the length of the input array) with all zeros.
     * This DP array will store the maximum sum achievable up to each index. The reason for having n+1 elements
     * is to conveniently handle the base case where no elements have been considered yet (i.e., dp[0] = 0).
     *
     * Iterating Through the Array: For each element in the array (from the first to the last),
     * determine the maximum sum achievable up to that point. This involves considering
     * all possible partition sizes up to k that could end at the current element.
     *
     * Considering All Partitions Up to Size k: For each element i, look back up
     * to k elements to find the partition that maximizes the sum. This step involves two sub-steps:
     *
     * Finding the maximum value in the current partition (max), which will be used to update all elements in the partition to this value.
     * Calculating the maximum sum for the current partition by adding the product of the maximum value (max) and the partition size (j) to
     * the maximum sum achievable before this partition started (dp[i-j]).
     * Updating the DP Array: Update dp[i] with the maximum sum achievable by including the current element in a partition.
     * This is done by comparing the sum calculated for each possible partition size and choosing the maximum.
     *
     * Result: After filling the DP array, the maximum sum after partitioning the array is found at dp[n], which accounts for the entire array.
     */
}
