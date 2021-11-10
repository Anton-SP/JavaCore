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
    public boolean overcomeAnObstacle(Participants participant) {

        return false;
    }
}
