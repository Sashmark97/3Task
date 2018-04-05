/*
    7.Написать программу, которая будет выводить строку
    "MAC адрес <введенный MAC адрес>: верный" если введенная в консоли строка 
    будет являться MAC адресом и "MAC адрес <введенный MAC адрес>: не верный",
    если введенная в консоли строка не будет MAC адресом.

    Пример правильных выражений:
    01:32:54:67:89:AB
    aE:dC:cA:56:76:54

    Пример неправильных выражений:
    01:33:47:65:89:ab:cd
    01:23:45:67:89:Az.

    Строку нужно считывать из консоли и задачу решить при помощи регулярного выражения.
*/
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Mac{
    public static boolean reCheck(String testStr, String regEx) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(testStr);
        return m.matches();
    }

    public static void main(String[] args) {
        String mac = new String("^([0-9A-Fa-f]{2}:){5}([0-9A-Fa-f]{2})$");
        if(reCheck(args[0], mac)){
            System.out.format("MAC адрес %s верный\n", args[0]);
        }
        else{
            System.out.format("MAC адрес %s не верный\n", args[0]);
        }
    }
}