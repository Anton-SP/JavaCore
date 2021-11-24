package HomeWork1.lesson12;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        calc();
        calcTread();
    }


    private static void calc() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("First method complete time " + (System.currentTimeMillis() - a));
    }

    private static void calcTread() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long a = System.currentTimeMillis();
        float[] firstHalf = Arrays.copyOfRange(array, 0, (HALF));
        float[] secondHalf = Arrays.copyOfRange(array, (HALF), array.length);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < secondHalf.length; i++) {
                secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalf, 0, array, 0, HALF);
        System.arraycopy(secondHalf, 0, array, HALF, HALF);

        System.out.println("Second method complete time " + (System.currentTimeMillis() - a));

    }

}

