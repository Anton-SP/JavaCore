package HomeWork1.lesson8;

public class Cat implements Participants  {
    String name;
    int jumpHeight;
    int runDistance;
    boolean status= true; //can the object continue to run or jump? for new cats - they can!

    public Cat(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getJump() {
        return jumpHeight;
    }

    @Override
    public int getRun() {
        return runDistance;
    }


    @Override
    public void jump() {
        System.out.printf("%s the cat  was able to jump over a wall %n",this.getName());
    }


    @Override
    public void run() {
        System.out.printf("%s the cat was able to run the distance on the treadmill%n",this.getName());
    }

    @Override
    public void fall() {
        System.out.printf("%s the cat could not could not pass the obstacle and drops out of the competition %n",this.getName());
        this.setStatus(false);
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
