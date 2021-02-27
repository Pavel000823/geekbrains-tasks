package javaCore2.lesson5;


import java.util.Arrays;

public class MainApp extends Thread {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) throws InterruptedException {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        // в 1 потоке
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Синхронное выполнение : " + (endTime - startTime) + " ms");


        // в 2 потоках

        Arrays.fill(arr, 1);
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        startTime = System.currentTimeMillis();

        ArrayCalculate calculate1 = new ArrayCalculate(arr, arr1, 0);
        ArrayCalculate calculate2 = new ArrayCalculate(arr, arr2, h);

        Thread thread1 = new Thread(calculate1);
        Thread thread2 = new Thread(calculate2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr1, 0, arr, h, h);

        endTime = System.currentTimeMillis();
        System.out.println("Асинхронное выполнение : " + (endTime - startTime) + " ms");

    }
}
