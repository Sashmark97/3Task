/*

2. Дан предикат condition и две функции ifTrue и ifFalse.
   Напишите метод ternaryOperator, который из них построит новую функцию,
   возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе. 
   Использовать нужно лямбда выражения и функциональные интерфейсы Java 8.

*/
import java.util.function.Predicate;
import java.util.function.Function;

class Ternary{
    public static Function<Integer, String> ternaryOperator(Predicate<Integer> x, Function<Integer, String> t, Function<Integer, String> f){
        if(x.test(4)){return t;}
        else{return f;}
    }

    public static void main(String[] args) {
        Predicate<Integer> condition = x -> (x % 2) != 0;
        Function<Integer, String> ifTrue = number -> String.format("ifTrue");
        Function<Integer, String> ifFalse = number -> String.format("ifFalse");
        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(1));
    }
    
}