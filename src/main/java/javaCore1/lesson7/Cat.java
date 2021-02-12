package javaCore1.lesson7;

public class Cat {

    private final String name;

    private final int satietyVolume;

    private int currentSatiety;

    public Cat(String name, int satietyVolume) {
        this.name = name;
        this.satietyVolume = setSatietyVolume(satietyVolume);
    }

    public void eat(Plate plate) {
        // кот сытый
        if (currentSatiety == satietyVolume) {
            System.out.println(name + " сыт и не хочет есть");
            return;
        }
        // если еды больше чем положено и кот голодный
        if (plate.getCurrentFoot() >= satietyVolume && currentSatiety == 0) {
            currentSatiety = satietyVolume;
            System.out.println(name + " покушал и остался сыт. Кот съел " + satietyVolume + " еды");
            plate.cleanPlateOnVolume(satietyVolume);
            return;
        }
        // пустая тарелка
        if (plate.getCurrentFoot() == 0) {
            System.out.println("Вы дали коту " + name + " пустую тарелку, наполните ее");
            return;
        }
        // если в тарелке есть еда и коту недостаточно для насыщения
        if (plate.getCurrentFoot() > 0) {
            if (currentSatiety == 0) { // кормим кота тем что есть
                int foot = satietyVolume - plate.getCurrentFoot(); // сколько коту нужно для насыщения
                System.out.println(name + " съел " + plate.getCurrentFoot() + " , кот не наелся, ему не хватило " + foot);
                currentSatiety = plate.getCurrentFoot();
                plate.cleanPlateOnVolume(plate.getCurrentFoot());
                return;
            }
            // если при повторном кормлении коту будет хватить еды
            if (satietyVolume - currentSatiety < plate.getCurrentFoot()) {
                int foot = satietyVolume - currentSatiety;
                currentSatiety = satietyVolume;
                System.out.println(name + " съел " + foot + " , кот наелся");
                plate.cleanPlateOnVolume(plate.getCurrentFoot() - foot);
                return;
            }
            // если коту при повторном кормлении снова не повезет))
            if (currentSatiety > 0) {
                int foot = satietyVolume - currentSatiety;
                if (plate.getCurrentFoot() < foot) {
                    currentSatiety = currentSatiety + plate.getCurrentFoot();
                    System.out.println(name + " съел " + plate.getCurrentFoot() + " , кот не наелся, ему не хватило " + (satietyVolume - currentSatiety));
                    plate.cleanPlateOnVolume(plate.getCurrentFoot());
                }
            }
        }
    }

    private int setSatietyVolume(int volume) {
        if (volume < 0 || volume > 20) {
            System.out.println("Кот не может быть таким большим: максимально допустимый объем сытости равен 20. Сытость установлена 20");
            return 20;
        }
        return volume;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", satietyVolume=" + satietyVolume +
                ", currentSatiety=" + currentSatiety +
                '}';
    }

    public boolean isSatiety() {
        return currentSatiety == satietyVolume;
    }

    public String getName() {
        return name;
    }
}
