package HomeWork1.lesson9;

public class MyArrayDataException extends  NumberFormatException{
    public MyArrayDataException(String info,int i ,int j) {
        super(String.format("The element of array under index %d %d contains String '%s' that cannot be parsed to integer",i,j,info));

    }


}
