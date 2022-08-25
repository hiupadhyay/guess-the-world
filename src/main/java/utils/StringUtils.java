package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    private final static String ASTERISK = "*";

    public String updateOriginalWord(final int startIndex,
            final int endIndex,
            final String guess,
            final String obfuscatedWord) {
        final StringBuilder st = new StringBuilder(obfuscatedWord);
        st.replace(startIndex, endIndex, guess);
        return st.toString();

    }

    public String obfuscateWord(final String wordToGuess) {
        return org.apache.commons.lang3.StringUtils.repeat(ASTERISK, wordToGuess.length());
    }

}
