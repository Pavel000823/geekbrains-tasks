package threadsTest;

public class Test implements Runnable {


    public synchronized void method() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Int " + i + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
            method2();
            method();
    }

    public synchronized void method2(){
        System.out.println("No synchronized");
    }
}
