import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.print.Printer;
import com.kodilla.sudoku.processor.AdvanceProcessor;
import com.kodilla.sudoku.processor.SudokuProcessor;
import com.kodilla.sudoku.reader.SudokuEntryValidator;
import com.kodilla.sudoku.reader.SudokuReader;
import com.kodilla.sudoku.sample.DataValidator;
import com.kodilla.sudoku.sample.Keyboard;
import com.kodilla.sudoku.sample.Sample;
import com.kodilla.sudoku.solver.SudokuComplete;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SudokuEngine implements CommandLineRunner {
    private SudokuBoard board;
    private SudokuReader reader;
    private SudokuComplete filler;
    private Keyboard keyboardHandler;
    private SudokuProcessor processor;

    @Override
    public void run(String... args) {
        loadStartingData();
        enterSudokuData();
        solveBoard();
    }

    private void solveBoard() {
        boolean isBoardSolved = false;
        int iteration = 0;
        int numberOfSolvedFields = processor.getSudokuSolvedFields(board);

        while (!isBoardSolved) {
            iteration++;
            System.out.println("\nIteration number: " + iteration);

            processor.updateAvailableDigitsForFields(board);

            if (numberOfSolvedFields == processor.getSudokuSolvedFields(board)) {
                iteration += tryAdvancedMethod();
            } else {
                Printer.printBoard(board);
            }

            numberOfSolvedFields = processor.getSudokuSolvedFields(board);

            System.out.println("Number of solved fields: " + numberOfSolvedFields + " of 81");

            isBoardSolved = processor.isSudokuSolved(board);
        }

        printFinalMessage(iteration);
        Printer.printBoard(board);
    }

    private int tryAdvancedMethod() {
        System.out.println("Looking for more complex solution");

        AdvanceProcessor advancedProcessor = new AdvanceProcessor();

        board = advancedProcessor.findSolution(board, processor);

        if (board == null) {
            System.out.println("Can't find board solution :(\n\n");
            System.exit(0);
        }

        return advancedProcessor.getIterations();
    }

    private void enterSudokuData() {
        boolean areStartingDataComplete = false;
        System.out.println("Enter sudoku single field data!!!\n> ");

        while (!areStartingDataComplete) {
            areStartingDataComplete = processCollectingStartingData();
        }
    }

    private void loadStartingData() {
        new Sample(board);
        System.out.println("\n\tBoard with demo data");
        Printer.printBoard(board);
    }

    private boolean processCollectingStartingData() {
        boolean areStartingDataComplete;

        String myEntry = keyboardHandler.readKeyboardEntry();

        areStartingDataComplete = DataValidator.isReadyToFindSolution(myEntry);

        if (!areStartingDataComplete) {
            Optional.ofNullable(reader.getSingleDataFromConsole(myEntry))
                    .ifPresent(field -> {
                        filler.setFieldDigit(board, field);
                        Printer.printBoard(board);
                    });

            System.out.println("Enter sudoku single field data!!!\n> ");
        }

        return areStartingDataComplete;
    }

    private static void printFinalMessage(int iteration) {
        System.out.println("\n\n*************************************");
        System.out.println("*************************************");
        System.out.println("*************************************\n");

        System.out.println("Board solved in " + iteration + " iterations");
        System.out.println("Final solution below\n");
    }
}
