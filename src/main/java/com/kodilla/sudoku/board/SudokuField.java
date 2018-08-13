package com.kodilla.sudoku.board;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Getter
@Configuration
public class SudokuField {

    private int digit;
    private Set<Integer> allowedDigits = new HashSet<>();

    public SudokuField() {
        for (int i = 1; i < 10; i++) {
            allowedDigits.add(i);
        }
    }

    public void setDigit(int digit) {
        if (digit >= 0 && digit <= 9) {
            this.digit = digit;
            allowedDigits.clear();
            allowedDigits.add(digit);
        }
    }

    public void removeAllowedDigit(int digit) {
        allowedDigits.remove(digit);
    }
}