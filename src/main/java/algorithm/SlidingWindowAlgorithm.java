package algorithm;

import utils.StringUtils;

public class SlidingWindowAlgorithm implements WordReplacement {

    @Override
    public String replaceMatchingParts(final String guess, final String originalWord, final String obfuscatedWord) {
        int startIndex = 0;
        int endIndex = originalWord.length() - guess.length() + 1;
        String updatedWord = obfuscatedWord;
        for (int i = 0; i < endIndex; i++) {
            String chunk = originalWord.substring(startIndex, startIndex + guess.length());
            if (chunk.equals(guess)) {
                final var updatedObfuscatedWord =
                        StringUtils.updateOriginalWord(startIndex, startIndex + guess.length(), guess, updatedWord);
                updatedWord = updatedObfuscatedWord;
            }
            startIndex = startIndex + 1;
        }

        return updatedWord;

    }

}
