package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /**
         * Посчитать время работы алгоритма С и БЕЗ префиксной функции.
         */
        long startTime = System.nanoTime();

        KMP.search("mama", "mamapapamapamapapamamaaampaammamamaaaaamamamaaaaaaaaaapammapapamamama" +
                "mamamamamamamamppppmaaaaammmmamamammapppppapapapapapmaaamamamammamamapappapapappamnmmmamamamammm");
        long searchTime = System.nanoTime() - startTime;
        System.out.println("Search Time: " + searchTime);
        startTime = System.nanoTime();
        KMP.KMPSearch("mama", "mamapapamapamapapamamaaampaammamamaaaaamamamaaaaaaaaaapammapapamamama" +
                "mamamamamamamamppppmaaaaammmmamamammapppppapapapapapmaaamamamammamamapappapapappamnmmmamamamammm");

        long searchKMPTime = System.nanoTime() - startTime;
        System.out.println("KMPSearch Time: " + searchKMPTime);
        System.out.println("Algorithm KMP is about " + Math.round(searchTime / searchKMPTime) + " times faster");
        System.out.println();


        createCamelCase("hello_world");
        createCamelCase("my_name_is");
        System.out.println();

        getAnswer(60, 30, 4);
        getAnswer(30, 30, 1);
        getAnswer(30, 150, 4);
    }

    /**
     * Написать метод который принимает на вход стрингу вида
     * helloworld или mynameis итд, т.е. использует snake case. Соответственно надо написать метод который преобразует snale case в camel case.
     * Т.е helloworld == helloWorld итд.
     */
    private static StringBuilder createCamelCase(String s) {
        char[] mas = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 95) {
                i++;
                res.append((char) (mas[i] - 32));
            } else {
                res.append((mas[i]));
            }
        }
        System.out.println(res);
        return res;
    }


    /**
     * Две группы студентов решали контрольную  состоящую из N задач. Известно что  первая группа решила суммарно A задач, а вторая В задач, при этом каждый студент решил хотя бы одну задачу.
     * Далее….
     * Вам надо узнать МОГЛО ЛИ БЫТЬ В ПЕРВОЙ ГРУППЕ СТУДЕНТОВ БОЛЬШЕ ЧЕМ ВО ВТОРОЙ.
     * <p>
     * Входные данные: Вводим три числа A B N соответственно.
     * Условия: (0<=A, B <= 10^4, 1 <= N <=10^4)
     * <p>
     * <p>
     * Выходные данные: Да- может, Нет - не может )))
     * Например: A = 60, B=30, N = 4 --> Yes
     * A = 30, B = 30, N = 1 --> No
     * A = 30, B = 150, N = 4 --> No
     * !Примеры выше реальные!
     * Можно без кода просто математикой или псевдо….не суть важно.
     */
    private static void getAnswer(int a, int b, int n) {
        if (a < b) {
            if (a > b / n) {
                System.out.println("Yes! A maybe more B");
            } else {
                System.out.println("No");
            }
        } else {
            if (a / n > b / n) {
                System.out.println("Yes! A maybe more B");
            } else {
                System.out.println("No");
            }

        }
    }
}