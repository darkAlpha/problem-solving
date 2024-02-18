package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // If the window has reached its size, add the maximum element to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }

        }


        return result;
    }

    @Test
    public void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};

        int k = 8;

        int[] result = maxSlidingWindow(nums, k);

//        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, result);
        Assert.assertArrayEquals(new int[]{7}, result);

    }
}
