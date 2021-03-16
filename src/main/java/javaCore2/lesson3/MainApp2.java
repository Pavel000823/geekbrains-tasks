package javaCore2.lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainApp2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList add() " + (endTime - startTime) + "ms");

        List<Integer> linkedList = new LinkedList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList add() " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        list.remove(600000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList remove() " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.remove(600000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList remove() " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.add(600000, 9000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList add(i,e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.add(600000, 9000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList add(i,e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.get(600000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList get(i,e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.get(600000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList get(i,e) " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        list.add(600000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList add(e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.add(43);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList add(e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.contains(600000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList contains(e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.contains(600000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList contains(e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.get(600000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList get(e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.get(600000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList get(e) " + (endTime - startTime) + "ms");
    }
}
