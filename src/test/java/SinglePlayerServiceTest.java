import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.SlidingWindowAlgorithm;
import dto.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import service.SinglePlayerService;

public class SinglePlayerServiceTest {

    @Test
    void userShouldWinGameWithCorrectInput() {
        Queue<String> userInput = new LinkedList<>();
        userInput.add("Him");
        userInput.add("a");
        userInput.add("n");
        userInput.add("shu");
        Input input = () -> userInput.poll();
        final var wordReplacementAlgo=new SlidingWindowAlgorithm();
        final var singlePlayer = new SinglePlayerService(wordReplacementAlgo,input, List.of("Himanshu"), 5);
        singlePlayer.startGame();
        Assertions.assertThat(singlePlayer.getObfuscatedWord()).isEqualTo("Himanshu");

    }

    @Test
    void userShouldNotWinGameWithInCorrectInput() {
        Queue<String> userInput = new LinkedList<>();
        userInput.add("Hi");
        userInput.add("a");
        userInput.add("n");
        userInput.add("shu");
        userInput.add("zz");
        Input input = () -> userInput.poll();
        final var wordReplacementAlgo=new SlidingWindowAlgorithm();
        final var singlePlayer = new SinglePlayerService(wordReplacementAlgo,input, List.of("Himanshu"), 5);
        singlePlayer.startGame();
        Assertions.assertThat(singlePlayer.getObfuscatedWord()).isEqualTo("Hi*anshu");

    }
}
