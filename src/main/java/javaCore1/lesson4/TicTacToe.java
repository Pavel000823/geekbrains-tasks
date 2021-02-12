package javaCore1.lesson4;


import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final Scanner sc = new Scanner(System.in);

    private char[][] gameMap;
    private final int DOTS_TO_WIN;
    private final int SIZE;
    private int count = 0;

    private final char EMPTY_DOT = '•';
    private final char X_DOT = 'X';
    private final char O_DOT = 'O';

    private final Random random = new Random();


    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3, 3);
        ticTacToe.play();
    }

    public TicTacToe(int size, int dotsToWin) {
        this.SIZE = size;
        this.DOTS_TO_WIN = dotsToWin;
    }

    public void play() {
        initGameMap();
        printGameMap();
        while (true) {
            humanTurn();
            count++;
            if (checkWin(X_DOT)) {
                System.out.println("Вы выйграли!!!");
                printGameMap();
                break;
            }
            if (count == SIZE * SIZE) {
                System.out.println("Ничья!!!");
                printGameMap();
                break;
            }
            computerTurn();
            count++;
            printGameMap();
            if (checkWin(O_DOT)) {
                System.out.println("Извините, но вы проиграли, Копьютер выйграл");
                printGameMap();
                break;
            }
        }
    }

    private void computerTurn() {
        int x;
        int y;
        boolean checkCell;
        do {
            if (goToBlockedStepForUser()) {
                checkCell = true;
            } else {
                x = random.nextInt(gameMap.length);
                y = random.nextInt(gameMap.length);
                checkCell = isValidCell(x, y);
                if (checkCell) {
                    gameMap[x][y] = O_DOT;
                }
            }
        } while (!checkCell);

    }

    private boolean goToBlockedStepForUser() {
        int x = 0;
        int y = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0, k = gameMap.length - 1; i < gameMap.length; i++, k--) {
            for (int j = 0; j < gameMap.length; j++) {
                if (gameMap[i][j] == X_DOT) {  // для проверки по горизонтали
                    x++;
                    if (x == DOTS_TO_WIN - 1) {
                        if (checkComputerStepInRowByIndexRow(i)) {
                            goToBlockStepRow(i);
                            return true;
                        }
                    }
                }
                if (gameMap[j][i] == X_DOT) { // проверка по вертикали
                    y++;
                    if (y == DOTS_TO_WIN - 1) {
                        if (checkComputerStepInColumnByIndexRow(i)) {
                            goToBlockStepСolumn(i);
                            return true;
                        }
                    }
                }
                if (i == j && gameMap[i][j] == X_DOT) { // проверка по 1 диагонали
                    diagonal1++;
                    if (diagonal1 == DOTS_TO_WIN - 1) {
                        if (checkComputerStepInDiagonalOne(i)) {
                            goToBlockStepDiagonalOne();
                            return true;
                        }
                    }
                }
                if (gameMap.length - k - 1 == j && gameMap[k][j] == X_DOT) { // проверка по 2 диагонали
                    diagonal2++;
                    if (diagonal2 == DOTS_TO_WIN - 1) {
                        if (checkComputerStepInDiagonalTwo()) {
                            goToBlockStepDiagonalTwo();
                            return true;
                        }
                    }
                }
            }
            x = 0;  // обнуляем счетчики при переходе на след итерацию
            y = 0;
        }
        return false;
    }

    private void goToBlockStepRow(int row) {
        for (int j = 0; j < gameMap.length; j++) {
            if (isValidCell(row, j)) {
                gameMap[row][j] = O_DOT;
                break;
            }
        }
    }

    private boolean checkComputerStepInRowByIndexRow(int index) {
        for (int j = 0; j < gameMap.length; j++) {
            if (isValidCell(index, j)) {
                return true;
            }
        }
        return false;
    }

    private void goToBlockStepСolumn(int column) {
        for (int i = 0; i < gameMap.length; i++) {
            if (isValidCell(i, column)) {
                gameMap[i][column] = O_DOT;
                break;
            }
        }
    }

    private boolean checkComputerStepInColumnByIndexRow(int index) {
        for (int i = 0; i < gameMap.length; i++) {
            if (isValidCell(i, index)) {
                return true;
            }
        }
        return false;
    }

    private void goToBlockStepDiagonalOne() {
        for (int i = 0, j = 0; i < gameMap.length; i++, j++) {
            if (isValidCell(i, j) && isValidCell(i, j)) {
                gameMap[i][j] = O_DOT;
                break;
            }
        }
    }

    private boolean checkComputerStepInDiagonalOne(int index) {
        for (int i = 0, j = 0; i < gameMap.length; i++, j++) {
            if (isValidCell(i, j) && isValidCell(i, j)) {
                return true;
            }
        }
        return false;
    }

    private void goToBlockStepDiagonalTwo() {
        for (int i = 0, k = gameMap.length - 1; i < gameMap.length; i++, k--) {
            for (int j = 0; j < gameMap.length; j++) {
                if (gameMap.length - k - 1 == j && isValidCell(k, j)) {
                    gameMap[k][j] = O_DOT;
                    break;
                }
            }
        }

    }

    private boolean checkComputerStepInDiagonalTwo() {
        for (int i = 0, k = gameMap.length - 1; i < gameMap.length; i++, k--) {
            for (int j = 0; j < gameMap.length; j++) {
                if (gameMap.length - k - 1 == j && isValidCell(k, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWin(char c) {
        int x = 0;
        int y = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0, k = gameMap.length - 1; i < gameMap.length; i++, k--) {
            for (int j = 0; j < gameMap.length; j++) {
                if (gameMap[i][j] == c) {  // для проверки по горизонтали
                    x++;
                    if (x == DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (gameMap[j][i] == c) { // проверка по вертикали
                    y++;
                    if (y == DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (i == j && gameMap[i][j] == c) { // проверка по 1 диагонали
                    diagonal1++;
                    if (diagonal1 == DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (gameMap.length - k - 1 == j && gameMap[k][j] == c) { // проверка по 2 диагонали
                    diagonal2++;
                    if (diagonal2 == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            x = 0;  // обнуляем счетчики при переходе на след итерацию
            y = 0;
            diagonal1 = 0;
            diagonal2 = 0;
        }
        return false;
    }

    private void humanTurn() {
        int x = -1;
        int y = -1;
        boolean checkCell;

        do {
            System.out.println("Введите координаты в формате X Y");
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                y = sc.nextInt() - 1;
            }
            sc.nextLine();
            checkCell = isValidCell(x, y);
        } while (!checkCell);
        gameMap[x][y] = X_DOT;
    }

    private boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > gameMap.length || y > gameMap.length)
            return false;
        return gameMap[x][y] == EMPTY_DOT;
    }

    private void printGameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print("|" + gameMap[i][j]);
            }
            System.out.println();
        }
    }

    private void initGameMap() {
        gameMap = new char[SIZE][SIZE];
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = EMPTY_DOT;
            }
        }
    }

}
