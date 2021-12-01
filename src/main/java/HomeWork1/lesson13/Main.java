package HomeWork1.lesson13;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class Main {

    public static final int CARS_COUNT = 4;
    static CyclicBarrier cyclicBarrierPrepare = new CyclicBarrier(CARS_COUNT + 1);//Используется для одновременного старта всех машин - потоков
    static Semaphore smaphoreTunnel = new Semaphore((int) Math.floor((CARS_COUNT / 2)));//используется для ограничения одновременного прохождения туннеля. Округление в меньшую сторону
    static CountDownLatch cdlEndRace = new CountDownLatch(CARS_COUNT);//отсчитывает машины которым необходимо пересечь финишную черту


    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(smaphoreTunnel), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrierPrepare, cdlEndRace);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cyclicBarrierPrepare.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            cdlEndRace.await();
            System.out.println();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //вывод позиций участников
        for (Car curCar : cars
        ) {
            if (curCar.getFinishPlace()==1) {
                System.out.printf("Победитель - %s он занял %d место %n", curCar.getName(), curCar.getFinishPlace());
            } else
            System.out.printf("%s занял %d место %n", curCar.getName(), curCar.getFinishPlace());
        }

    }

}


