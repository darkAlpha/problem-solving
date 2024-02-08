package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class String2IntegerAtoi {

    public int myAtoi(String s) {

        int maxInt = 214748364 ;// Integer.MAX_VALUE;
        int maxIntLast = Integer.MAX_VALUE % 10;

        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int result = 0;
        int pop = 0;

        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        if (neg || pos) {
            pop++;
        }

        while(pop < s.length() && Character.isDigit(s.charAt(pop))) {

            int each = s.charAt(pop) - '0';

            if (result > maxInt) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if (result == maxInt && each > maxIntLast) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + each;
            pop++;

        }

        return  neg ? -result : result;
    }

    @Test
    public void test() {
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
        Assert.assertEquals(0, myAtoi("  "));
    }
}
