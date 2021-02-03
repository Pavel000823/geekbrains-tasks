package lesson7;

public class MainApp {
    public static void main(String[] args) {
        Plate plate = new Plate(25);

        Cat[] cats = {new Cat("Филя", 14), new Cat("Маркел", 4),
                new Cat("Босс", 5), new Cat("Граф", 6),
                new Cat("Барс", 7)};

        plate.fillPlate(40);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        plate.fillPlate(15);
        System.out.println("-------------------"); // разделить вывод
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
}
