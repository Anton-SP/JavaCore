package HomeWork1.lesson8;

public class Human implements Jumpers, Runners, Participants {
    int jumpHeight;
    int runDistance;

    public Human(int jumpHeight, int runDistance) {
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public void jump() {
        System.out.println("Human jumped ");
    }

    @Override
    public void run() {
        System.out.println("Human is running  ");
    }
}
