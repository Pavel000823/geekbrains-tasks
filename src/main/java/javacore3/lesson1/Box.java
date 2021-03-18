package javacore3.lesson1;

import javacore3.lesson1.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> box = new ArrayList<>();

    public Box() {
    }

    public void add(T obj) {
        box.add(obj);
    }

    public float getWeight() {
        float sum = 0f;
        for (T fruit : box) {
            sum = sum + fruit.getWeight();
        }
        return sum;
    }


    public boolean compare(Box o) {
        if (o == null) {
            return false;
        }
        return o.getWeight() == getWeight();
    }

    public void transferToOtherBox(Box<T> otherBox) {
        for (T fruit : box) {
            otherBox.add(fruit);
        }
        box.clear();
    }

    public int size() {
        return box.size();
    }
}
