package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {

    @ParameterizedTest(name = "tested String={0}, expected={1}")
    @CsvSource({"aba, a", "asbcsa, as", "abc, abc", "abcd, abcd", "'',''", "a, a"})
    public void mirrorEndsTest(String testedStr, String expected){
        /*Arrange*/
        Mirror mirror = new Mirror();

        /*Act*/
        String actual = mirror.mirrorEnds(testedStr);

        /*Assertion*/
        Assertions.assertEquals(expected,actual);
    }
}
