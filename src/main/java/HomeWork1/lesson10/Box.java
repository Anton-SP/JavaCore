package HomeWork1.lesson10;

import java.util.Arrays;

public class Box<E extends Fruit> {
    private E[] content;  //box for fruit
    private final static int DEFAULT_SIZE = 20; //default box size
    //it makes sense to make the size of the array static since the box has a limited volume, but we always can make bigger box....right?
    private int currentSize;




    public  Box(int size, E... content){
        this.content = content;
        /*И так не буду на анг чтобы не напутать
        обобщения и массивы еще тот головняк при инициализации
        констурктор его не воспринимает, оно и понятно он не знает сколько места выделить под массив так как тип данных неизвестен
        вроде бы спасла запись вида
        public Box(E... content) {
        this.content = content;
        это дало нам пустой массив длиной 0 для явы проблемы нет - место не выделили, но массив есть.
        а вот у нас проблема - массив есть, но ничего туда положить не можем так как длина 0 и при попытках
        изменении ява любезно нам говорит что длина вообще-то "final" и нечего её трогать, лежит себе и всё.
        на форумах дженерики и массивы частая тема оказывается, нашел вот такой костыль (в оригинале был использован при добавлении элемента, но мне тоже сойдет)
        и так есть массив и надо его как то расширить
         а расширим мы не его, а его копию через Arrays.copyOf где за исходный массив укажем наш "нулевой" массив, а длину зададим уже нужную нам
        получается мы 2 раза инициализируем массив в конструкторе
        */
        this.content = Arrays.copyOf(this.content,size);//костыль
        currentSize = 0;

    }


    public Box(E... content) {
        this.content = content;
        this.content = Arrays.copyOf(this.content,DEFAULT_SIZE);//костыль
        currentSize = 0;
    }

    //task 4 from homework
    public float getWeight() {
        float totalWeight=0;
        for (E curFruit : content
        ) {
            if (curFruit != null) {
                totalWeight+=curFruit.getWeight();
            }
        }
        return totalWeight;
    }

    //task 5 from homework
    public boolean compare(Box anotherBox){
        if (this.getWeight()==anotherBox.getWeight()) {
            //  System.out.printf("Boxes are equal by weight! and it is - %f%n",this.getWeight());

            return true;
        } else {// System.out.printf("Boxes are NOT equal by weight! First box's weight is %f, second box's weight is %f%n",this.getWeight(),anotherBox.getWeight());
            return false;}
    }

    //task 6 from homework
    //пересыпать в коробку = pour into a box...so
    public void pourBox (Box newBox){
        //first check that these are the same fruits

        if (this.getContent().getClass().equals(newBox.getContent().getClass()))
        {
            // second check if there is a place in the new box for all the fruits
            if (this.currentSize < (newBox.getContent().length - newBox.getCurrentSize())) {
                for (E curbox:this.getContent()
                ) {
                    if (curbox!=null) {
                        newBox.getContent()[newBox.getCurrentSize()] = curbox;
                        newBox.setCurrentSize(newBox.getCurrentSize()+1);
                    }
                }
                this.boxClear();
            }
            else {
                System.out.println("There not enough space in the new box");
            }
            System.out.println("Success");
        } else {System.out.println("There are different fruits in boxes, you cannot mix them.");}

    }

    public void boxClear(){
        for (int i = 0; i < this.currentSize; i++) {
            this.content[i]=null;

        }
        this.currentSize=0;
    }


    //task 7 from homework
    public void addBox(E newElement) {
        if (currentSize == content.length) {
            System.out.println("Warning! There is no free space left in the box!");
        } else {content[currentSize] = newElement;
            currentSize++;
        }
    }
    /*public void addBox(E newElement) {
        if (this.currentSize != content.length) {
            content[currentSize] = newElement;
            currentSize++;
            if (currentSize == content.length) {
                System.out.println("Warning! There is no free space left in the box!");
            } else {
                System.out.println("There is no free space left in the box!");
            }
        }
        System.out.println("BULL SHIT!");
    }*/


    public void checkBox() {
        for (E curContent : this.content
        ) {
            if (curContent != null) {
                curContent.draw();
            }
            else System.out.print("☒ ");
        }
        System.out.println();
    }


    public E[] getContent() {
        return content;
    }



    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }


}
