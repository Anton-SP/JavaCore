package HomeWork1.lesson8;

public class Wall implements Obstacles {
    int height;

    @Override
    public boolean overcomeAnObstacle(Participants participant) {
        return false;
    }

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}

