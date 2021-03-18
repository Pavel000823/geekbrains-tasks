package javacore3.lesson1;

import javacore3.lesson1.fruits.Apple;
import javacore3.lesson1.fruits.Orange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {

        // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

        String[] strMass1 = {"hello", "java", "for", "true", "false", "gg"};
        MassHelper.swapArrayElements(strMass1, 0, 5);
        Arrays.stream(strMass1).collect(Collectors.toList()).forEach(elm -> System.out.print(elm + " "));


        System.out.println("");
        System.out.println("--------------------------");

        // 2.  Написать метод, который преобразует массив в ArrayList;
        String[] strMass2 = {"asd", "asd"};
        Integer[] intMass = {1, 12, 23, 23};

        List<String> list1 = ListHelper.getList(strMass2);
        List<Integer> list2 = ListHelper.getList(intMass);

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        System.out.println("");
        System.out.println("--------------------------");

//
//        3. Большая задача:
//        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.


        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 10; i++) {
            orangeBox.add(new Orange());
            appleBox.add(new Apple());
            appleBox1.add(new Apple());
        }

        System.out.println("orangeBox weight = " + orangeBox.getWeight());
        System.out.println("appleBox weight = " + appleBox.getWeight());

        System.out.println("orangeBox == appleBox weights :" + orangeBox.compare(appleBox));
        System.out.println("appleBox == appleBox1 weights :" + appleBox.compare(appleBox1));

        appleBox.transferToOtherBox(appleBox1);
        System.out.println("appleBox size = " + appleBox.size());
        System.out.println("appleBox1 size = " + appleBox1.size());
    }
}
