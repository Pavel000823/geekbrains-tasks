package javaCore2.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {

        //    2. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке.
        Integer[] arrayInt = {5, 2, 3, 5, 6, 7, 87, 9};
        SearchInterface searchInterface = (x, y) -> {
            for (int i = 0; i < y.length; i++) {
                if (y[i].intValue() == x) {
                    return i;
                }
            }
            return -1;
        };
        System.out.println(searchInterface.search(3, arrayInt));
        System.out.println(searchInterface.search(10, arrayInt));

        //    3 Напишите метод, переворачивающий строку.
        ReverseInterface reverseInterface = (str) ->
                new StringBuilder(str).reverse().toString();
        System.out.println(reverseInterface.reverse("Я изучаю java"));

        //  4. Напишите метод, который возвращает наибольшее целое число в списке.

        MaximumValueInterface maximumValueInterface = (array) ->
                Arrays.stream(array).mapToInt((x) -> x).summaryStatistics().getMax();
        System.out.println(maximumValueInterface.maximum(arrayInt));

        //5. Напишите метод, который возвращает среднее значение из списка целых чисел.

        AverageInterface averageInterface = (list) ->
                list.stream().mapToInt((x) -> x).summaryStatistics().getAverage();
        System.out.println(averageInterface.average(Arrays.asList(arrayInt)));



        //6. Имея список строк, напишите метод, который возвращает список всех строк, которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.

        List<String> listWords = new ArrayList<>();
        listWords.add("ananas");
        listWords.add("Я");
        listWords.add("apre");
        listWords.add("Java");
        listWords.add("ata");
        listWords.add("Ata");
        listWords.add("Java");
        listWords.add("acr");

        SearchStrInterface searchStrInterface = (list) -> list.stream().filter(elm -> elm.startsWith("a") && elm.length() == 3).collect(Collectors.toList());
        searchStrInterface.search(listWords).forEach(System.out::println);
    }

}
