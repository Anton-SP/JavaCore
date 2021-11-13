package HomeWork1.lesson8;

public class Wall implements Obstacles {
    int height;

    @Override
    public void overcomeAnObstacle(Participants participant) {
        if (this.getHeight()<=participant.getJump()){
            participant.jump();
        } else {
            participant.fall();


        }


    }

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void info() {
        System.out.printf("Obstacle - Wall height - %d%n%n",this.getHeight());
    }
}

