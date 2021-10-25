package HomeWork1;

import com.sun.source.tree.ArrayAccessTree;

import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
//      printTHeeWords();//вызов метода вывода трех строк
//      checkSumSign();//вызов метода сравнения двух чисел
//      printColour();//вызов метода вывода цвета
//      compareNumbers();//вызов метода сравнения чисел
        chooseAction();
    }

    //метод вывода трех строк
    private static void printTHeeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        chooseAction();
    }

    //метод для двух int переменных с сравнением и выводом
    private static void checkSumSign() {
        int a = -20; //задаем переменную a
        int b = 3; // задаем переменную
        if ((a + b) > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        chooseAction();
    }

    //метод вывода цвета в зависимости от заданного числа
    private static void printColour() {
        int value = 1000;
        if (value <= 0) {
            System.out.println("Красный");
        } else if ((value > 0) && (value <= 100)) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зеленый");
        }
        chooseAction();
    }

    //метод сравнения чисел
    private static void compareNumbers() {
        int a = 50;
        int b = 10;
        if (a >= b) {
            System.out.println(a + ">=" + b);
        } else {
            System.out.println(a + "<" + b);
        }
        chooseAction();
    }

    //небольшое отступление от ДЗ сделано примитивно и громозко, но сделано
    //нашел код пользоватеьского ввода в консоль и немного поигрался
    private static void chooseAction() {
        //выводим меню
        System.out.println("Привет, Вы попали в меню выбора задачи, пожалуйста выберите из следующего списка:");
        System.out.println("1. Метод вывода трех строк");
        System.out.println("2. Метод сравнения двух чисел");
        System.out.println("3. Метод вывода цвета");
        System.out.println("4. Метод  метода сравнения чисел");
        System.out.println("5. Выход");
        //далее кусок из https://metanit.com/java/tutorial/2.9.php по пользовательскому вводу
        Scanner in = new Scanner(System.in); //есл ивсё правильно понял то scanner это "тип" пользовательского вввода
        System.out.println("Выберите задачу");
        int num = in.nextInt();
        //  System.out.println("Вы выбрали:" num);
        // in.close();
        //поверям что ввел пользователь и заускаем выбранный метод
        // скорее всего есть более элегантный способ, но я пока его не знаю
        //и не нашел единого подхода на проверку является ли вводимое значение числом так что если ввести буквы то прога валится
        if (num == 1) {
            printTHeeWords();
        } else if (num == 2) {
            checkSumSign();
        } else if (num == 3) {
            printColour();
        } else if (num == 4) {
            compareNumbers();
        } else if (num == 5) {
            System.out.println("Хорошего Вам дня, до свидания");
        } else {
            System.out.println("Вы ввели неверное значение, пожалуста попробуйте снова");
            chooseAction();
        }
        in.close();
    }

}











