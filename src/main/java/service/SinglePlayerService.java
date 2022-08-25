package service;

import java.util.List;
import java.util.Random;

import algorithm.WordReplacement;
import dto.Input;
import lombok.Data;
import lombok.Getter;
import utils.StringUtils;
import utils.Printer;

@Data
@Getter
public class SinglePlayerService implements Game {

    private String wordToGuess;
    private String obfuscatedWord;
    private final Input userInput;
    private final int totalChances;
    private final List<String> listOfWords;
    private final WordReplacement wordReplacement;

    public SinglePlayerService(final WordReplacement wordReplacement,
            final Input userInput,
            final List<String> listOfWords,
            final int totalChances) {
        this.wordReplacement = wordReplacement;
        this.userInput = userInput;
        this.listOfWords = listOfWords;
        this.totalChances = totalChances;
        setWordToGuess(pickWord());
        setObfuscatedWord(StringUtils.obfuscateWord(this.wordToGuess));
    }

    @Override
    public void startGame() {
        int chancesTaken = 0;
        Printer.printWordToGuess(this.getObfuscatedWord());
        while (chancesTaken < this.totalChances) {

            System.out.println("Enter your guess");

            final var userGuess = this.getUserInput().userGuess();
            System.out.println("user input: " + userGuess);

            if (isValidGuess(userGuess)) {
                Printer.printWinningMessage(this.wordToGuess);
                break;
            }

            if (userGuess.length() > this.wordToGuess.length() || this.wordToGuess.indexOf(userGuess) < 0) {
                Printer.printFailureMessage(getObfuscatedWord(), this.totalChances - chancesTaken + 1);
                chancesTaken++;
                continue;
            }

            if (getObfuscatedWord().contains(userGuess)) {
                Printer.printAlreadyTried();
                //not wasting chance
                continue;
            }

            final String updatedGuess =
                    wordReplacement.replaceMatchingParts(userGuess, this.wordToGuess, this.obfuscatedWord);
            setObfuscatedWord(updatedGuess);
            if (isValidGuess(updatedGuess)) {
                Printer.printWinningMessage(this.wordToGuess);
                break;
            }
            chancesTaken++;
            Printer.printRetryMessage(getObfuscatedWord());
        }

    }

    private boolean isValidGuess(final String guess) {
        return guess.equals(this.wordToGuess);
    }

    private String pickWord() {
        Random r = new Random();
        int randomItem = r.nextInt(this.listOfWords.size());
        return this.listOfWords.get(randomItem);
    }

}
