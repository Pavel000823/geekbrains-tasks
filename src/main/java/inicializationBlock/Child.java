package inicializationBlock;

public class Child extends Parent{

    int age = 10;

    static {
        System.out.println("Static child");
    }


    {System.out.println("init child 2");}
    {System.out.println("init child");}
    public Child(String name) {
        super(name);
        System.out.println(super.age);
    }
}
