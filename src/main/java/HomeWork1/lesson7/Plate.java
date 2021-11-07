package HomeWork1.lesson7;

public class Plate {
    private int foodCount;//how much food in the plate
    private int foodCapacity;//max capacity of plate

    public Plate(int foodCount, int foodCapacity) {
        this.foodCount = foodCount;
        this.foodCapacity = foodCapacity;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }

    public void setFoodCapacity(int foodCapacity) {
        this.foodCapacity = foodCapacity;
    }

}
