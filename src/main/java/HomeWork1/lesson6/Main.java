package HomeWork1.lesson6;

import java.awt.*;
import java.io.Console;
import java.util.Scanner;

import java.awt.*;
import java.io.Console;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("println");
        PetShow petShow1 = addPetShow();
        menu(petShow1);
    }


    private static PetShow addPetShow() {
        int dogMAX = 5;
        int catMax = 5;
        System.out.println("Пора провести выставку домашних животных!, давайте определимся какого размера она может быть!");
        Scanner in = new Scanner(System.in);//кстати по сканеру энтер не воспринимается как символ, не знаю как победить
        System.out.println("Введите количество собак");
        if (in.hasNextInt()) {//если ввод может быть приведен к Int то всё хорошо
            dogMAX = in.nextInt();

            in.nextLine();
        } else {
            in.nextLine();
            System.out.println("Вы ввели неверное значение для поля максимальное количество собак, будет использовано значение по умолчанию = 5");
        }
        System.out.println("Введите количество кошек");
        if (in.hasNextInt()) {//если ввод может быть приведен к Int то всё хорошо
            catMax = in.nextInt();
            in.nextLine();
        } else {
            in.nextLine();
            System.out.println("Вы ввели неверное значение для поля максимальное количество кошек, будет использовано значение по умолчанию = 5");
        }
        //  in.close();
        return (new PetShow(catMax, dogMAX));

    }


    private static void menu(PetShow petShow1) {
        System.out.println();
        System.out.println("Вы попали в меню выбора задачи, пожалуйста выберите из следующего списка:");
        System.out.println("1. Посетить показ кошек");
        System.out.println("2. Посетить показ собак");
        System.out.println("3. Узнать сколько всего животных представлено на сегодняшней выставке!");
        System.out.println("4. Выход");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            switch (num) {
                case 1 -> {
                    //showCatMenu(petShow1.getCats()); изначально хотел работать только с массивом кошек
                    //но в под меню логично было бы засунуть метод указания общего количества существующих элементов
                    //а этот параметр привязан к классу petshow который не является супер классом для кошек! поэтому мы не сможем выцепить свойства через них
                    showCatMenu(petShow1);
                }
                case 2 -> {
                    showDogMenu(petShow1);
                }
                case 3 ->{
                    if (petShow1.getAnimalsCount()!=0){
                        System.out.println("Сегодня на выставке:");
                        for (Animal animals: petShow1.getPets()) {
                            if (animals instanceof Cat trueCat){
                                System.out.printf("Кошка %s%n",trueCat.getName());
                            }
                            if (animals instanceof Dog trueDog){
                                System.out.printf("Собака %s%n",trueDog.getName());
                            }
                        }
                        System.out.printf("Всего сегодня на выставке %d домашних питомцев.%nИз них %d собак и %d кошек.%n",petShow1.getAnimalsCount(),petShow1.getDogCount(),petShow1.getCatCount());
                        menu(petShow1);
                    }else{
                        System.out.println("Пока никто не пришел");
                        menu(petShow1);
                    }
                }
                case 4 ->{
                    System.out.println("Заходите еще!");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Вы ввели неверное значение, пожалуйста попробуйте снова");
                    menu(petShow1);
                } //закрыли default
            }//закрыли switch
        } else {
            System.out.println("Вы ввели не число, пожалуйста попробуйте снова");
            menu(petShow1);;

        }//это если пользователь ввел не число


    }



    // подменю меню кошек!
    private static void showCatMenu(PetShow cats) {//работаем с экземпляром класса PetShow, но называем его cats чтобы не запутаться для чего это меню
        System.out.println();
        System.out.println("Выставка кошек");
        System.out.println("1. Посмотреть общее количество кошек");
        System.out.println("2. Забег");//для упрощения проверим что массив не пустой введм дистанцию и покажем
        // сколько пробежала первая кошка, так как макс дистанция одинаковая для всех
        // если идти дальше то у какой кошки должна быть своя макс дистанция (не final) и тогда можно задать общую дистанцию забега пройтись по массиву
        //и вывести сколько пробежала каждая кошка,
        //а потом ввести доп переменную - какую нибудь stamina которая принимает значение от 0 до 1 и зациклить процесс
        //и на каждом шаге умножать эту переменную на макс дистанцию и высчитывать кто прибежит быстрее так сказать с учётом усталости и второго дыхания

        //вот это будет забег!
        System.out.println("3. Заплыв");//с заплывом та же история, но с поправкой, что кошки не плавают
        System.out.println("4. Добавить нового участника");
        System.out.println("5. Вернуться в главное");
        System.out.println("6. Выход");

        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            switch (num) {//свич кочует из одного дз в другой
                case 1 -> {
                    System.out.printf("Сегодня на выставке представлено %d кошек.%n%n", cats.getCatCount());
                    showCatMenu(cats);
                }
                case 2 -> {
                    if (cats.catCount > 0) {
                        int distance=cats.setDistance();
                        int catIndex = cats.chooseCat(cats);
                        if (cats.getCats()[catIndex].run(distance)){
                            System.out.printf("Кошка по кличке %s смогла пробежать %d метров.%n%n ", cats.getCats()[catIndex].getName(),distance);
                            showCatMenu(cats);
                        }else
                            System.out.printf("Кошка по кличке %s смогла пробежать только %d метров.%nЕй осталось пробежать %d метров %n%n ", cats.getCats()[catIndex].getName(),cats.getDogs()[catIndex].getRunMax(),(distance-cats.getCats()[catIndex].getRunMax()));
                        showCatMenu(cats);
                    } else {
                        System.out.println("Кошек нет бежать некому");
                        showCatMenu(cats);

                    }
                }/* cats.getCats()[0].run(cats.setDistance());
                        showCatMenu(cats);*/
                case 3 -> {
                    if (cats.catCount > 0) {
                        int distance= cats.setDistance();
                        int catIndex = cats.chooseCat(cats);
                        if (cats.getCats()[catIndex].swim(distance)) {
                            System.out.println("Какая удивительная кошка!");
                            showCatMenu(cats);
                        } else {
                            System.out.printf("Кошка по кличке %s умеет плавать! Но не хочет.%n",cats.getCats()[catIndex].getName());
                            showCatMenu(cats);
                        }
                    } else {
                        System.out.println("На выставке нет ни одной кошки!");
                        showCatMenu(cats);

                    }
                }
                case 4 -> {

                    if (cats.addCat()) {
                        System.out.printf("Добавлен новый участник кошка - %s%n%n", cats.getCats()[cats.getCatCount() - 1].getName());
                        showCatMenu(cats);
                    } else {
                        showCatMenu(cats);
                    }
                }
                case 5 -> {
                    System.out.println("Выходим в главное меню");
                    menu(cats);
                }
                case 6 -> {
                    System.out.println("Заходите еще!");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Вы ввели неверное значение, пожалуйста попробуйте снова");
                    showCatMenu(cats);
                } //закрыли default
            }//закрыли switch
        } else {
            System.out.println("Вы ввели не число, пожалуйста попробуйте снова");
            showCatMenu(cats);

        }//это если пользователь ввел не число

    }
    private static void showDogMenu(PetShow dogs) {//переделываем тоже меню на пёсиков и да можно было бы работать с той же переменной, общей
        //но боялся запутаться да и выглядит более понятно
        System.out.println();
        System.out.println("Выставка собак");//а может наоборот еще больше ввожу в заблуждение
        System.out.println("1. Посмотреть общее количество собак");
        System.out.println("2. Забег");
        System.out.println("3. Заплыв");//с заплывом та же история
        System.out.println("4. Добавить нового участника");
        System.out.println("5. Вернуться в главное");
        System.out.println("6. Выход");

        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            switch (num) {//свич кочует из одного дз в другой
                case 1 -> {
                    System.out.printf("Сегодня на выставке представлено %d собак.%n", dogs.getDogCount());
                    showDogMenu(dogs);
                }
                case 2 -> {
                    if (dogs.dogCount > 0) {
                        int distance=dogs.setDistance();
                        int dogIndex = dogs.chooseDog(dogs);
                        if (dogs.getDogs()[dogIndex].run(distance)){
                            System.out.printf("Собака по кличке %s смогла пробежать %d метров.%n%n ", dogs.getDogs()[dogIndex].getName(),distance);
                            showDogMenu(dogs);
                        }else
                            System.out.printf("Собака по кличке %s смогла пробежать только %d метров.%nЕй осталось пробежать %d метров %n%n ", dogs.getDogs()[dogIndex].getName(),dogs.getDogs()[dogIndex].getRunMax(),(distance-dogs.getDogs()[dogIndex].getRunMax()));
                        showDogMenu(dogs);
                    } else {
                        System.out.println("Были бы здесь собаки они бы побегали");
                        showDogMenu(dogs);
                    }
                }
                case 3 -> {
                    if (dogs.dogCount > 0) {
                        int distance=dogs.setDistance();
                        int dogIndex = dogs.chooseDog(dogs);
                        if (dogs.getDogs()[dogIndex].swim(distance)){
                            System.out.printf("Собака по кличке %s смогла проплыть %d метров.%n%n ", dogs.getDogs()[dogIndex].getName(),distance);
                            showDogMenu(dogs);
                        }else
                            System.out.printf("Собака по кличке %s смогла проплыть только %d метров.%nЕй осталось проплыть %d метров %n%n ", dogs.getDogs()[dogIndex].getName(),dogs.getDogs()[dogIndex].getSwimMax(),(distance-dogs.getDogs()[dogIndex].getSwimMax()));
                        showDogMenu(dogs);
                    } else {
                        System.out.println("Были бы здесь собаки они бы поплавали");
                        showDogMenu(dogs);
                    }
                }
                case 4 -> {

                    if (dogs.addDog()) {
                        System.out.printf("Добавлен новый участник пёс - %s%n%n", dogs.getDogs()[dogs.getDogCount() - 1].getName());
                        showDogMenu(dogs);
                    } else {
                        showDogMenu(dogs);
                    }
                }
                case 5 -> {
                    System.out.println("Выходим в главное меню");
                    menu(dogs);
                }
                case 6 -> {
                    System.out.println("Заходите еще!");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Вы ввели неверное значение, пожалуйста попробуйте снова");
                    showDogMenu(dogs);
                } //закрыли default
            }//закрыли switch
        } else {
            System.out.println("Вы ввели не число, пожалуйста попробуйте снова");
            showDogMenu(dogs);

        }//это если  пользователь ввел не число


    }




}
