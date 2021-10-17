package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test with Mockito mock for DAO.
 */
public class DiscountApplierTest {

    @Test
    public void testDiscount() {
        Product businessProduct = new Product("engine", 1003.0, "BUSINESS");
        Product homeProduct = new Product("TVSe", 890.0, "HOME");
        List<Product> productList = Arrays.asList(businessProduct, homeProduct);
        ProductDao dao = Mockito.mock(ProductDao.class);
        Mockito.when(dao.all()).thenReturn(productList);
        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();
        double[] expectedPrices = {1103.30, 801.00};
        double[] actualPrices = new double[expectedPrices.length];
        for (int i = 0; i < actualPrices.length; i++) {
            actualPrices[i] = productList.get(i).getPrice();
        }
        Assertions.assertArrayEquals(expectedPrices, actualPrices, 0.00001);
    }
}
