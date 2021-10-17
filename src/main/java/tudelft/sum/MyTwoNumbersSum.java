package tudelft.sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * TwoNumbersSum refactoring. Introduce dependency injection for operands. Replace ArrayLists on Lists
 * (for List.as() using, for example).
 */
class MyTwoNumbersSum {

    private final List<Integer> first;
    private final List<Integer> second;

    public MyTwoNumbersSum(List<Integer> first, List<Integer> second) {
        this.first = first;
        this.second = second;
    }

    public List<Integer> addTwoNumbers() {
        Collections.reverse(first);
        Collections.reverse(second);

        int complement = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            int total = firstVal + secondVal + complement;
            complement = 0;
            if (total >= 10) {
                complement = 1;
                total -= 10;
            }
            result.add(i, total);
            /*Не учитывался случай, когда результат имел больше разрядов, чем максимальный из операндов*/
            if (i == Math.max(first.size(), second.size()) - 1 && complement == 1) {
                result.add(i + 1, 1);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
