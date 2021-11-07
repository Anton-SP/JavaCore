package HomeWork1.lesson6;

public class Cat extends Animal {
    private int runMax;


    public Cat(String animalName, int maxRunDistance) {
        super(animalName);
        this.runMax=maxRunDistance;
    }


    @Override
    boolean swim(int distance) {
        return false;
        //System.out.printf("Кошка по кличке %s умеет плавать! Но не хочет.%n", this.name);
    }

    @Override
    boolean run(int distance) {
        if (distance <= this.runMax) {

            return true;
        } else {

            return false;
        }
    }


    public int getRunMax() {
        return runMax;
    }

    public void setRunMax(int runMax) {
        this.runMax = runMax;
    }
}

