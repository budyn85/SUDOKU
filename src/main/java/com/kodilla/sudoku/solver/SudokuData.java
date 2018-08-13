package com.kodilla.sudoku.solver;

import lombok.Getter;

@Getter
public class SudokuData {
    private int axisX;
    private int axisY;
    private int value;

    public SudokuData(int axisX, int axisY, int value) {
        this.axisX = axisX;
        this.axisY = axisY;
        this.value = value;
    }
}
