package tudelft.ghappy;

public class GHappy {

    public boolean gHappy(String str) {
        assert str != null;
        int gcount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                gcount++;
                /*В этом операторе баг*/
//                if (i >= 0 && str.charAt(i-1) == 'g') { continue; }
                if (i - 1 >= 0 && str.charAt(i - 1) == 'g') {
                    continue;
                }
                if (i + 1 < str.length() && str.charAt(i + 1) == 'g') {
                    continue;
                }
                return false;
            }
        }
        /*Еще один баг - если вообще нет букв g, должно возвращаться false, добавил счетчик g и его проверку*/
        return gcount > 0;
    }
}
