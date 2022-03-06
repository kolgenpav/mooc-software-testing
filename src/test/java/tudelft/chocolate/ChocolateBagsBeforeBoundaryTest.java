package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ChocolateBagsBeforeBoundaryTest {
    /*Партиция, когда упаковок не хватает. Граница при фиксированных big=1 и total=10*
      small - между 4 и 5 или при фиксированных small=1 и big=1 total - между 6 и 7 */
    @Test
    public void totalIsBiggerThanAmountOfBars() {
        ChocolateBags bags = new ChocolateBags();
        int result = bags.calculate(4, 1, 10);
        Assertions.assertEquals(-1, result);
    }

    /*Партиция, когда используются только большие упаковки. Граница при фиксированных small=5 (на самом деле любых)
      и total=10, big - между 1 и 2*/
    @Test
    public void onlyBigBars() {
        int result = new ChocolateBags().calculate(5, 3, 10);
        Assertions.assertEquals(0, result);
    }

    /*Партиция, когда используются и большие, и малые упаковки. Граница при фиксированных big=3
      и total=17, small - между 1 и 2*/
    @Test
    public void bigAndSmallBars() {
        int result = new ChocolateBags().calculate(5, 3, 17);
        Assertions.assertEquals(2, result);
    }

    /*Партиция, когда используются только малые упаковки. Граница при фиксированных big=2 (на самом деле любых)
      и total=3, small - между 2 и 3*/
    @Test
    public void onlySmallBars() {
        int result = new ChocolateBags().calculate(4, 2, 3);
        Assertions.assertEquals(3, result);
    }

    /*Добавил для экспериментов*/
    @Disabled
    @Test
    public void trySomeTestCases() {
        ChocolateBags bags = new ChocolateBags();
        int result = bags.calculate(2, 3, 17);
        Assertions.assertEquals(2, result);
    }
}
