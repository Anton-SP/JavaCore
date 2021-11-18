package HomeWork1.lesson10;

public class ForTask1<E> {
    E[] array = (E[]) new Object[5];

    public void change(int i, int j) {
        if (i < array.length & j < array.length) {
            E temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        } else System.out.println("Wrong index!");
    }



}
