package dto;

import java.util.Scanner;

public class UserInput implements Input {
    private final Scanner scanner;

    public UserInput(final Scanner scanner) {
        this.scanner = scanner;

    }
    public String userGuess() {
        return this.scanner.next();
    }
}
