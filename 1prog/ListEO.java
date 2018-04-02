/* 
    1. Создать список целых чисел и умножить каждое четное число на 3, а нечетное на 5.
    Вывести результирующий массив в консоль.
    Использовать можно только интерфейсы Consumer и Predicate и лямбда выражения.
    ВЫВОД: Первый столбец - исходный список чисел
           Второй столбец - список после преобразования
*/

import java.util.function.Predicate;
import java.util.function.Consumer;

class ListEO{
    public static void main(String[] args) {
        Predicate<Integer> isOdd = x -> (x % 2) != 0;
        Predicate<Integer> isEven = x -> (x % 2) == 0;
        Consumer<Integer> printer = x -> System.out.format("%d ", x);

        int[] numbers = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < 6; i++) {
            numbers[i] = (int)(Math.random()*10);        // entering random numbers in array
        }
        
        for (int number:numbers) {
            printer.accept(number);                
            if(isOdd.test(number)){printer.accept(number * 5);};
            if(isEven.test(number)){printer.accept(number * 3);};
            System.out.println("");
        }
    }
}