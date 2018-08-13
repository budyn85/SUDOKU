package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.board.SudokuBoard;
import lombok.Getter;

import java.util.Set;

@Getter
public class AdvanceProcessor {
    private int iterations;

    public SudokuBoard findSolution(SudokuBoard board, SudokuProcessor processor) {
        SudokuBoard altBoard;
        int numberOfSolvedFields;

        for (int y = 0; y < SudokuBoard.SUDOKU_AXIS_LENGTH; y++) {
            for (int x = 0; x < SudokuBoard.SUDOKU_AXIS_LENGTH; x++) {
                altBoard = board.makeCopy();

                if (processor.isNotFieldSolved(altBoard, x, y)) {
                    Set<Integer> set = altBoard.getSudokuField(x, y).getAllowedDigits();
                    for (int availableValue : set) {
                        altBoard = board.makeCopy();
                        numberOfSolvedFields = 0;

                        iterations++;

                        altBoard.getSudokuField(x, y).setDigit(availableValue);
                        processor.updateAvailableDigitsForFields(altBoard);

                        boolean isBoardSolved = false;

                        while (!isBoardSolved) {
                            processor.updateAvailableDigitsForFields(altBoard);

                            if (numberOfSolvedFields == processor.getSudokuSolvedFields(altBoard)) {
                                break;
                            }

                            numberOfSolvedFields = processor.getSudokuSolvedFields(altBoard);
                            isBoardSolved = processor.isSudokuSolved(altBoard);

                            if (numberOfSolvedFields == 81) {
                                return altBoard;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
