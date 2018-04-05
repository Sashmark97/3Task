/*
    6. Дан класс. Необходимо вывести количество private, protected и public полей данного класса.
*/

import java.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Fields{
    public static void main(String[] args) {
        Class mClassObject = SomeClass.class;
        Field[] allFields = mClassObject.getDeclaredFields();
        List<Field> privateFields = new ArrayList<>();
        List<Field> publicFields = new ArrayList<>();
        List<Field> protectedFields = new ArrayList<>();
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
            if (Modifier.isPublic(field.getModifiers())) {
                publicFields.add(field);
            }
            if (Modifier.isProtected(field.getModifiers())) {
                protectedFields.add(field);
            }
        }
        System.out.format("Private: %d \nPublic: %d \nProtected: %d \n",
                         privateFields.size(), publicFields.size(), protectedFields.size());
    }
}