package HomeWork1.lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    CyclicBarrier cyclicBarrier;
    CountDownLatch countDownLatch;
    private int finishPlace;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cb;
        this.countDownLatch = cdl;
        this.finishPlace = 0;


    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  System.out.println("GOOOOOOOOOOOO");
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        this.finishPlace = race.getFinishPlace() + 1;
        race.setFinishPlace(this.finishPlace);
        countDownLatch.countDown();
    }


    public int getFinishPlace() {
        return finishPlace;
    }
}