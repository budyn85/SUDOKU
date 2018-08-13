package com.kodilla.sudoku.reader;

import com.kodilla.sudoku.solver.SudokuData;

public class SudokuReader {
    public SudokuData getSingleDataFromConsole(String myEntry) {

        if (SudokuEntryValidator.validateSingleDataEntry(myEntry)) {
            String[] values = myEntry.split(",");
            return new SudokuData(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
        }

        return null;//new SudokuDataDto(0,0,0);
    }
}
