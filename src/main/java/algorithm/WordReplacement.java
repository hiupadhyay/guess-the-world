package algorithm;

/**
 * Interface to enable extension in future cases.*
 */
public interface WordReplacement {

    String replaceMatchingParts(final String originalWord, final String guessedWord, final String obfuscatedWord);
}
