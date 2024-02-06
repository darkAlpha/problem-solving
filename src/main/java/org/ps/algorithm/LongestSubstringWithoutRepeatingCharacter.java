package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> charIndexHashMap = new HashMap<>();

        int startIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(charIndexHashMap.containsKey(ch)) {
                startIndex = Math.max(startIndex , charIndexHashMap.get(ch) + 1);
            }

            charIndexHashMap.put(ch, i);
            maxLength = Math.max(maxLength, i - startIndex + 1);

        }

        return maxLength;

    }

    @Test
    public void test() {

        String s = "abcabcbb";

        int res = lengthOfLongestSubstring(s);

        Assert.assertEquals(3, res);

    }
}
