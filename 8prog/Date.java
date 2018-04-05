/*
    8. Написать программу в консоли которой вводим две строки: дату в виде строки и формат даты.
    Если введенная дата в виде строки соответствует введенному шаблону,
    то необходимо вывести строчку "Дата <введенная дата в виде строки>
    соответствует шаблону <введенный шаблон даты>" и если не соответствует, то необходимо вывести
    строку "Ошибка. Дата <введенная дата в консоли> не соответствует шаблону <шаблон даты из консоли>".
    Использовать при решении нужно регулярные выражения.
    Использовать Calendar и LocalData и другие классы работы с датами и временем нельзя.
*/

// 09.07.1997 ^([0-9]{2}.){2}([0-9]{4})$
// 09-07-1997 ^([0-9]{2}-){2}([0-9]{4})$ 
// 09:07:1997 ^([0-9]{2}:){2}([0-9]{4})$
// 09/07/1997 ^([0-9]{2}/){2}([0-9]{4})$

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Date{
    public static boolean reCheck(String testStr, String regEx) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(testStr);                                         //Метод проверки
        return m.matches();
    }

    public static String reComp(String format) {
        String[] possible = {"-","/",".",":"};
        String regEx = new String();
        for(String s:possible){
            if(format.contains(s)){
                regEx = String.format("^([0-9]{2}%s){2}([0-9]{4})$",s);        //Метод составления регулярного выражения
            }
        }
        return regEx;
    }

    public static void main(String[] args) {
        String[] str = new String[2];
        Scanner scanner = new Scanner(System.in);
        str[0] = scanner.nextLine();
        str[1] = scanner.nextLine();
        scanner.close();

        String regEx = reComp(str[1]);
        if(reCheck(str[0], regEx)){
            System.out.format("Дата %s соответствует шаблону %s\n",str[0], str[1]);
        }
        else{
            System.out.format("Oшибка. Дата %s не соответствует шаблону %s\n",str[0], str[1]);
        }
    }
}