/*
    3. Дана строка. Необходимо при помощи Stream API посчитать количество слов, 
    которые начинаются на определенную букву и длина которых меньше 5 символов. 
    И вывести в консоль в формате <слово>:<количество символов>.
*/

import java.util.Arrays;
import java.util.stream.*;

class StreamWords{
    public static void main(String[] args) {
        String init = "Many an anemone sees an enemy anemone";
        String[] str = init.split(" ");
        Stream<String> st = Arrays.stream(str);
            st.filter((s) -> (s.length()< 5)||(s.startsWith("a"))) 
              .forEach((s) -> System.out.format("%s : %d \n",s, s.length()));
    }
}