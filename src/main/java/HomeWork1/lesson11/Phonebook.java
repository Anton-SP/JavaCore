package HomeWork1.lesson11;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    HashMap<Integer, String> phonebook = new HashMap<>();


    public void add(int phone, String name) {
        this.phonebook.put(phone, name);
    }


    public HashMap<Integer, String> getPhonebook() {
        return phonebook;
    }

    public void get(String name) {
        for (Integer curKey : this.phonebook.keySet()
        ) {
            if (this.phonebook.get(curKey).equals(name)) {
                System.out.printf("Name - %s, Phone - number %d%n", this.phonebook.get(curKey), curKey);
            }
        }
    }

    public void printPhonebook() {
        for (Integer curKey : this.phonebook.keySet()
        ) {
            System.out.printf("Name - %s, Phone number - %d%n", this.phonebook.get(curKey), curKey);
        }
        System.out.println("End of phonebook");
    }


}
