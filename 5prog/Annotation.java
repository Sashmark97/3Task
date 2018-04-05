/*
    5. Дан класс и метод помеченный аннотацией
    @Argument(value=<целое число>) (аннотацию необходимо создать). 
    Необходимо вывести таблицу умножения от 1 до числа из аннотации @Argument.
*/

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Argument {                                    //Объявляем аннотацию
    int value();
}
 
class Annotation {
 
    @Argument(value = 10)                                 //Пометим метод аннотацией
    public static void ann() {
	Annotation an = new Annotation();

	try {
	    Class<?> c = an.getClass();                      //Получим класс 
	    Method m = c.getMethod("ann");
        Argument arg = m.getAnnotation(Argument.class);  //Получим аннотацию класса
        for(int i = 1; i <= arg.value(); i++ ){
            for(int j = 1; j <= arg.value(); j++ ){
                System.out.printf("%4d", (i * j));       //Вывод таблицы
            }
            System.out.format("\n");
        }
	    
  	} catch (NoSuchMethodException exc) {
	    System.out.println("");                          //Обработка возможного исключения
	}
    }
 
    public static void main(String args[]) {
	ann();
    }
}