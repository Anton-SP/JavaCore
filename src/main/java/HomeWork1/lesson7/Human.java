package HomeWork1.lesson7;

public class Human {
    private String name;
    private int money;
    private Cat[] cats;
    private int catCount;
    private Plate plate;


    public Human(String name) {
        this.name = name;
        this.money = 50;
        cats = new Cat[5];
        this.catCount = 0;
        plate = new Plate(10,20);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void goWork(){
        this.setMoney(this.getMoney()+20);
            }

    public Cat[] getCats() {
        return cats;
    }

    public void setCats(Cat[] cats) {
        this.cats = cats;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public int getCatCount() {
        return catCount;
    }

    public void setCatCount(int catCount) {
        this.catCount = catCount;
    }
}
