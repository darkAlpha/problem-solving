package org.ps.algorithm;

public class MaxProductSubarray {

    /**
     *
     * The Brute force method says we can simply apply 2 loops for calculaing all sub-arrays and finding the max product.
     *
     * But, the Optizimed way to solve this problem is using Kadane's Algorithm.
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int supmax = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = Math.max( Math.max(nums[i], nums[i] * max), nums[i] * min);

            min = Math.min( Math.min(nums[i], nums[i] * max), nums[i] * min);

            max = temp;

            supmax = Math.max(supmax, max);

        }
        return supmax;
    }
}
