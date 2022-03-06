package tudelft.mirror;

import org.jetbrains.annotations.NotNull;

public class Mirror {

    public String mirrorEnds(@NotNull String string) {
        String mirror = "";

        int begin = 0;
        int end = string.length() - 1;
        for (; begin < end; begin++, end--) {
            if (string.charAt(begin) == string.charAt(end)) {
                mirror += String.valueOf(string.charAt(end));
            }
            else {
                break;
            }
        }
         /*The BUG founded for odd (нечетной) string length and non-mirror strings*/
//        return begin == end ? string : mirror;
        return mirror.isEmpty() ? string : mirror;
    }
}
