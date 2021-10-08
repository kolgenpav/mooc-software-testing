package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyRomanNumeralTestWithBeforeEach {

    private MyRomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new MyRomanNumeral();
    }

    @ParameterizedTest
    @CsvSource("'I',1, 'VIII',8, 'IV',4, 'I',1, 'XLIV',44")
    public void rightRomanNumbers(String romanNum, int expected) throws Exception {
        int result = roman.convert(romanNum);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource("'IIV'")
    public void wrongRomanNumbers(String romanNum){
        Exception assertThrows = assertThrows(Exception.class, () -> roman.convert(romanNum));
        assertEquals("Wrong Roman number!!!", assertThrows.getMessage());
    }

// @Test
// public void numberWithManyDigits() {
//     int result = roman.convert("VIII");
//     Assertions.assertEquals(8, result);
// }
//
// @Test
// public void numberWithSubtractiveNotation() {
//     int result = roman.convert("IV");
//     Assertions.assertEquals(4, result);
// }
//
// @Test
// public void numberWithAndWithoutSubtractiveNotation() {
//     int result = roman.convert("XLIV");
//     Assertions.assertEquals(44, result);
// }
//
// @Test
// public void duplicatedNumberWithSubtractiveNotation() {
//     int result = roman.convert("IIV");
//     Assertions.assertEquals(4, result);
// }
//
}
