package lesson2;

public class MainApp {

    public static void main(String[] args) {
        int[] array1 = {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1};
        int[] array2 = {0, 1, 0, 25, 0, 5, 0, 4, 0, 0, 1, 1, 1, 0, 1};
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] array4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] array5 = {{0, 1, 3, 4, 6}, {8, 2, 3, 5, 4}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 6}};
        int[] array6 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] array7 = {2, 2, 2, 1, 2, 2, 11, 1};
        int[] array8 = {7, 5, 3, 2, 11};

        print(array1);
        print(array2);

        replace(array1);
        replace(array2);

        printArrayWithStepsOfThree(8);
        printArrayWithStepsOfThree(10);

        changeArray(array3);
        changeArray(array4);
        changeArray(array5);

        findMaxAndMinValues(array3);
        findMaxAndMinValues(array2);

        System.out.println(checkBalance(array6));
        System.out.println(checkBalance(array7));

        reverse(array8, -2);
        reverse(array8, 8);
        reverse(array8, 3);
    }


    // 1.Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void replace(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != 0 && mass[i] != 1) {
                System.out.println(" в массиве есть число отлчиное от 0 и 1. Число равно : " + mass[i]);
            }
            if (mass[i] == 1) {
                mass[i] = 0;
            } else if (mass[i] == 0) {
                mass[i] = 1;
            }
        }
        print(mass);
    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void printArrayWithStepsOfThree(int arraySize) {
        int[] mass = new int[arraySize];
        int value = 0;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = value;
            value = value + 3;
        }
        print(mass);
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArray(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 6) {
                mass[i] = mass[i] * 2;
            }
        }
        print(mass);
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void changeArray(int[][] array) {
        for (int i = 0, k = array.length - 1; i < array.length; i++, k--) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != array[i].length) {
                    System.out.println(" Размерность массива должна быть одинаковой");
                    return;
                }
                if (i == j) {
                    array[i][j] = 1;
                }
                if (array.length - k - 1 == j) {
                    array[k][j] = 1;
                }
            }
        }
        print(array);
    }


    // 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void findMaxAndMinValues(int[] array) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                max = array[0];
                min = array[0];
                continue;
            }
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        print(array);
    }


    //** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
    // в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftSum = leftSum + array[i];
            for (int j = i + 1; j < array.length; j++) {
                rightSum = rightSum + array[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
            rightSum = 0; // обнуляем на каждой итерации;
        }
        return false;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.

    public static void reverse(int[] array, int n) {
        print(array); // для наглядности
        if (array.length < n) {
            System.out.println("Значение сдвига больше чем размерность массива");
            return;
        }
        if (n > 0) {
            positive(array, n);
        } else
            negative(array, n);

    }

    public static void positive(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int temp = array[0];
            array[0] = array[array.length - 1];
            for (int j = array.length - 1; j > 1; j--) {
                array[j] = array[j - 1];
                if (j - 1 == 1) {
                    array[j - 1] = temp;
                }
            }
        }
        print(array);
    }

    public static void negative(int[] array, int n) {
        n = Math.abs(n);
        int length = array.length - 1;
        for (int i = 0; i < n; i++) {
            int temp = array[length];
            array[length] = array[0];
            for (int j = 1; j <= length; j++) {
                array[j - 1] = array[j];
                if (j == length) {
                    array[j - 1] = temp;
                }
            }
        }
        print(array);
    }


    // для вывода с перегрузкой методов.
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // для того что бы перешли на новую строку
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
