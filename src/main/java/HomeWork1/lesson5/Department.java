package HomeWork1.lesson5;

import java.util.Scanner;

public class Department {
    private Employees[] department;//отдел это массив сотрудников
    private String departmentName; //отделу необходимо название
    private int employeesNumber;//количесвто сотрудников
    private int maxNumber;//макс количесво в отделе


    public Department(String depName, int maxCount) {
        this.departmentName = depName;
        this.department = new Employees[maxCount];
        this.employeesNumber = 0;
        this.maxNumber = maxCount;
    }

    public boolean addEmployee(Employees employee) {
        if (employeesNumber == maxNumber) {
            return false;
        }
        department[employeesNumber++] = employee;
        return true;
    }

    public Employees[] getDepartment() {
        return department;
    }

    public void setDepartment(Employees[] department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public boolean addEmployee() {
        String tName = "";
        String tPosition = "";
        String tEmail = "";
        int tPhone = 0;
        double tSalary = 0;
        int tAge = 0;
        if (this.maxNumber > this.employeesNumber) {
            // запросить сканером каждое поле, проверить на соотвествие (строка чтобы была не пустая например)
            //и внести в наши переменные введненные данные
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя нового сотрудника:");
            if (in.hasNext()) {//будет висеть пока что о не введут а так как в строку переводится всё то в этой ветке элсе можно пропустить
                tName = in.nextLine();//считываем всю строку с пробелами и тд и переносим ввод на новую строку(пустую)
//            System.out.println(tName);

            }
            System.out.println("Введите должность нового сотрудника:");
            if (in.hasNext()) {//
                tPosition = in.nextLine();
//            System.out.println(tPosition);

            }
            System.out.println("Введите почту нового сотрудника:");
            if (in.hasNext()) {//
                tEmail = in.nextLine();
//            System.out.println(tEmail);

            }
            System.out.println("Введите телефонный номер нового сотрудника:");
            if (in.hasNext() && in.hasNextInt()) {//если ввод не пустой и он может быть приведен к Int то всё хорошо
                tPhone = in.nextInt();
//            System.out.println(tPhone);
                in.nextLine();
            } else {//это называется "выкрутился"
                in.nextLine();
                System.out.println("Вы ввели невреное значение для поля номер телефона, будет использовано значение по умолчанию");
            }
            System.out.println("Введите зарплату нового сотрудника:");
            if (in.hasNext() && in.hasNextDouble()) {//если ввод не пустой и он может быть приведен к double то всё хорошо
                tSalary = in.nextDouble();
//            System.out.println(tSalary);
                in.nextLine();
            } else {
                in.nextLine();
                System.out.println("Вы ввели невреное значение для поля зарплата, будет использовано значение по умолчанию");

            }
            System.out.println("Введите возраст нового сотрудника:");
            if (in.hasNext() && in.hasNextInt()) {//если ввод не пустой и он может быть приведен к Int то всё хорошо
                tAge = in.nextInt();
//              System.out.println(tAge);
                in.nextLine();
            } else {
                in.nextLine();
                System.out.println("Вы ввели невреное значение для поля возраст, будет использовано значение по умолчанию");

            }
            // in.close();//передаем в констуктор все наши данные и закрываем ввод
            this.department[this.employeesNumber++] = new Employees(tName, tPosition, tEmail, tPhone, tSalary, tAge);

            return true;
        } else {
            System.out.println("В отделе максимальное количество сотруднков");
            return false;
        }
    }

    public void printDepartment() {
        if (this.employeesNumber > 0) {
            for (int i = 0; (i<this.employeesNumber); i++){
            department[i].printInfo();  }
        } else {
            System.out.printf("Выводить нечего, отдел %s пуст.%n", this.departmentName);
        }
    }

    public Employees getEmployee(int employee){
        return this.department[employee];
    }

}