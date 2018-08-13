package com.kodilla.sudoku.processor;


public class RangeLimiter {
    public static int findInit(int digit) {
        if (digit < 3) {
            return 0;
        } else if (digit < 6) {
            return 3;
        } else {
            return 6;
        }
    }

    public static int findLimit(int digit) {
        if (digit < 3) {
            return 3;
        } else if (digit < 6) {
            return 6;
        } else {
            return 9;
        }
    }
}
