package HomeWork1.lesson7;

public class Cat {
    private String name;//cat's name
    private int hungerMax; //how much food cat can eat, if hunger reach this value it is mean the cat is hungry
    private int hungerCurrent;//current level of hunger, it can't be more than hangerMax
    private boolean satiety; //if the cat is hungry it will return false

/*    public Cat(String name, int hungerMax, int hungerCurrent, boolean satiety) {
        this.name = name;
        this.hungerMax = hungerMax;
        this.hungerCurrent = hungerCurrent;
        this.satiety = satiety;
    }*/

    public Cat(String name, int hungerMax) {
        //then owner buy a new cat - cat is hungry!
        this.name = name;
        this.hungerMax = hungerMax;
        this.hungerCurrent = hungerMax;
        this.satiety = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHungerMax() {
        return hungerMax;
    }

    public void setHungerMax(int hungerMax) {
        this.hungerMax = hungerMax;
    }

    public int getHungerCurrent() {
        return hungerCurrent;
    }

    public void setHungerCurrent(int hungerCurrent) {
        this.hungerCurrent = hungerCurrent;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        if (isSatiety()) {
            System.out.printf("Cat %s is satiety!%n", this.getName());
        } else {
            /*if the current amount of food in the plate is greater than or equal to the cat's current hunger, the cat will eat its fill.
if there is not enough food, the cat will eat the available food but remain hungry
            */
            if (plate.getFoodCount() >= this.hungerCurrent) {
                int curHunger = this.getHungerCurrent();
                this.setHungerCurrent(plate.getFoodCount()-curHunger);
                plate.setFoodCount(plate.getFoodCount()-curHunger);
                System.out.printf("Cat %s ate %d food and become satiety!%n", this.getName(),curHunger);
                this.setSatiety(true);
            } else {
                int curFood = plate.getFoodCount();
                this.setHungerCurrent(this.getHungerCurrent()-curFood);
                plate.setFoodCount(0);
                System.out.printf("Cat %s ate %d food and still hungry!%n", this.getName(),curFood);

            }
        }
    }


}




