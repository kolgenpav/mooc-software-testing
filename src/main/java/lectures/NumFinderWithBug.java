package lectures;

import org.jetbrains.annotations.NotNull;

/**
 * Поиск макисмального и минимального элемента массива. Программа, содержащая баг.
 */
public class NumFinderWithBug {
    private int largest = Integer.MIN_VALUE;
    private int smallest = Integer.MAX_VALUE;

    public void find(@NotNull int[] nums) {
        for (int n : nums) {
            if (n < getSmallest()) {
                smallest = n;
            } else if (n > getLargest()) {
                largest = n;
            }
        }
    }

    public int getLargest() {
        return largest;
    }

    public int getSmallest() {
        return smallest;
    }
}
