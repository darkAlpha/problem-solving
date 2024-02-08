package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        long reversed = 0;
        long temp = x;


        while (temp != 0) {
            reversed = reversed * 10 + ( (int) temp % 10);
            temp /= 10;
        }

        return (reversed == x);
    }

    @Test
    public void test(){
        Assert.assertEquals(true, isPalindrome(1221));
    }
}
