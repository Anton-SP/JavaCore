package HomeWork1.lesson8;

public class Robot implements  Jumpers, Runners, Participants {
    int jumpHeight;
    int runDistance;


    public Robot(int jumpHeight, int runDistance) {
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public void jump() {
        System.out.println("Robot jumped ");
    }


    @Override
    public void run() {
        System.out.println("Robot is running  ");
    }
}
