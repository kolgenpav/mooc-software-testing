package mauriciobook;

import java.util.ArrayList;
import java.util.List;

public class SpecificationBasedTesting {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * Searches a String for substrings delimited by a start and end tag,
     * returning all matching substrings in an array.
     *
     * @param str   the String containing the substrings, null returns null, empty returns empty
     * @param open  the String identifying the start of the substring, empty returns null
     * @param close the String identifying the end of the substring, empty returns null
     * @return a String Array of substrings, or {@code null} if no match
     */
    public static String[] substringsBetween(final String str, final String open, final String close) {

        /*If the preconditions do not hold, returns null right away*/
        if (str == null || open == null || close == null) {
            return null;
        }

        int strLen = str.length();
        /*If the string is empty, returns an empty array immediately*/
        if (strLen == 0) {
            return EMPTY_STRING_ARRAY;
        }

        int openLen = open.length();
        int closeLen = close.length();
        List<String> list = new ArrayList<>();
        /*A pointer that indicates the position of the string we are looking at*/
        int pos = 0;

        while (pos < (strLen - closeLen)) {
            /*Looks for the next occurrence of the open tag*/
            int start = str.indexOf(open, pos);
            /*Breaks the loop if the open tag does not appear again in the string*/
            if (start < 0) {
                break;
            }

            start += openLen;
            /*Looks for again in the string the close tag*/
            int end = str.indexOf(close, pos);
            /*Breaks the loop if the close tag does not appear again in the string*/
            if (end < 0) {
                break;
            }
            /*Gets the substring between the open and close tags*/
            list.add(str.substring(start, end));
            /*Moves the pointer to after the close tag we just found*/
            pos = end + closeLen;
        }
        /*Returns null if we do not find any substrings*/
        if (list.isEmpty()) {
            return null;
        }

        return list.toArray(EMPTY_STRING_ARRAY);
    }
}
