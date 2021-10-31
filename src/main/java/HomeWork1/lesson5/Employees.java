package HomeWork1.lesson5;


import java.util.Scanner;

public class Employees {

    private String name;//ФИО сотрудника
    private String position;//должность
    private String email;
    private int phoneNumber;
    private double salary;
    private int age;

    public Employees(String name, String position, String email, int phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employees(String name){
        this(name,"","",0,0,0);

    }
    //java: call to this must be first statement in constructor
    // хотел ссделать констуктор но получается всё равно метод который вызовет констурктор с заданными параметрами
    // для интерактивного ввода всех данных при создании экземпляра класса
    /*public void addEmployeeInteractive(){
        //нужны переменные для хранения всех занчений который подставим в итоговый this
        //для удобства дам такие же названия но с префиксом t - temp
        //да не положенно и не принято, но я учусь надо как то логику разгариничить и понять
        String tName="";
        String tPosition;
        String tEmail;
        int tPhone;
        double tSalary;
        int tAge;
        // запросить сканером каждое поле, проверить на соотвествие (строка чтобы была не пустая например)
        //и внести в наши переменные ввеенные данные
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя нового сотрудника:");
        if (in.hasNext()) {
            tName=in.toString();
            in.next();
        }
        new Employees(tName,"","",0,0,0);
        //если класс должен быть самодостаточным по принципу инкапсуляции т.е. содержать свои атрибуты и методы для их обработки как
        //создать в инерактивном режиме экземпляр класса если все входящие значения долждны быть переданы из вне
    }*/






    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

     void printInfo(){
         System.out.printf("Сотрудник - %s занимает должность - %s.%nЕго контактные данные:%n email: %s.%n телефон: %s.%n Оклад: %s.%n Возвраст: %s%n%n ",name,position,email,phoneNumber,salary,age);
     }






}
