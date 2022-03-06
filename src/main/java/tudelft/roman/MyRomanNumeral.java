package tudelft.roman;

import java.util.Map;

/**
 * Convert Roman number to integer. THERE ARE THE BUGS - for incorrect input like "IIV"
 *
 * @see <a href="http://graecolatini.bsu.by/htm-different/num-converter-roman.htm">...</a>
 */
public class MyRomanNumeral {
    private final static Map<Character, Integer> dict = Map.of('I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int convert(String s) throws Exception {
        if (s != null && s.length() > 0) {
            int convertNum = 0;
            for (int i = 0; i < s.length(); i++) {
                int currentNum = dict.get(s.charAt(i));
                int nextNum = (i + 1 < s.length()) ? dict.get(s.charAt(i + 1)) : 0;
                int nextNextNum = (i + 2 < s.length()) ? dict.get(s.charAt(i + 2)) : nextNum;
                if (currentNum > nextNum || (currentNum != nextNum && nextNextNum > nextNum)) {
                    convertNum += currentNum;
                }  else if (nextNum < nextNextNum && (currentNum == 1 || currentNum % 10 == 0)) {
                    convertNum -= currentNum;
                } else {
                    throw new Exception("Wrong Roman number!!!");
                }
            }
            return convertNum;
        } else {
            throw new IllegalArgumentException("String is null or empty");
        }
    }
}
