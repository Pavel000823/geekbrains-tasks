package javacore3.lesson1;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {


    public static <T> List<T> getList(T[] mass) {
        if (mass == null) {
            throw new NullPointerException("mass is null");
        }
        List<T> list = new ArrayList<>();
        for (T t : mass) {
            list.add(t);
        }
        return list;
    }
}

