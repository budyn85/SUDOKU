package com.kodilla.sudoku.sample;

import com.kodilla.sudoku.board.SudokuBoard;

import java.util.Arrays;

public class Sample {
    private SudokuBoard board;

    public Sample(SudokuBoard board) {
            this.board = board;
            fillNew();
    }
    private void fillOld() {
        board.getSudokuRows().get(0).getSudokuFields().get(1).setDigit(2);
        board.getSudokuRows().get(0).getSudokuFields().get(3).setDigit(5);
        board.getSudokuRows().get(0).getSudokuFields().get(5).setDigit(1);
        board.getSudokuRows().get(0).getSudokuFields().get(7).setDigit(9);

        board.getSudokuRows().get(1).getSudokuFields().get(0).setDigit(8);
        board.getSudokuRows().get(1).getSudokuFields().get(3).setDigit(2);
        board.getSudokuRows().get(1).getSudokuFields().get(5).setDigit(3);
        board.getSudokuRows().get(1).getSudokuFields().get(8).setDigit(6);

        board.getSudokuRows().get(2).getSudokuFields().get(1).setDigit(3);
        board.getSudokuRows().get(2).getSudokuFields().get(4).setDigit(6);
        board.getSudokuRows().get(2).getSudokuFields().get(7).setDigit(7);

        board.getSudokuRows().get(3).getSudokuFields().get(2).setDigit(1);
        board.getSudokuRows().get(3).getSudokuFields().get(6).setDigit(6);

        board.getSudokuRows().get(4).getSudokuFields().get(0).setDigit(5);
        board.getSudokuRows().get(4).getSudokuFields().get(1).setDigit(4);
        board.getSudokuRows().get(4).getSudokuFields().get(7).setDigit(1);
        board.getSudokuRows().get(4).getSudokuFields().get(8).setDigit(9);

        board.getSudokuRows().get(5).getSudokuFields().get(2).setDigit(2);
        board.getSudokuRows().get(5).getSudokuFields().get(6).setDigit(7);

        board.getSudokuRows().get(6).getSudokuFields().get(1).setDigit(9);
        board.getSudokuRows().get(6).getSudokuFields().get(4).setDigit(3);
        board.getSudokuRows().get(6).getSudokuFields().get(7).setDigit(8);

        board.getSudokuRows().get(7).getSudokuFields().get(0).setDigit(2);
        board.getSudokuRows().get(7).getSudokuFields().get(3).setDigit(8);
        board.getSudokuRows().get(7).getSudokuFields().get(5).setDigit(4);
        board.getSudokuRows().get(7).getSudokuFields().get(8).setDigit(7);

        board.getSudokuRows().get(8).getSudokuFields().get(1).setDigit(1);
        board.getSudokuRows().get(8).getSudokuFields().get(3).setDigit(9);
        board.getSudokuRows().get(8).getSudokuFields().get(5).setDigit(7);
        board.getSudokuRows().get(8).getSudokuFields().get(7).setDigit(6);
    }

    private void fillNew() {
        int[][] data = {
                {2, 1, 2}, {4, 1, 5}, {6, 1, 1}, {8, 1, 9},
                {1, 2, 8}, {4, 2, 2}, {6, 2, 3}, {9, 2, 6},
                {2, 3, 3}, {5, 3, 6}, {8, 3, 7},
                {3, 4, 1}, {7, 4, 6},
                {1, 5, 5}, {2, 5, 4}, {8, 5, 1}, {9, 5, 9},
                {3, 6, 2}, {7, 6, 7},
                {2, 7, 9}, {5, 7, 3}, {8, 7, 8},
                {1, 8, 2}, {4, 8, 8}, {6, 8, 4}, {9, 8, 7},
                {2, 9, 1}, {4, 9, 9}, {6, 9, 7}, {8, 9, 6}
        };

        Arrays.stream(data)
                .forEach(field -> board.getSudokuField(field[0] - 1, field[1] -1).setDigit(field[2]));

    }
}
