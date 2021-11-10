package HomeWork1.lesson8;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat(10, 20);
        Cat cat2 = new Cat(9, 12);
        Cat cat3 = new Cat(15, 25);

        Human human1 = new Human(3, 15);
        Human human2 = new Human(4, 10);
        Human human3 = new Human(2, 20);

        Robot bot1 = new Robot(1, 200);
        Robot bot2 = new Robot(1, 150);
        Robot bot3 = new Robot(1, 100);

        Wall wall1 = new Wall(2);
        Wall wall2 = new Wall(10);
        Wall wall3 = new Wall(3);

        Treadmill treadmill1 = new Treadmill(10);
        Treadmill treadmill2 = new Treadmill(4);
        Treadmill treadmill3 = new Treadmill(20);


        Participants[] participants = new Participants[]{cat1, human1, bot1, cat2, human2, bot2, cat3, human3, bot3};
        Obstacles[] obstacles = new Obstacles[]{wall1, treadmill1, wall2, treadmill2, wall3, treadmill3};


    }





}