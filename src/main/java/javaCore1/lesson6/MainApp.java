package javaCore1.lesson6;

import javaCore1.lesson6.animals.Animal;
import javaCore1.lesson6.animals.Cat;
import javaCore1.lesson6.animals.Dog;

public class MainApp {

    public static void main(String[] args) {
        Animal[] animals = {new Dog("Шарик"), new Cat("Маркел"), new Dog("Граф"), new Cat("Филя")};
        for (Animal animal : animals) {
            animal.swim(5);
            animal.swim(15);
            animal.run(200);
            animal.run(400);
            animal.run(600);
        }
        System.out.println("Котов создано: " + Cat.count + ", Собак создано: " + Dog.count + " , Всего животных создано " + Animal.count);
    }
}
