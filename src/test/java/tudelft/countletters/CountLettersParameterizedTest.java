package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CountLettersParameterizedTest {

    @DisplayName("Test of int count(String str) method with MC/DC parameters determined")
    @ParameterizedTest
    @CsvSource({
            "r|, 1",
            "s|, 1",
            "a|, 0",
            "r, 1"
    })
    void count(String word, int count) {
        int words = new CountLetters().count(word);
        Assertions.assertEquals(count, words);
    }
}