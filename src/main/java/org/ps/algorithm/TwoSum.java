package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see
 */
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numIndeces = new HashMap<>(10);

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(numIndeces.containsKey(compliment)) {
                return new int[] {numIndeces.get(compliment), i};
            }
            numIndeces.put(nums[i], i);
        }

        return new int[0];
    }

    @Test
    public void test() {

        int arr[] = new int[]{2, 3, 4};
        int target = 6;

        Assert.assertArrayEquals(new int[]{0, 2}, twoSum(arr, target));


    }


}
