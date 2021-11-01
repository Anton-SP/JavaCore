package HomeWork1.lesson2;

import java.util.Scanner;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        chooseAction();
    }


    //метод проверки принадлежит ли число диапазону (10,20]
    private static boolean compareNumbers(int a, int b) {
        if (10 < (a + b) && (a + b) <= 20) return true;
        else return false;
    }

    // метод проверки чилса на + или / - возврат строка
    private static String positiveOrNegativeNumberString(int a) {
        if (a < 0) return "Число " + a + " отрицательное";
        else return "Число " + a + " положительное";
    }

    //метод проверки является ли число отрицательным- возврат boolean
    private static boolean isNumberNegative(int a) {
        if (a < 0) return true;
        else return false;
    }

    //метод вывода строки n-раз
    private static void repeatString(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    //метод проверки годана високосный
    private static boolean checkYear(int a) {
        if (a < -45 && a != 0) {
            System.out.print("Вы задали не корректный год но надо что то вернуть поэтому - ");
            return false;
        } else {
            if ((a % 4 == 0) && (a % 100 != 0) || (a % 400 == 0)) {
                return true;
            } else return false;

        }
    }

    private static void chooseAction() {
        //выводим меню
        System.out.println("Вы попали в меню выбора задачи, пожалуйста выберите из следующего списка:");
        System.out.println("1. Метод проверки принадлежит ли число диапазону (10,20]");
        System.out.println("2. Метод проверки чилса на + или / - возврат строка");
        System.out.println("3. Метод проверки является ли число отрицательным- возврат boolean");
        System.out.println("4. Метод вывода строки n-раз");
        System.out.println("5. Метод проверки на високосный год");
        System.out.println("6. Выход");
        //далее кусок из https://metanit.com/java/tutorial/2.9.php по пользовательскому вводу
        Scanner in = new Scanner(System.in); //польлзовательски ввод
        System.out.println("Выберите задачу");
        //Игорь споасибо за совет, проверка работает, след шаг сдделать методы интерактивными, чтбы пользователь
        //сам ввоодил значения в методы. Но боюсь будет громозко
        if (in.hasNextInt()) {  //проверка вводана число если true то выполняем меню
            int num = in.nextInt();
            //меню теперь через Switch
            switch (num) {
                case 1 -> {
                    System.out.println(compareNumbers(21, 10));
                    chooseAction();
                }
                case 2 -> {
                    System.out.println(positiveOrNegativeNumberString(-12));
                    chooseAction();
                }
                case 3 -> {
                    System.out.println(isNumberNegative(-12));
                    chooseAction();
                }
                case 4 -> {
                    repeatString("Я выведу эту строку n раз", 5);
                    chooseAction();
                }
                case 5 -> {
                    System.out.println(checkYear(1999));
                    chooseAction();
                }
                case 6 -> System.out.println("Хорошего Вам дня, до свидания");
                default -> {
                    System.out.println("Вы ввели неверное значение, пожалуста попробуйте снова");
                    chooseAction();
                } //закрыли default скобок много поэтому буду отмечать
            }//закрыли switch
        } else {
            System.out.println("Вы ввели не число, пожалуста попробуйте снова");
            chooseAction();
        }//это есл ипользователь ввел не число
        in.close();
    }//закрыли метод


}//закрыли класс