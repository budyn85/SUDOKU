package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.processor.RangeLimiter;
import com.kodilla.sudoku.solver.SudokuData;

import java.util.stream.IntStream;

public class SudokuComplete {

    public void setFieldDigit(SudokuBoard sudokuBoard, SudokuData dataDto) {
        if (isDigitUsedInRow(sudokuBoard, dataDto)) {
            System.out.println("Digit: " + dataDto.getValue() + " is used in row " + dataDto.getAxisX());
            System.out.println("Please use different one!!\n");
        } else if (isDigitUsedInColumn(sudokuBoard, dataDto)) {
            System.out.println("Digit: " + dataDto.getValue() + " is used in column " + dataDto.getAxisY());
            System.out.println("Please use different one!!\n");
        } else if (isDigitUsedInLocalSquare(sudokuBoard, dataDto)) {
            System.out.println("Digit: " + dataDto.getValue() + " is used in local square");
            System.out.println("Please use different one!!\n");
        } else {
            sudokuBoard.getSudokuField(dataDto.getAxisX() - 1, dataDto.getAxisY() - 1).setDigit(dataDto.getValue());
            //sudokuBoard.getSudokuRows().get(dataDto.getAxisY() - 1).getSudokuFields().get(dataDto.getAxisX() - 1).getAllowedDigits().stream();
        }
    }

    private boolean isDigitUsedInRow(SudokuBoard sudokuBoard, SudokuData sudokuData) {
        int axisX = sudokuData.getAxisX() - 1;
        int axisY = sudokuData.getAxisY() - 1;
        int value = sudokuData.getValue();

        return IntStream.range(0, SudokuBoard.SUDOKU_AXIS_LENGTH)
                .filter(x -> x != axisX)
                .anyMatch(x -> sudokuBoard.getSudokuField(x, axisY).getDigit() == value);
    }

    private boolean isDigitUsedInColumn(SudokuBoard sudokuBoard, SudokuData sudokuData) {
        int axisX = sudokuData.getAxisX() - 1;
        int axisY = sudokuData.getAxisY() - 1;
        int value = sudokuData.getValue();

        return IntStream.range(0, SudokuBoard.SUDOKU_AXIS_LENGTH)
                .filter(y -> y != axisY)
                .anyMatch(y -> sudokuBoard.getSudokuField(axisX, y).getDigit() == value);
    }

    private boolean isDigitUsedInLocalSquare(SudokuBoard sudokuBoard, SudokuData sudokuDataDto) {
        int axisX = sudokuDataDto.getAxisX() - 1;
        int axisY = sudokuDataDto.getAxisY() - 1;
        int value = sudokuDataDto.getValue();

        int initX = RangeLimiter.findInit(axisX);
        int limitX = RangeLimiter.findLimit(axisX);
        int initY = RangeLimiter.findInit(axisY);
        int limitY = RangeLimiter.findLimit(axisX);

        for (int y = initY; y < limitY; y++) {
            for (int x = initX; x < limitX; x++) {
                if (x != axisX && y != axisY) {
                    if (sudokuBoard.getSudokuField(x, y).getDigit() == value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
