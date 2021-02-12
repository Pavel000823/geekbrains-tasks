package javaCore1.lesson7;

public class Plate {

    private final int volumePlate;
    private int currentFoot;

    public Plate(int volume) {
        this.volumePlate = volume;
    }

    public Plate() {
        this.volumePlate = 100;
    }

    // наполнение тарелки
    public void fillPlate(int foot) {
        if (foot < 0) {
            System.out.println("Нельзя наполнить тарелку пустотой");
            return;
        }
        if (foot > volumePlate) {
            System.out.println("Вы пытаетесь наполнить тарелку объемом " + volumePlate + " количеством еду " + foot + " количество еды равно " + volumePlate);
            currentFoot = volumePlate;
            return;

        }
        currentFoot = foot;
    }

    public int getCurrentFoot() {
        return currentFoot;
    }

    // уборка еды из тарелки
    public void cleanPlateOnVolume(int food) {
        if (currentFoot < food || currentFoot == 0) {
            currentFoot = 0;
            return;
        }
        currentFoot = currentFoot - food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "volumePlate=" + volumePlate +
                ", currentFoot=" + currentFoot +
                '}';
    }
}
