package HomeWork1.lesson10;

public abstract class Fruit {
    float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public abstract void draw();



}
