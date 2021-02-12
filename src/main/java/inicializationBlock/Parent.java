package inicializationBlock;

public class Parent {

    int age;
    String name;

    static {
        System.out.println("Parent Static block");
    }
    {
        System.out.println("Parent init block2");
    }
    {
        System.out.println("Parent init block");
    }

    public Parent(String name) {
        this.name = name;
    }
}
