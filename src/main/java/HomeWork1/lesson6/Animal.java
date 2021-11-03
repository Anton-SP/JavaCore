package HomeWork1.lesson6;

public abstract class Animal {

    private String name;// у каждого животного есть имя и оно будет наследоваться всеми классами(атрибут)

    public Animal(String animalName) {
        this.name = animalName;
    }

    abstract boolean swim(int distance);//животные бегают и плавают по разному поэтому каждый дочерний класс будет их реализовывать по своему

    abstract boolean run(int distance);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

