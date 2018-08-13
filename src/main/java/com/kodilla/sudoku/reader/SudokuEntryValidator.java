package com.kodilla.sudoku.reader;

public class SudokuEntryValidator {
    public static boolean validateSingleDataEntry(String data) {
        if (!checkConsoleDataLength(data)) {
            System.out.println("Wrong data format, expected \"a,b,c\" where all digits are between 1 and 9 inclusive");
            return false;
        } else if (!checkDataForAxisX(data)) {
            System.out.println("Wrong data for axis X, correct is where all digits are between 1 and 9 inclusive");
            return false;
        } else if (!checkDataForAxisY(data)) {
            System.out.println("Wrong data for axis Y, correct is where all digits are between 1 and 9 inclusive");
            return false;
        } else if (!checkDataForValue(data)) {
            System.out.println("Wrong data for field value, correct is where all digits are between 1 and 9 inclusive");
            return false;
        }

        return true;
    }

    private static boolean checkConsoleDataLength(String data) {
        return data.length() == 5 && (data.substring(1, 2).equals(",") && data.substring(3, 4).equals(","));
    }

    private static boolean checkDataForAxisX(String data) {
        int analysis = Integer.parseInt(data.substring(0, data.indexOf(",")));
        return (analysis > 0 && analysis < 10);
    }

    private static boolean checkDataForAxisY(String data) {
        int analysis = Integer.parseInt(data.substring(data.indexOf(",") + 1, data.lastIndexOf(",")));
        return (analysis > 0 && analysis < 10);
    }

    private static boolean checkDataForValue(String data) {
        int analysis = Integer.parseInt(data.substring(data.lastIndexOf(",") + 1));
        return (analysis > 0 && analysis < 10);
    }
}
