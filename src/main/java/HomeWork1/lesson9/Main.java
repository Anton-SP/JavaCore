package HomeWork1.lesson9;


public class Main {
    public static void main(String[] args) {
        int a = 4, b = 4;//few arguments for test
        int c = 3, f = 5;

        String[][] array = new String[a][b];//arrays for test too
        String[][] array2 = new String[c][f];

        arrayFillAndPrintAuto(array);//fills the array with random numbers from 0 to 9
       // arrayFillAndPrintAuto(array2); //same but for another array

        changeArrayElement(array, 3, 2);//method for changing one of the array elements to simulate the situation with an exception

        System.out.println("The sum of all elements in the array is:");
        arraySum(array);//sums the elements of an array with exception handling, this is homework!


    }


    //perfect example for test. every element of array certainly can parse to int
    private static void arrayFillAndPrintAuto(String[][] array) {//fill and print array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ((int) (Math.random() * 10) + "");//use random to create integer from 0 to 9 and sum "" to make a string out of them
                //this is for speed of counting all elements are equal to 1
                //  array[i][j] = 1
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static void arraySum(String[][] array) {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("It's look like array's size it not 4x4! by the row");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException("It's look like array's size it not 4x4! by the collum");
                } else {
                    for (int j = 0; j < array[i].length; j++) {

                                sum += checkElement(array,i,j);
                    }

                }
            }
        }
        System.out.println(sum);
    }

    private static void changeArrayElement(String[][] array, int i, int j) {
        try {
        array[i][j] = "Oops this definitely won't be able to  be parsed into integer";}
        catch (Exception e) {
            throw new MyArraySizeException("Oh no no no... You know the size of the array don't you?");
        }
    }

  //check element for parsing
    private static int checkElement (String[][] array,int i, int j){
        String temp =  array[i][j];
      try {
            return Integer.parseInt(temp);
        } catch (Exception e) {
             throw new MyArrayDataException(temp,i,j);
         }
    }


}
