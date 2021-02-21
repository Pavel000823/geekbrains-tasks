package javaCore2.lesson3;

import javaCore2.lesson1.attemp1.participants.Cat;
import javaCore2.lesson1.attemp1.participants.Human;

import java.util.*;

public class MainApp2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList add() " + (endTime - startTime) + "ms");

        List<Integer> linkedList = new LinkedList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList add() " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        list.remove(9000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList remove() " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.remove(9000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList remove() " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.add(80000, 9000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList add(i,e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.add(80000, 9000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList add(i,e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.get(80000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList get(i,e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.get(80000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList get(i,e) " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        list.add(80000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList add(e) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.add(80000);
        endTime = System.currentTimeMillis();
        System.out.println(" LinkedList add(e) " + (endTime - startTime) + "ms");
    }
}
