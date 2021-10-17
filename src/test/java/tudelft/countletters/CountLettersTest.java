package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWordsS() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatchS() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    /*Added 3 tests for 100% branch and condition coverage*/
    @Test
    public void multipleMatchingWordsR() {
        int words = new CountLetters().count("car|door");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatchR() {
        int words = new CountLetters().count("car|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void allWordDoesNotMatch() {
        int words = new CountLetters().count("cat|dog");
        Assertions.assertEquals(0, words);
    }
}