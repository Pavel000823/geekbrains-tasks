package javaCore2.lesson2;

import javaCore2.lesson2.exptions.MyArrayDataException;
import javaCore2.lesson2.exptions.MyArraySizeException;
import javaCore2.lesson2.exptions.MyRegexException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        boolean flag = false;
        while (!flag) {
            try {
                int sum = getSum(data);
                System.out.println("Сумма массива = " + sum);
                printArray(data);
                flag = true;
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
                flag = true;
            } catch (MyArrayDataException e) {
                fixArrayData(data, e);
            }
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

    private static boolean checkRegex(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static void fixArrayData(String[][] array, MyArrayDataException e) {
        String message = e.getMessage();
        String regex = "[\\d+]+";
        if (checkRegex(message, regex)) {
            int i = Integer.parseInt(message.substring(message.indexOf("[") + 1, message.indexOf("]")));
            int j = Integer.parseInt(message.substring(message.lastIndexOf("[") + 1, message.lastIndexOf("]")));
            array[i][j] = "0";
            return;
        }
        throw new MyRegexException("Не удалось получить из " + e.getClass() + " путь к ячейки массива: regex = " + regex + " message = " + message);
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
