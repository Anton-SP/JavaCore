package HomeWork1.lesson5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Department testDep;//тестовый отдел, чтобы было с чем работать

        testDep = addDepartment();//создаем отдел
        System.out.printf("Отлично! создан отдел с именем %s и максимальным количесвом сотрудников равным %d%nДавайте продолжим.%n", testDep.getDepartmentName(), testDep.getMaxNumber());
        menu(testDep);

    }

    private static Department addDepartment() {
        String dName = "";
        int dMaxNumber = 0;
        Scanner in = new Scanner(System.in);
        System.out.printf("Добрый день, для начала работы необходимо создать отдел, давайте начем!%n Введите название нового отдела:%n");
        if (in.hasNext()) {//будет висеть пока что о не введут а так как в строку переводится всё то в этой ветке элсе можно пропустить
            dName = in.nextLine();//считываем всю строку с пробелами и тд и переносим ввод на новую строку(пустую)

        }
        System.out.println("Введите размер отдела");
        if (in.hasNext() && in.hasNextInt()) {//если ввод не пустой и он может быть приведен к Int то всё хорошо
            dMaxNumber = in.nextInt();

            in.nextLine();
        } else {//это называется "выкрутился"
            in.nextLine();
            System.out.println("Вы ввели невреное значение для поля максимальное колчичество сотрудников, будет использовано значение по умолчанию = 5");
            dMaxNumber = 5;
        }
        return (new Department(dName, dMaxNumber));
    }


    private static void menu(Department department) {
        System.out.println("Вы попали в меню выбора задачи, пожалуйста выберите из следующего списка:");
        System.out.println("1. Добавить сотрудника");
        System.out.println("2. Просмотреть весь отдел");
        System.out.println("3. Вывести список сотрудников кому больше 40 лет");
        System.out.println("4. Выход");

        Scanner in = new Scanner(System.in); //польлзовательски ввод
        System.out.println("Выберите желаемое действие");
        if (in.hasNextInt()) {  //проверка вводана число если true то выполняем меню
            int num = in.nextInt();
            //Switch
            switch (num) {
                case 1 -> {
                    if (department.addEmployee()) ;
                    System.out.println("Добавлен новый сотрудник!");
//
                    menu(department);
                }
                case 2 -> {
                    department.printDepartment();
                    menu(department);
                }
                case 3 -> {
                    sort40(department );

                    menu(department);
                }
                case 4 -> {
                    System.out.println("Было приятно поработать, всего хорошего!");

                }
                default -> {
                    System.out.println("Вы ввели неверное значение, пожалуста попробуйте снова");
                    menu(department);
                } //закрыли default
            }//закрыли switch
        } else {
            System.out.println("Вы ввели не число, пожалуста попробуйте снова");
            menu(department);
            ;
        }//это есл ипользователь ввел не число
        in.close();

    }

    private static void sort40(Department department) {
        System.out.println("Сотрудники старше 40 лет:");
        int count=0;
        if (department.getEmployeesNumber()!= 0) {//проверку на наличие сотруднико можно было бы вывести в отдеьный метод класса но тут всего в 2 местах.
            for (int i = 0; (i < department.getEmployeesNumber()); i++) {
                if (department.getEmployee(i).getAge() > 40) {//в задаче сказано старще 40 так что условие >3
                    department.getEmployee(i).printInfo();
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Все сотрудники моложе 40 лет");
            }
        } else {
            System.out.printf("Выводить нечего, отдел %s пуст.%n", department.getDepartmentName());
        }




    }

}
