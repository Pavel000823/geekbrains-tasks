package lesson1;

public class MainApp {

    public static void main(String[] args) {
        byte toByte = 25;
        short toShort = 20;
        int toInt = 10;
        long toLong = 44L;

        double toDouble = 1235.0d;
        float toFloat = 12312.0f;

        char toChar = 't'; // 16 бита
        boolean toBoolean = false;

        System.out.println("byte: " + toByte);
        System.out.println("short: " + toShort);
        System.out.println("toInt: " + toInt);
        System.out.println("long: " + toLong);
        System.out.println("toDouble: " + toDouble);
        System.out.println("toFloat: " + toFloat);
        System.out.println("char: " + toChar);
        System.out.println("boolean: " + toBoolean);


        System.out.println("calculateToExample: " + calculateToExample(5.1f, 6.2f, 35f, 0f));
        System.out.println("calculateToExample: " + calculateToExample(5.1f, 6.2f, 35f, 10.1f));

        System.out.println("checkSumToRange: " + checkSumToRange(10, 20));
        System.out.println("checkSumToRange: " + checkSumToRange(10, 5));

        checkPositiveNumber(-5);
        checkPositiveNumber(0);
        checkPositiveNumber(125);

        System.out.println("checkNegativeNumber: " + checkNegativeNumber(5));
        System.out.println("checkNegativeNumber: " + checkNegativeNumber(-5));
        System.out.println("checkNegativeNumber: " + checkNegativeNumber(0));

        printWelcome(null);
        printWelcome("");
        printWelcome("Pavel");

        checkLeapYear(1764);
        checkLeapYear(1400);
        checkLeapYear(1572);
        checkLeapYear(1896);
        checkLeapYear(1904);
        checkLeapYear(1908);
        checkLeapYear(2000);
        checkLeapYear(2020);
        checkLeapYear(2019);
    }

    // a * (b + (c / d))
    public static float calculateToExample(float a, float b, float c, float d) {
        if (d == 0) {
            System.out.println("Переменная d не может быть равной 0");
            return 0;
        }
        return a * (b + (c / d));
    }

    public static boolean checkSumToRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    //   Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное
    //   ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

    public static void checkPositiveNumber(int number) {
        if (number < 0) {
            System.out.println("Число является отрицательным : " + number);
        } else {
            System.out.println("число является положительным : " + number);
        }
    }


    //   Написать метод, которому в качестве параметра передается целое число. Метод должен
    //   вернуть true, если число отрицательное, и вернуть false если положительное.

    public static boolean checkNegativeNumber(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    //    Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    //    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

    public static void printWelcome(String name) {
        if (name == null || name.equals("")) {
            name = "unknown";
        }
        System.out.println("«Привет, " + name + "!»");
    }


    //  *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й
    //  год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static void checkLeapYear(long year) {
        if ((year % 4 != 0 || year % 100 == 0) && year % 400 != 0) {
            System.out.println("Год " + year + " не является високостным");
        } else System.out.println("Год " + year + " является високостным");
    }
}
