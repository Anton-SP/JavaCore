package HomeWork1.lesson13;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {

    private ArrayList<Stage> stages;
    private static int FINISH_PLACE;


    public ArrayList<Stage> getStages() {
        return stages;
    }


    public Race(Stage... stages) {

        this.stages = new ArrayList<>(Arrays.asList(stages));

    }

    public  int getFinishPlace() {
        return FINISH_PLACE;
    }

    public  void setFinishPlace(int finishPlace) {
        FINISH_PLACE = finishPlace;
    }



}

