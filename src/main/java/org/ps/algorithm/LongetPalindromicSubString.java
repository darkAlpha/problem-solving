package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class LongetPalindromicSubString {

    // Manacher
    /**
     *
     * String Preprocessing:
     * Adds delimiters (#) between characters to handle odd-length palindromes.
     * Manacher's Algorithm:
     * Efficiently finds the longest palindromic substring in linear time.
     * Palindrome Radii Array:
     * Stores the radius of the longest palindrome centered at each index.
     * Key Variables:
     * center: Index of the current center of the longest palindrome.
     * radius: Radius of the current longest palindrome.
     * Main Loop:
     * Iterates through each character in the preprocessed string.
     * Uses symmetry and previous results to optimize calculations.
     * Expands palindromes as needed and updates center and radius.
     * Finding the Longest Palindrome:
     * Iterates through palindromeRadii to find the maximum radius.
     * Calculates the start and end indices of the longest palindrome.
     * Extracts the longest palindrome from the original string.
     *
     *
     * @param s string
     * @return s string
     */
    public String longestPalindrome(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for (char c: s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length();
        int[] palindromeRadii = new int[n];
        int center = 0;
        int radius = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < radius) {
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }

            while (i + 1 + palindromeRadii[i] < n &&
                    i - 1 - palindromeRadii[i] >= 0 &&
                    sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])) {
                palindromeRadii[i]++;
            }

            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        int maxLength = 0;
        int centerIndex = 0;

        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxLength) / 2;

        return s.substring(startIndex, startIndex + maxLength);
    }



    public String longestPalindromeDynamic(String s) {


        return "";
    }

    @Test
    public void test() {
        String testStr = "babad";

        Assert.assertEquals("bab", longestPalindrome(testStr));
    }

}
