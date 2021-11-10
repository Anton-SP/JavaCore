package HomeWork1.lesson8;

public class Cat implements Jumpers, Runners, Participants  {
    int jumpHeight;
    int runDistance;

    public Cat(int jumpHeight, int runDistance) {
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public void jump() {
        System.out.println("Cat jumped ");
    }

    @Override
    public void run() {
        System.out.println("Cat is running  ");
    }
}
