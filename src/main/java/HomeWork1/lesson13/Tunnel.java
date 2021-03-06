package HomeWork1.lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semaphore;
    public Tunnel(Semaphore sm) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.semaphore= sm;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

