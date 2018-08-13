package com.kodilla.sudoku.board;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Component
@Getter
public class SudokuBoard {
    public final static int SUDOKU_AXIS_LENGTH = 9;

    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuRows.add(new SudokuRow());
        }
    }

    public SudokuField getSudokuField(int axisX, int axisY) {
        return sudokuRows.get(axisY).getSudokuFields().get(axisX);
    }

    public Stream<SudokuField> getSudokuFieldStream() {
        return sudokuRows.stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuFields().stream());
    }

    public SudokuBoard makeCopy() {
        SudokuBoard boardCopy = new SudokuBoard();

        for (int y = 0; y < SudokuBoard.SUDOKU_AXIS_LENGTH; y++) {
            for (int x = 0; x < SudokuBoard.SUDOKU_AXIS_LENGTH; x++) {
                Set<Integer> set = getSudokuField(x, y).getAllowedDigits();

                if (set.size() == 1) {
                    boardCopy.getSudokuField(x, y).setDigit(
                            getSudokuField(x, y).getDigit());
                } else {
                    for (int digit = 1; digit < 10; digit++) {
                        if (!set.contains(digit)) {
                            boardCopy.getSudokuField(x,y).removeAllowedDigit(digit);
                        }
                    }
                }
            }
        }

        return boardCopy;
    }
}