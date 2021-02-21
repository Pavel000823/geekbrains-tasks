package javaCore2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mainApp {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Я");
        list.add("Я");
        list.add("Java");
        list.add("Я");
        list.add("Java");
        list.add("Я324");
        list.add("Яz");
        list.add("Java");
        list.add("JAVA");
        list.add("Привет");
        list.add("JSP");
        list.add("TEST");
        list.add("Unit");
        list.add("Comparator");
        list.add("JAVA");

        // слова
        printData(list, true);
        System.out.println("-------разделитель------");
        printData(list, false);


        // справочник
        System.out.println("-------разделитель------");
        AddressBook book = new AddressBook();
        book.addRecord("Иванов", "+79156003155");
        book.addRecord("Петров", "+791560031556");
        book.addRecord("Иванов", "+79156034155");
        book.addRecord("Сидоров", "+791563431556");
        book.addRecord("Колобаев", "+79153403155");
        book.addRecord("Фролов", "+791560551556");
        book.addRecord("Ернен", "+79156006655");
        book.addRecord("Калчанов", "+791523031556");
        book.addRecord("Петрова", "+79156453155");
        book.addRecord("Иванов", "+791569031556");

        book.findPhoneNumber("Cоловьев");
        book.findPhoneNumber("Иванов");
        book.findPhoneNumber("Ернен");
    }

    public static void printData(List<String> list, boolean unique) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : list) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (String key : map.keySet()) {
            if (unique) {
                if (map.get(key) == 1) {
                    System.out.println("Уникальные слова : " + key);
                }
            } else {
                System.out.println("слова " + key + " : " + map.get(key));
            }
        }
    }
}

