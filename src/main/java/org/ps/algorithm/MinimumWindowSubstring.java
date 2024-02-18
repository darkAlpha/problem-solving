package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        // Check constraints
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        // Create a map to store the frequency of characters in string t
        Map<Character, Integer> charCountMap = new HashMap<>(s.length() + 2);

        for (char c : t.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Pointers for the sliding window
        int left = 0, right = 0;

        // Minimum window length
        int minWindowLength = Integer.MAX_VALUE;

        // Start index of the minimum window
        int minWindowStart = 0;

        // Number of required characters to cover
        int requiredChars = t.length();

        // Map to track characters in the current window
        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if(charCountMap.containsKey(rightChar) && windowMap.get(rightChar) <= charCountMap.get(rightChar)) {
                requiredChars--;
            }

            while (requiredChars == 0) {

                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }


                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (charCountMap.containsKey(leftChar) && windowMap.get(leftChar) < charCountMap.get(leftChar)) {
                    requiredChars++;
                }

                left++;
            }
            right++;
        }



        if(minWindowLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minWindowStart, minWindowStart + minWindowLength);

    }

    @Test
    public void test() {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        Assert.assertEquals("BANC", minWindow(s, t));
    }
}
