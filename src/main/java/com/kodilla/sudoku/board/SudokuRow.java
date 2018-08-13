package com.kodilla.sudoku.board;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class SudokuRow {

    private List<SudokuField> sudokuFields = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            sudokuFields.add(new SudokuField());
        }
    }
}

