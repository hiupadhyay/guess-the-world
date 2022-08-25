import java.util.List;
import java.util.Scanner;

import algorithm.SlidingWindowAlgorithm;
import dto.Input;
import dto.UserInput;
import service.SinglePlayerService;

public class Computer {

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final Input inputDevice = new UserInput(scanner);
        final var wordReplacementAlgo=new SlidingWindowAlgorithm();
        final var game = new SinglePlayerService(wordReplacementAlgo,inputDevice, List.of(),5);
        game.startGame();


    }

}


