package tudelft.sum;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * MyTwoNumbersSum unit test. Use @MethodSource, producing objects for parameterized test
 */
public class MyTwoNumbersSumTest {

    @NotNull
    private static Stream<Arguments> provideExpectedLists() {
        return Stream.of(
                Arguments.of(List.of(3), List.of(6), List.of(9)),
                Arguments.of(Arrays.asList(1,2), Arrays.asList(8, 7), Arrays.asList(9, 9)),
                Arguments.of(List.of(0), Arrays.asList(1,2), Arrays.asList(1, 2)),
                Arguments.of(List.of(2), List.of(8), Arrays.asList(1, 0)),
                Arguments.of(Arrays.asList(1, 2), Arrays.asList(9, 8), Arrays.asList(1, 1, 0))
        );
    }

    @ParameterizedTest(name = "first={0}, second={1}, expResult={2}")
    @MethodSource("provideExpectedLists")
    public void checkSum(List<Integer> first, List<Integer> second, List<Integer> expected) {

        MyTwoNumbersSum instance = new MyTwoNumbersSum(first, second);
        List<Integer> result = instance.addTwoNumbers();
        Assertions.assertTrue(result.equals(expected));
    }
}
