package HomeWork1.lesson11;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("TV");
        stringArray.add("table");
        stringArray.add("Table");
        stringArray.add("chair");
        stringArray.add("door");
        stringArray.add("Orange");
        stringArray.add("apple");
        stringArray.add("banana");
        stringArray.add("Orange");
        stringArray.add("door");
        stringArray.add("window");
        stringArray.add("door");
        stringArray.add("Table");
        stringArray.add("Table");
        stringArray.add("TV");
        //1st task part 1 - create String array
        System.out.print(stringArray);
        System.out.println();
        //1st task part 2 - find and display unique strings
        System.out.println(uniqueStrings(stringArray));
        //1st task part 3 - count the chip times each word occurs in the array
        countList(stringArray);
        System.out.println();
        System.out.println("End of task 1");
        System.out.println();

        Phonebook phonebook = new Phonebook();
        phonebook.add(123,"Smith");
        phonebook.add(134,"Jackson");
        phonebook.add(234,"Smith");
        phonebook.add(245,"Kelly");
        phonebook.add(345,"Smith");
        phonebook.add(455,"Smith");
        phonebook.printPhonebook();


        phonebook.get("Smith");


    }

    //1st task part 2 - find and display unique strings
    private static HashSet uniqueStrings(ArrayList<String> stringArray) {
        HashSet<String> tempSet = new HashSet<>();
        tempSet.addAll(stringArray);
        return tempSet;
    }


    //1st task part 3 - count the chip times each word occurs in the array
    private static void countList(ArrayList<String> arrayList) {
        int count = 0;
        //we can get list of unique word by creating set
        HashSet<String> uniqList = uniqueStrings(arrayList);
        //after that it is necessary to iterate over the original array and count the number of matches
        for (String curUniqString : uniqList
        ) {
            for (String curString : arrayList
            ) {
                if (curUniqString.equals(curString)) {
                    count++;
                }
           }
            System.out.printf("The word %s occurs %d times in the array%n", curUniqString, count);
            count = 0;
        }
    }





}
