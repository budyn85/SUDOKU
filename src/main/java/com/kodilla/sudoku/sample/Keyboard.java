package com.kodilla.sudoku.sample;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Keyboard {
    private Scanner scanner = new Scanner(System.in);

    public String readKeyboardEntry() {
        return scanner.nextLine().trim();
    }
}
