package tudelft.caesarshift;

public class CaesarShiftCipher {
    /*Баг - имя метода выбрано как для конструктора - меняю*/
//    public String CaesarShiftCipher(String message, int shift){
    public String cipher(String message, int shift) {
        /*Баг - не обрабатывалась null-строка*/
        if (message == null) {
            return "invalid";
        }
        /*Баг - не обрабатывалась пустая строка*/
        if ("".equals(message)) {
            return "invalid";
        }
        StringBuilder sb = new StringBuilder();
        char currentChar;
        int length = message.length();

        shift = shift % 26;

        for (int i = 0; i < length; i++) {
            currentChar = message.charAt(i);
            /*Баг - в выходную строку не должен добавляться исходный несмещенный символ*/
//            sb.append(currentChar);
            /*Баг - не учтена обработка пробела, т.к. после пробела все символы печатные, можно применять и для
             * него тот же алгоритм шифрования*/
//            if (currentChar > 'z' || currentChar < 'a') {
            if ((currentChar > 'z' || currentChar < 'a') && ' ' != currentChar) {
                return "invalid";
            } else if ((char) (currentChar + shift) > 'z') {
                currentChar = (char) (currentChar - 26);
                /*Добавил условие для обработки пробела*/
            } else if ((char) (currentChar + shift) < 'a' && ' ' != currentChar) {
                currentChar = (char) (currentChar + 26);
            }
            sb.append((char) (currentChar + shift));
        }

        return sb.toString();
    }
}
