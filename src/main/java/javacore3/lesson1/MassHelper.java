package javacore3.lesson1;

public class MassHelper {


    public static <T> void swapArrayElements(T[] array, int firstElmIdx, int secondElmIdx) {
        if (array == null) {
            throw new NullPointerException("mass is null");
        }

        int size = array.length;
        if (firstElmIdx < 0 || secondElmIdx < 0) {
            throw new ArrayIndexOutOfBoundsException("index < 0");
        }
        if (firstElmIdx >= size) {
            throw new ArrayIndexOutOfBoundsException("firstElmIdx >= size. FirstElmIdx = " + firstElmIdx + " , size = " + size);
        }
        if (secondElmIdx >= size) {
            throw new ArrayIndexOutOfBoundsException("secondElmIdx >= size. SecondElmIdx = " + secondElmIdx + " , size = " + size);
        }
        T stash = array[firstElmIdx];
        array[firstElmIdx] = array[secondElmIdx];
        array[secondElmIdx] = stash;
    }
}
