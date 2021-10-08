package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Проверка, находятся ли две маленькие буквы "g" рядом. Use-cases:
 * 1) находятся один раз в начале слова
 * 2) находятся один раз в конце слова
 * 3) находятся более одного раза, каждый раз по две буквы
 * 4) находится три буквы подряд
 * 5) находится более одного раза, но имеется одинарное вхождение
 * 6) вначале слова находится только одна буква "g"
 * 7) в конце слова находится только одна буква "g"
 * 8) находится более одного раза по одной букве
 * 9) вообще нет букв "g"
 */
public class GHappyTest {

    @ParameterizedTest(name = "{0}: {1}")
    @CsvSource({"'g is happy!', ggxxxxx", "'g is happy!', xxxxxgg", "'g is happy!', xxggxggx",
            "'g is happy!', xxxxgggx"})
    public void ifgHappy(String message, String s) {
        Assertions.assertTrue(new GHappy().gHappy(s));
    }

    @ParameterizedTest(name = "{0}: {1}")
    @CsvSource({"'g is NOT happy!', ggxgxgg", "'g is NOT happy!', gxxxxx", "'g is NOT happy!', xxxxxg",
            "'g is NOT happy!', xxgxgx", "'g is NOT happy!', xxxxxyy"})
    public void ifgNotHappy(String message, String s) {
        Assertions.assertFalse(new GHappy().gHappy(s));
    }

}
