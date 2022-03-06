package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Unit test with Mockito mock for DAO. After "Tests can smell" lecture.
 * Часть подготовительной работы вынесена на уровень класса и конструктора.
 */
public class OptimizedDiscountApplierTest {

    private final List<Product> productList;
    double[] expectedPrices;
    double[] actualPrices;

    public OptimizedDiscountApplierTest() {
        productList = List.of(new Product("engine", 1003.0, "BUSINESS"),
                new Product("TVSe", 890.0, "HOME"));
        expectedPrices = new double[]{1103.30, 801.00};
        actualPrices = new double[expectedPrices.length];
    }

    @Test
    public void testDiscount() {
        /*Arrange part*/
        ProductDao dao = Mockito.mock(ProductDao.class);
        Mockito.when(dao.all()).thenReturn(productList);
        DiscountApplier applier = new DiscountApplier(dao);
        /*Act part*/
        applier.setNewPrices();
        /*Assert part*/
        for (int i = 0; i < actualPrices.length; i++) {
            actualPrices[i] = productList.get(i).getPrice();
        }
        Assertions.assertArrayEquals(expectedPrices, actualPrices, 0.00001);
    }
}
