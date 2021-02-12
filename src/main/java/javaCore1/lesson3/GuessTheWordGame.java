package javaCore1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWordGame {

    private Scanner sc = new Scanner(System.in);
    private String[] dbWords = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        GuessTheWordGame game = new GuessTheWordGame();
        game.play();

    }

    public void play() {
        Random random = new Random();
        String hiddenWord = dbWords[random.nextInt(dbWords.length)];
        while (true) {
            String userWord = getUserWord();
            if (userWord.equals(hiddenWord)) {
                System.out.println("Ура! Вы отгадали слово");
                break;
            } else {
                System.out.println(getHelpMessage(userWord, hiddenWord));
            }
        }
    }


    private String getHelpMessage(String userWord, String hiddenWord) {
        int count = 0; // макс совпадающая последовательность символов
        int userWordLength = userWord.length();
        int hiddenWordLength = hiddenWord.length();
        int length = Math.min(userWordLength, hiddenWordLength); // узнаем какое из слов меньше и по нему будем проверять совпадения
        for (int i = 0; i < length; i++) {
            char userWordChar = userWord.charAt(i);
            char hiddenWordChar = hiddenWord.charAt(i);
            if (userWordChar == hiddenWordChar) {
                count++;
                continue;
            }
            break;
        }
        return getFormationHelpMessage(userWord, count);

    }

    private String getFormationHelpMessage(String word, int countPositions) {
        if (countPositions == 0) {
            return "############# - не угадали. Попробуйте еще";
        }
        return word.substring(0, countPositions) + "############# - Подсказка. Попробуйте еще";
    }

    private String getUserWord() {
        System.out.println("Введите слово");
        String word = "";
        boolean flag = true;
        do {
            word = sc.nextLine();

            if (word.equals("")) {
                System.out.println("Вы неввели слово. Попробуйте еще раз");
                continue;
            }
            if (word.equals(" ")) {
                System.out.println("Вы ввели пробел. Попробуйте еще раз");
                continue;
            }
            if (word.contains(" ")) {
                System.out.println("Вы ввели пробел или несолько слов. Попробуйте еще раз");
                continue;
            }
            flag = false;
        }
        while (flag);
        return word.toLowerCase();
    }


}
