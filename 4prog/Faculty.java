/*
    4. Дан список студентов и факультеты на которых они обучаются.
       Необходимо вывести названия факультетов по алфавиту.
       Необходимо вывести топ 3 самых популярных факультетов для обучения.
       Использовать нужно Stream API.
*/

import java.util.Arrays;
import java.util.Objects;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.util.stream.Collectors;

class Faculty{
    public static void main(String[] ags) {
        List<String> faculty = new ArrayList<String>();
        int k = 0;
        int q = 0;
        int n = 0;
        Collection<People> peoples = Arrays.asList(
                new People("Alex", "DASR"),
                new People("Ivan", "DASR"),
                new People("Lisa", "DASR"),
                new People("Igor", "FOPF"),
                new People("Anna", "FOPF"),
                new People("Den", "FMBF"),
                new People("Daniil", "FMBF"),
                new People("Alan", "RT")
        );
        Collection<People> byFaculty = peoples.stream().sorted((o1,o2) -> -o2.getFac().compareTo(o1.getFac())).distinct().collect(Collectors.toList());
        for(People p : byFaculty){
            faculty.add(p.getFac());  //Список факультетов в алфавитном порядке
        }
        List<String> dfac = faculty.stream().distinct().collect(Collectors.toList()); //уберем повторяющиеся
        int count[] = new int[dfac.size()];
        System.out.format("List of faculties in alphabetic order:\n");
        for(String s : dfac){
            System.out.format("%s\n", s);
            count[k] = (int)faculty.stream().filter(s::equals).count(); //подсчитываем кол-во людей на каждом факультете
            k++;
        }
        
        System.out.format("\n");
        int pfac[] = new int[3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < dfac.size(); j++){
                if(count[pfac[i]] < count[j])
                pfac[i] = j;                    //найдем номера самых популярных
            }
            count[pfac[i]] = 0;                 //зануляем самый популярный
        }

        System.out.format("Most popular faculties:\n");
        for(String s:dfac){         //вывод самых популярных
            if(q == pfac[n]){
                System.out.format("%s\n",s);
                n++;
                if(n == 3){
                    break;
                }
            }
            q++;
        }
    }
}