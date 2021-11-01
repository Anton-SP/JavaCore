package HomeWork1.lesson4;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

//крестки нолики
public class HomeWorkApp4 {  private static final int SIZE = 10;
    private static final int WINROW = 4;//условие победы!

    private static final char DOT_EMPTY = '*';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

  //  private static final String SPACE_MAP = " ";
    private static final String HEADER_FIRST_MAP = "%";

    private static final char[][] MAP = new char[SIZE][SIZE];
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static int turnCount = 0;
    private static int lastTurnRow;//
    private static int lastTurnCol;//


    public static void main(String[] args) {
        turnGame();


    }

    private static void turnGame() {
        do {
            System.out.println("\n\nИгра начинается");
            init();
            drawMap();
            playGame();
        } while (isContiniueGame());
        endGame();
    }

    private static void init() {
        newMap();
        turnCount = 0;
    }


    private static boolean isContiniueGame() {
        System.out.println("Хотите продолжить?");
        return switch (in.next()) {
            case "y", "yes", "+" -> true;
            default -> false;
        };
    }


    private static void newMap() {//инициализация поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void drawMap() {//отрисовка поля
        printHeader();
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%4s",MAP[i][j]);//"красивый" вывод
                //  System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }

    }

    private static void printMapNumber(int i) {
        System.out.printf("%4d",i + 1);
        //System.out.printf(i + 1 + SPACE_MAP);
    }

    private static void printHeader() {
        System.out.printf("%4s",HEADER_FIRST_MAP);
        //System.out.print(HEADER_FIRST_MAP + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
    }


    private static void playGame() {
        while (true) {
            turnHuman();
            drawMap();
            if (checkEnd(DOT_HUMAN)) {//проверка на победу
                break;
            }

            turnAI();
            drawMap();

            if (checkEnd(DOT_AI)) {
                break;
            }

        }


    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("\nИгрок победил!");
            } else {
                System.out.println("\nИИ Победил");
            }
            return true;
        }
        if (checkDraw()) {
            System.out.println("\nНичья");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        return turnCount >= SIZE * SIZE;

    }

    private static boolean checkWin(char symbol) {
        return ((checkLine(symbol)) || (checkRow(symbol)) || (checkDiagonalRise(symbol)) || (checkDiagonalDown(symbol)));

    }


    private static boolean checkLine(char symbol) {
        int winRowCurrent = 0;
        for (int i = 0; i < MAP.length; i++) {
            if (MAP[lastTurnRow][i] == symbol) {
                winRowCurrent++;
                if (checkWinCount(winRowCurrent)) {
                    return true;
                }
            } else winRowCurrent = 0;
        }
        return false;


    }

    private static boolean checkRow(char symbol) {
        int winRowCurrent = 0;
        for (int i = 0; i < MAP.length; i++) {
            if (MAP[i][lastTurnCol] == symbol) {
                winRowCurrent++;
                if (checkWinCount(winRowCurrent)) {
                    return true;
                }
            } else winRowCurrent = 0;
        }
        return false;

    }
    //ооочень не красиво, но работает
    private static boolean checkDiagonalRise(char symbol) {
        int winRowCurrent = 0;
        //поверка по диагонали          Х
        //сначало берем диагональ->    /
        //                            /
        //восходящая слево направо, не знаю как еще описать
        //идем  вниз по диагонали пока не встретим символ отличный от последнего хода либо не дойдем до края поля (массива)
        //можно было их и в циклах объявить но так понятнее
        int i = lastTurnRow;
        int j = lastTurnCol;
        //обычно массив проходи for но тут мы идем по диагонали поэтому родилось это
        while ((i < MAP.length) && (0 < j) && (MAP[i][j] == symbol)) {
            i++;
            j--;
        }
        if (i != MAP.length) {  //блок проверки не вышли ли мы за границы массива в while
            if (MAP[i][j] != symbol) {
                i--;
                j++;
            }
        } else {
            i--;
            j++;
        }//если вышли возращаемся на пред элемент

        //а теперь считаем есть ли победная комбинация
//        можно было бы проверять не всю диагональ а только от границы до последнего хода + колчичесвто ячеек до победы-1
        //но это еще 1 проверка которая в данном варианте не значительная т.к. полем 1000000 на 100000 наверно играть никто не будет
//        поэтому просто до длины массива точнее если идем снизу верх то от полседней строки с нужным элементом до первой строки
        while ((i >= 0) && (j < MAP[0].length) && (MAP[i][j] == symbol)) {
            /* человеским языком - до тех пор пока i не дошла до первой строки и j не вышла за поле (с правой стороны)
            и проверямый символ равняется искомому мы ссумируем счетчик победной линии
            */
            winRowCurrent++;
            i--;
            j++;
            if (checkWinCount(winRowCurrent)) {
                return true;
            }
        }
        return false;
    }


    private static boolean checkDiagonalDown(char symbol) {
        int winRowCurrent = 0;
        //поверка по диагонали      \
        //теперь диагональ->         x
        //                            \
        //нисходящая слева напрво
        int i = lastTurnRow;
        int j = lastTurnCol;
        while ((i > 0) && (j > 0) && (MAP[i][j] == symbol)) {
            i--;
            j--;
        }

        if (MAP[i][j] != symbol) {
            i++;
            j++;
        }//если вышли из цикла по третьему условию надо венуться на предыдущий элемент
        //а теперь считаем есть ли победная комбинация
//
        while ((i < MAP.length) && (j < MAP[0].length) && (MAP[i][j] == symbol)) {
            /* человеским языком - до тех пор пока i не дошла до последней строки и j не вышла за поле (с правой стороны)
            и проверямый символ равняется искомому мы ссумируем счетчик победной линии
            */
            winRowCurrent++;
            i++;
            j++;
            if (checkWinCount(winRowCurrent)) {
                return true;
            }
        }
        return false;


    }


    private static boolean checkWinCount(int winRowCurrent) {
        return (winRowCurrent == WINROW);
    }


    private static void turnHuman() {
        System.out.println("Ход Игрока");
        int rowNumber, colNumber;

        while (true) {
            rowNumber = getValidNumberFromUser() - 1;
            colNumber = getValidNumberFromUser() - 1;
            if (isCellFree(rowNumber, colNumber)) {
                lastTurnRow = rowNumber;
                lastTurnCol = colNumber;
                break;
            } else {
                System.out.println("Вы выбрали занятую ячейку");
            }
        }

        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnCount++;
    }

    private static int getValidNumberFromUser() {
        while (true) {
            System.out.print("Введите координату от 1 до " + SIZE + " ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                } else {
                    System.out.println("\nПроверьте значение координаты должно быть от 1 до " + SIZE);
                }


            } else {
                in.next();
                System.out.println("\nВвод допускает только целые чилса");
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }


    private static void turnAI() {
        System.out.println("Ход ИИ");
        int rowNumber, colNumber;

        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
            if (isCellFree(rowNumber, colNumber)) {
                lastTurnRow = rowNumber;
                lastTurnCol = colNumber;
                break;
            }
        } while (true);

        MAP[rowNumber][colNumber] = DOT_AI;
        turnCount++;
    }

    private static void endGame() {
        System.out.println("Спасибо за игру!");
    }

}

