package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.ghappy.GHappy;

/**
 * Тест реализации шифра Цезаря.
 * Use-cases:
 * 1) строка - все маленькие буквы, смещение - меньше 26
 * 2) строка - все маленькие буквы и пробел, смещение - меньше 26
 * 3) строка - все маленькие буквы и пробел, смещение 26
 * 4) строка - все маленькие буквы и пробел, смещение 0
 * 5) строка - все маленькие буквы и пробел, смещение - больше 26
 * 6) строка - присутствует большая буква
 * 7) строка - присутствует запрещенный символ
 * 8) строка - пустая
 * 9) строка - null
 */
public class CaesarShiftCipherTest {

    @ParameterizedTest(name = "Input string: {0}, Offset: {1}: Expected output string: {2}")
    @CsvSource({"abcdef, 3, defghi", "abc def, 3, def#ghi", "abc def, 26, abc def", "abc def, 0, abc def",
            "abc def, 27, bcd!efg"})
    public void checkEncryption(String input, int offset, String output) {
        Assertions.assertEquals(output, new CaesarShiftCipher().cipher(input, offset));
    }

    @ParameterizedTest(name = "Input string: {0}, Offset: {1}: Expected output string: {2}")
    @CsvSource({"abCdef, 3, invalid", "abc$def, 26, invalid", "'', 27, invalid", ", 0, invalid"})
    public void checkWrongInput(String input, int offset, String output) {
        Assertions.assertEquals(output, new CaesarShiftCipher().cipher(input, offset));
    }
}
