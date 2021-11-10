package HomeWork1.lesson8;

public class Treadmill implements Obstacles {
    int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public void overcomeAnObstacle(Participants participant) {
        if (this.getDistance()<=participant.getRun()){
            participant.run();
        } else {
            participant.fall();


        }
    }

    @Override
    public void info() {
        System.out.printf("Obstacle - Treadmill distance - %d%n%n",this.getDistance());
    }
}
