package HomeWork1.lesson10;

public class Main {
    public static void main(String[] args) {
        //test for task1
        ForTask1 <Integer> array1 = new ForTask1<>();
        test1(array1);

        Apple apple = new Apple();
        Orange orange = new Orange();


        Box <Apple> box1 = new Box<>(5); //box for apples
        Box <Orange> box2 = new Box<>(5);//box for oranges
        Box <Apple> box3 = new Box<>();//box for apples
        Box <Orange> box4 = new Box<>();//box for oranges


        System.out.println('Ⓐ'+ " this is mark for apple"); //apple
        System.out.println('Ⓞ'+ " this is mark for orange"); //orange



        //add few fruits in the boxes
        box1.addBox(apple);
        box1.addBox(apple);
        box1.addBox(apple);
        box3.addBox(apple);
        box3.addBox(apple);
        box2.addBox(orange);
        box2.addBox(orange);
        //show boxes
        box1.checkBox();
        box2.checkBox();
        box3.checkBox();
        box4.checkBox();
        //
        System.out.println("compare boxes");
        box1.checkBox();
        box2.checkBox();
        //box1.compare(box2); it work. but the task is make it boolean and a made it. and if it boolean let's check boolean
        //but I think in this example inside the method it looks better
        if (box1.compare(box2)) {
            System.out.printf("Boxes are equal by weight! and it is - %f%n", box1.getWeight());
        } else {
            System.out.printf("Boxes are NOT equal by weight! First box's weight is %f, second box's weight is %f%n",box1.getWeight(),box2.getWeight());
        }

        System.out.println("now add a new apple and compare boxes again");
        box1.addBox(apple);
        box1.checkBox();
        box2.checkBox();
        // box1.compare(box2);
        if (box1.compare(box2)) {
            System.out.printf("Boxes are equal by weight! and it is - %f%n", box1.getWeight());
        } else {
            System.out.printf("Boxes are NOT equal by weight! First box's weight is %f, second box's weight is %f%n", box1.getWeight(), box2.getWeight());
        }

        System.out.println("current state of boxes");
        box1.checkBox();
        box2.checkBox();
        box3.checkBox();
        box4.checkBox();

        System.out.println("lets take this 2 boxes ");
        box1.checkBox();
        box3.checkBox();
        System.out.println(" and merge them");
        box1.pourBox(box3);
        box1.checkBox();
        box3.checkBox();

    }

    private static void test1(ForTask1 test) {
        for (int i = 0; i < test.array.length; i++) {
            test.array[i]=1+i;
            System.out.printf(test.array[i]+" ");
        }
        System.out.println();

        test.change(2,4);
        for (int i = 0; i < test.array.length; i++) {
            System.out.printf(test.array[i]+" ");
        }
        System.out.println();

    }
}

