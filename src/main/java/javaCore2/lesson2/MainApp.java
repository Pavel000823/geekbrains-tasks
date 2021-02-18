package javaCore2.lesson2;

import javaCore2.lesson2.exptions.MyArrayDataException;
import javaCore2.lesson2.exptions.MyArraySizeException;

public class MainApp {

    public static void main(String[] args) {
        String[][] data = {{"1", "2", "3", "df"},
                {"=1", "2", "3", "df", ""},
                {"1", "2", "3", "5"}, {".", "1", "3", "df"}};
        String[][] data1 = {{"1", "2", "3", "df"},
                {"=1", "2", "3", "df"},
                {"1", "2", "3", "5"}, {".", "1", "3", "df"}};

        printArraySum(data);
        printArraySum(data1);
    }

    public static void printArraySum(String[][] data) {
        try {
            int sum = getSum(data);
            System.out.println("Сумма массива = " + sum);
            printArray(data);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            fixArrayData(data);
            printArraySum(data);
        }
    }


    private static int getSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Количество строк в поданном масиве равно " + array.length + " а должно 4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Количество столбцов в строке  " + i + "  равно " + array[i].length + " а должно 4");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!parseInt(array[i][j])) {
                    throw new MyArrayDataException("В [" + i + "][" + j + "] лежит не числовое значение: " + array[i][j]);
                }
                sum = sum + Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    private static boolean parseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static void fixArrayData(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!parseInt(array[i][j])) {
                    array[i][j] = "0";
                }
            }
        }
    }


    private static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }


}
