package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Printer {

    public void printWinningMessage(final String correctWord) {
        System.out.println("You have won the game. The word was "+correctWord);

    }

    public void printWordToGuess(final String word) {
        System.out.println("Guess this word: " + word);

    }

    public void printFailureMessage(final String word,final int remaining) {
        System.out.println("Incorrect 1 life lost,"+ remaining+ " remaining. "+"The Current Word is " + word);

    }

    public void printRetryMessage(final String word) {
        System.out.println("Correct. " + word);

    }

    public void printAlreadyTried() {
        System.out.println("You have already tried this letter");

    }
}
