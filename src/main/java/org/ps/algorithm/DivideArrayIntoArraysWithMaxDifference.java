package org.ps.algorithm;

import org.ps.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {

        if (nums.length % 3 != 0) {
            return new int[][]{};
        }

        Arrays.sort(nums);



        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 < nums.length && (nums[i + 2] - nums[i]) <= k) {
                result.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
            } else {
                return new int[][]{};
            }

        }


        return result.stream()
                .parallel()
                .map(rowList -> rowList.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
