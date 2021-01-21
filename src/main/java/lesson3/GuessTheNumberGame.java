package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    int min = 0;
    int max = 9;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.playGame();
    }

    public void playGame() {
        Random random = new Random();
        int userNumber;
        int randomInt = random.nextInt(max - min) + min;  // если указываю просто 10 как на леции. То у меня всегда randomInt равен 0
        boolean flag = true; // для условия выхода из игры
        while (flag) {
            System.out.println("Введите число от " + min + " до " + max);
            int count = 3; // счетчик попыток
            do {
                userNumber = getUserNumber();
                if (checkResult(userNumber, randomInt, count)) {
                    break;
                }
                count--;
            } while (count > 0);
            flag = getFlagForExitGame();
        }
        sc.close();
    }

    // получаем число от пользователя
    private int getUserNumber() {
        int number = -1;
        do {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
            } else {
                System.out.println("Вы ввели не число. Введите число и нажмите Enter");
                sc.next();
                continue;
            }
            if (number < min || number > max) {
                System.out.println("Вы ввели число в не диапазона от " + min + " и " + max + ". Попробуйте еще раз.");
            }
        }
        while (number < min || number > max);
        return number;
    }

    // получаем флаг выхода из игры
    private boolean getFlagForExitGame() {
        System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).");
        int number = 0;
        do {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
            } else {
                System.out.println("Вы ввели не число. Попробуйте еще раз.");
                sc.next();
            }
            if (number < 0 || number > 1) {
                System.out.println("Вы ввели число отличное от 0 и 1. Попробуйте еще раз.");
            }
        }
        while (number < 0 || number > 1);
        return number == 1;
    }

    // получаем результаты введенных пользователем значений
    private boolean checkResult(int userNumber, int randomInt, int count) {
        if (userNumber > randomInt && count - 1 != 0) {
            System.out.println("Загаданное число меньше введенного числа");
            return false;
        }
        if (userNumber < randomInt && count - 1 != 0) {
            System.out.println("Загаданное число больше ввденного числа");
            return false;
        }
        if (randomInt == userNumber) {
            System.out.println("Вы угадали!!! Загаданное число " + randomInt);
            return true;
        }
        System.out.println("Вы не угадали число: число равно " + randomInt);
        return false;
    }
}


