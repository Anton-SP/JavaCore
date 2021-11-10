package HomeWork1.lesson7;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int day = 0;
        System.out.println("Hi, this is house owner");
        System.out.println("And his name is...");
        Human owner = createHouseOwner();
        menu(owner);
        // status(owner);

    }


    private static void menu(Human owner) {
        status(owner);
        System.out.println("Please choose action:");
        System.out.println("1.Buy a cat");
        System.out.println("2.Feed cats");
        System.out.println("3.Add food to plate");
        System.out.println("4.End the day");
        System.out.println("5.Buy bigger plate + 20 max capacity - 20 coins");
        System.out.println("6.Go earn few coins + 20 coins");
        System.out.println("7.Exit");

        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            switch (num) {
                case 1 -> {
                    buyCat(owner);
                    menu(owner);
                }
                case 2 -> {
                    feedCats(owner);
                    menu(owner);
                }
                case 3 -> {
                    addFood(owner);
                    menu(owner);
                }
                case 4 -> {
                    dayEnd(owner);
                    menu(owner);
                }
                case 5 -> {
                    buyPlate(owner);
                    menu(owner);
                }
                case 6 -> {
                    goWork(owner);
                    menu(owner);
                }

                case 7 -> {
                    System.out.printf("This is where the story of %s and his cats ends, but everything will be fine with them!",owner.getName());
                    System.exit(0);
                }


                default -> {
                    System.out.println("default option!");
                    menu(owner);
                    ;
                } //close default
            }//close switch
        } else {
            System.out.println("You enter not a number!");

            menu(owner);

        }//это если пользователь ввел не число


    }




    private static Human createHouseOwner() {
        String ownerName;
        Scanner in = new Scanner(System.in);
        System.out.println("hint: enter the name of the owner of the house");
        if (in.hasNext()) {
            ownerName = in.nextLine();
            System.out.println("Welocome new owner " + ownerName + " !");
            return new Human(ownerName);
        } else {
            System.out.println("Sorry something went wrong, we create new human whiteout your help");
            return new Human("Jack");
        }
    }

    private static void buyCat(Human owner) {
        System.out.println("Enter cat's name");
        if (owner.getCatCount() < owner.getCats().length) {
            String name = "Cat1";
            int hungerMax = 5;
            Scanner in = new Scanner(System.in);
            if (in.hasNext()) {
                name = in.nextLine();
            }
            System.out.println("Enter max hunger of cat");
            if (in.hasNextInt()) {
                hungerMax = in.nextInt();
                owner.getCats()[owner.getCatCount()] = new Cat(name, hungerMax);
                owner.setCatCount((owner.getCatCount()) + 1);
            } else {
                System.out.println("Somethin went wrong.. try again");
                buyCat(owner);
            }

        } else System.out.println("there is no more space for another cat!");

    }


    private static void status(Human owner) {
        System.out.printf("%s have %d cats%n%n",owner.getName(),owner.getCatCount());
        System.out.printf("%s have %d coins%n%n",owner.getName(),owner.getMoney());
        System.out.printf("There are %d of food in the plate, max capacity is - %d%n%n",owner.getPlate().getFoodCount(),owner.getPlate().getFoodCapacity());

        for (Cat curcat : owner.getCats()
        ) {
            if (curcat != null) {
                if (curcat.isSatiety()) {

                    System.out.printf("Cat - %s is satiety%n", curcat.getName());
                } else {
                    System.out.printf("Cat - %s is hungry, he can eat %d%n%n ", curcat.getName(),curcat.getHungerCurrent());
                }
            }
        }
    }


    private static void feedCats(Human owner) {
        for (Cat curcat : owner.getCats()
        ) {
            if (curcat != null) {
               curcat.eat(owner.getPlate());
            }
        }
    }

    private static void addFood(Human owner) {
        owner.getPlate().setFoodCount(owner.getPlate().getFoodCapacity());
    //just fill the plate to max capacity
    }

    //day is over/ cats sleep and become hungry!
    private static void dayEnd(Human owner) {
        System.out.printf("The day comes to an end and %s goes to bed with his cats ... in the morning they will go hungry!%n%n",owner.getName());
        for (Cat curcat : owner.getCats()
        ) {
            if (curcat != null) {
                curcat.setHungerCurrent(curcat.getHungerMax());
                curcat.setSatiety(false);
            }
        }
    }


    private static void buyPlate(Human owner) {
        if (owner.getMoney()>=20) {
            owner.setMoney(owner.getMoney()-20);
            owner.getPlate().setFoodCapacity(owner.getPlate().getFoodCapacity()+20);
            System.out.printf("%s buy new plate! Max capacity increase + 20!%n%n",owner.getName());
        } else{
            System.out.println("Not enough coins");
        }

    }

    private static void goWork(Human owner) {
        System.out.println("You working rest of the day and earn few coins");
        owner.setMoney(owner.getMoney()+50);
        dayEnd(owner);
    }

}
