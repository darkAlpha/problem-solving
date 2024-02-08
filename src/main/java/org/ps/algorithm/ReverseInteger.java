package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class ReverseInteger {

    public int reverse(int x) {

        // -2147483648;
        // 2147483647;
        int minInt = -214748364 ;// Integer.MIN_VALUE;
        int maxInt = 214748364 ;// Integer.MAX_VALUE;

        int reversed = 0;
//        int sign = x >= 0 ? 1 : -1;

//        x  = Math.abs(x);

        while (x != 0) {

            int each = x % 10;

            x /= 10;

            if (reversed > maxInt) {
                return 0;
            } else if (reversed == maxInt && each > 7) {
                return 0;
            }


            if (reversed < minInt) {
                return 0;
            } else if (reversed == minInt && each < -8) {
                return 0;
            }


            reversed = reversed * 10 + each;
        }


        return reversed;


    }


    @Test
    public void test() {
        System.out.println(reverse(-2147483412));
        Assert.assertEquals(-2143847412, reverse(-2147483412));

    }
}
