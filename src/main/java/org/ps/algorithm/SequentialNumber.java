package org.ps.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialNumber {
    public List<Integer> sequentialDigits(int low, int high) {
//        List<Integer> sequentialNumbers = new ArrayList<>();
//
//        for (int i = 1; i <= 9; i++) {
//            generateSequentialNumbers(i, low, high, sequentialNumbers);
//        }
//
//        Collections.sort(sequentialNumbers);
//        return sequentialNumbers;

        List<Integer> sequentialNumbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int num = i;
            while (num <= high) {
                if (num >= low) {
                    sequentialNumbers.add(num);
                }
                int lastDigit = num % 10;
                if (lastDigit < 9) {
                    num = num * 10 + lastDigit + 1;
                } else {
                    break; // No need to continue if last digit is 9
                }
            }
        }

        Collections.sort(sequentialNumbers);
        return sequentialNumbers;
    }

    public void generateSequentialNumbers(int num, int low, int high, List<Integer> result) {
        if (num >= low && num <= high) {
            result.add(num);
        }

        int lastDigit = num % 10;
        if (lastDigit < 9) {
            int nextNum = num * 10 + lastDigit + 1;
            if (nextNum <= high) {
                generateSequentialNumbers(nextNum, low, high, result);
            }
        }
    }


}
