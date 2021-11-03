package HomeWork1.lesson6;


import java.util.Scanner;

public class PetShow {
    private Dog[] dogs;
    private Cat[] cats;
    private Animal[] pets; //а тут мы будем использовать полиморфизм! просто потому что можем
    int dogCount = 0;
    int catCount = 0;
    int animalsCount = 0;
    int maxDog;
    int maxCat;


    public PetShow(int maxCat, int maxDog) {
        dogs = new Dog[maxDog];
        cats = new Cat[maxCat];
        pets = new Animal[maxDog + maxCat];
        this.maxDog = maxDog;
        this.maxCat = maxCat;
    }

    public int getDogCount() {
        return dogCount;
    }


    public int getCatCount() {
        return catCount;
    }


    public int getAnimalsCount() {
        return animalsCount;
    }


    public boolean addDog() {

        if (maxDog > dogCount) {
            String dogName = "Шарик";//имя по умолчанию
            int maxRunDistance = 500;
            int maxSwimDistance = 10;
            System.out.println("Введите кличку собаки");
            Scanner in = new Scanner(System.in);
            if (in.hasNext()) {
                dogName = in.nextLine();
                System.out.println();

            }
            System.out.printf("Введите максимальную дистанцию которую может пробежать собака %s%n", dogName);

            if (in.hasNextInt()) {
                maxRunDistance = Math.abs(in.nextInt());//защита от отрицательных значений

            } else {
                System.out.println("Извините вы ввели неверное значение будет использована максимальная дистанция по умолчанию");
            }

            System.out.printf("Введите максимальную дистанцию которую может проплыть собака %s%n", dogName);
            if (in.hasNextInt()) {
                maxSwimDistance = Math.abs(in.nextInt());

            } else {
                System.out.println("Извините вы ввели неверное значение будет использована максимальная дистанция по умолчанию");
            }
            dogs[dogCount] = new Dog(dogName, maxRunDistance, maxSwimDistance);
            pets[animalsCount] = dogs[dogCount];
            animalsCount++;
            dogCount++;
            return true;
        } else {
            System.out.println("Извините нет свободной конуры некуда поселить пёсика");
            return false;
        }
    }

    public boolean addCat() {

        if (maxCat > catCount) {
            String catName = "Барсик";//имя по умолчанию
            int maxRunDistance = 500;
            System.out.println("Введите кличку кошки");
            Scanner in = new Scanner(System.in);
            if (in.hasNext()) {
                catName = in.nextLine();
                System.out.println();

            }
            System.out.printf("Введите максимальную дистанцию которую может пробежать кошка %s%n", catName);

            if (in.hasNextInt()) {
                maxRunDistance = Math.abs(in.nextInt());//защита от отрицательных значений

            } else {
                System.out.println("Извините вы ввели неверное значение будет использована максимальная дистанция по умолчанию");
            }
            cats[catCount] = new Cat(catName, maxRunDistance);
            pets[animalsCount] = cats[catCount];
            catCount++;
            animalsCount++;
            return true;

        } else {
            System.out.println("Извините нет свободной коробки, котику некуда прилечь");
            return false;
        }
    }

    public Cat[] getCats() {
        return cats;
    }

    public Dog[] getDogs() {
        return dogs;
    }

    public int setDistance() {
        System.out.println("Введите дистанцию забега/заплыва");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            return Math.abs(in.nextInt());
        } else {
            System.out.println("Извините вы ввели неверное значение попробуйте еще раз");
            setDistance();
            return 200;
        }
    }

    public Animal[] getPets() {
        return pets;
    }

    public int chooseDog(PetShow dogs) {
        System.out.printf("%nВсего на выставке %d Выберите номер участника.%n", dogs.getDogCount());
        int i = 1;
        for (Dog curDog : dogs.getDogs()
        ) {

            if (curDog != null) {

                System.out.println(i + ". " + curDog.getName());
                i++;
            }

        }

        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            if (num > 0) {
                return (num - 1);
            } else {
                System.out.println("Участника с таким номером нет! попробуем еще раз");
                chooseDog(dogs);
            }

        } else {
            System.out.println("Вы ввели не число, попробуем еще раз");
            chooseDog(dogs);
        }
        return 0;
    }



    public int chooseCat(PetShow cats) {
        System.out.printf("%nВсего на выставке %d кошек Выберите номер участника.%n", cats.getCatCount());
        int i = 1;
        for (Cat curCat : cats.getCats()
        ) {

            if (curCat != null) {

                System.out.println(i + ". " + curCat.getName());
                i++;
            }

        }

        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            if (num > 0) {
                return (num - 1);
            } else {
                System.out.println("Участника с таким номером нет! попробуем еще раз");
                chooseCat(cats);
            }

        } else {
            System.out.println("Вы ввели не число, попробуем еще раз");
            chooseCat(cats);
        }
        return 0;
    }


}
