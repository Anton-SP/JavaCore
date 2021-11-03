package HomeWork1.lesson6;

public class Dog extends Animal {
    private int runMax;
    private int  swimMax;


    @Override
    boolean swim(int distance) {
        if (distance <= this.swimMax) {
            return true;
        }
        else {
            return false;
        }


        /*if (distance <= this.swimMax) {
            System.out.printf("Собака по кличке %s проплыла %d метров.%n%n ", this.name, distance);
        } else {
            System.out.printf("Собака по кличке %s проплыла только %d метров.%n%n ", this.name, swimMax);

        }*/
    }

    @Override
    boolean run(int distance) {
        if (distance <= this.runMax) {
            return true;
        }
        else {
            return false;
        }

       /* if (distance <= this.runMax) {
            System.out.printf("Собака по кличке %s пробежала %d метров.%n%n ", this.name, distance);
        } else {
            System.out.printf("Собака по кличке %s пробежала только %d метров.%n%n ", this.name, runMax);

        }*/
    }

    public Dog(String name,int runMax , int swimMax) {
        super(name);
        this.runMax = runMax;
        this.swimMax = swimMax;
    }

    public int getRunMax() {
        return runMax;
    }

    public void setRunMax(int runMax) {
        this.runMax = runMax;
    }

    public int getSwimMax() {
        return swimMax;
    }

    public void setSwimMax(int swimMax) {
        this.swimMax = swimMax;
    }
}